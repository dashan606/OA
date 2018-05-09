package com.ssm.OaManager.web.hrm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.service.hrm.DeptService;
import com.ssm.OaManager.service.hrm.EmployeeService;
import com.ssm.OaManager.service.hrm.PositionService;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.PrivilegeFilter;
import org.apache.commons.beanutils.BeanUtils;


@Controller
public class EmployeeController {

	@Resource
	private EmployeeService employeeService;

	@Resource
	private PrivilegeFilter privilegeFilter;
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private PositionService positionService;

	
	
	/** 分页查询 */
	@RequestMapping("/hrm/getEmployeeByPage.action")
	public String getEmployByPage(HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		PageBean<Employee> pageBean = new PageBean<Employee>();
		List<Employee> emps = employeeService.findByPage(pageBean);
		
		request.setAttribute("emps", emps);
		return "/pages_hr/public_hr_employee.jsp";
	}

	/**
	 * 插入数据
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/hrm/insertEmployee.action")
	public String insertEmp(HttpServletRequest request) throws Exception {
		setPrivilegeFilterUser(request);
		Employee emp = editEmp(request);
		
		deptService.findAll();

		int num = employeeService.insert(emp);
		
		
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		}
		return "/hrm/getEmployeeByPage.action";
	}

	@RequestMapping("go.action")
	public String go(HttpServletRequest request){
		
		List<Department> depts = deptService.findAll();
		List<Position> positions = positionService .findAll();
		
		request.setAttribute("depts", depts);
		request.setAttribute("positions", positions);
		
		return "/pages_hr/public_hr_employee_add.jsp";
	}
	
	/**
	 * 封装员工数据
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */

	public Employee editEmp(HttpServletRequest request) throws Exception {
		/*Employee emp = new Employee();
		// 将当前上下文初始化给多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有 enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将rquest 变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			// 获得所有页面参数
			
			 * private Integer empId; private String empNumber; private String
			 * empName;
			 * 
			 * private String empSex; private Integer empAge; private Date
			 * empBrithday;
			 * 
			 * private Double empSalary; private String empTelephone; private
			 * String empAddress; private Date empEntryDate; private Integer
			 * MaritalStatus; private String empPhotoUrl;
			 * 
			 * private User user;
			 * 
			 * private Integer posId; private Integer depId; private Department
			 * dep; private Position pos;
			 

			String empNumber = multiRequest.getParameter("empNumber");
			String empName = multiRequest.getParameter("empName");
			String empSex = multiRequest.getParameter("empSex");
			String empAge = multiRequest.getParameter("empAge");
			String empBrithday = multiRequest.getParameter("empBrithday");
			String empSalary = multiRequest.getParameter("empSalary");
			String empTelephone = multiRequest.getParameter("empTelephone");
			String empAddress = multiRequest.getParameter("empAddress");
			String empEntryDate = multiRequest.getParameter("empEntryDate");
			String MaritalStatus = multiRequest.getParameter("maritalStatus");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			emp.setEmpNumber(empNumber);
			emp.setEmpName(empName);
			emp.setEmpSex(empSex);
			emp.setEmpAge(Integer.parseInt(empAge));
			emp.setEmpBrithday(sdf.parse(empBrithday));
			emp.setEmpSalary(new Double(empSalary));
			emp.setEmpTelephone(empTelephone);
			emp.setEmpAddress(empAddress);
			emp.setEmpEntryDate(sdf.parse(empEntryDate));
			emp.setMaritalStatus(Integer.valueOf(MaritalStatus));
			// 根据value值 获得 文件对象
			MultipartFile file = multiRequest.getFile("empPhotoUrl");

			if (file != null && !file.isEmpty()) {
				// 上传路径
				String path = multiRequest.getSession().getServletContext()
						.getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
				// 上传文件
				file.transferTo(new File(path));
				// 赋值路径信息
				emp.setEmpPhotoUrl(file.getOriginalFilename());
			}
		}
		return emp;*/
		//获取已登录用户 
				User user = (User) request.getSession().getAttribute("user");

				Employee emp = new Employee();
				Department dept = new Department();
				Position position = new Position();
				//拖过字节码文件后去official和flow的属性
				Field[] empFields = emp.getClass().getDeclaredFields();

				// 图片上传
				// 1.创建工厂对象
				FileItemFactory factory = new DiskFileItemFactory();
				// 2.文件上传核心工具类
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 3.设置上传 大小限制参数
				upload.setFileSizeMax(100000 * 1024 * 1024); // 单个文件大小限制
				upload.setSizeMax(50000000 * 1024 * 1024); // 总文件大小限制
				upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

				// 判断是否是上传的表单
				// <form 是否添加了此 enctype="multipart/form-data"
				if (upload.isMultipartContent(request)) {
					// 把请求数据转换为list集合
					List<FileItem> list = upload.parseRequest(request);

					// FileItem 代表请求的 内容（数据） 员工姓名、员工性别....
					for (FileItem item : list) {
						// jsp name属性值
						String name = item.getFieldName();
						// jsp 属性对应的value值
						String value = new String(item.getString().getBytes(
								"iso8859-1"), "utf-8");
						// 判断 是否上传 tiem
						if (!item.isFormField()) {

							if (item.getName() != null
									&& !"".equals(item.getName())) {
								// 获取tomcat，所在工程的，真实绝对路径
								String realPath = request.getSession()
										.getServletContext().getRealPath("/");
								// 调用上传 把item的文件内容 写入 另外一个文件
								// 创建文件
								File newFile = new File(realPath + "//",
										item.getName());
								item.write(newFile);
								item.delete();// 删除临时文件

								String eimg = "/images/" + item.getName();// 数据库保存字段

								emp.setEmpPhotoUrl(eimg);// 给emp对象 eimg赋值
							}
						} else { // 普通的item

							for(Field field : empFields){
								if(field.getName().equals(name)){
									if(field.getName().equals("empBrithday")||
											field.getName().equals("empEntryDate")){
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
										Date parse = sdf.parse(value);
										
										BeanUtils.setProperty(emp, name, parse);
									}else{
										if(field.getName().equals("deptId")){
											dept.setDeptId(Integer.parseInt(value));
											emp.setDep(dept);
										}else
										if(field.getName().equals("posId")){
											position.setPosId(Integer.parseInt(value));
											emp.setPos(position);
										}else{
											BeanUtils.setProperty(emp, name, value);
										}
									}
								}
							}
						}
					}
				}
		
		return emp;
	}

	@RequestMapping("/hrm/deleteEmp.action")
	public String deleteEmp(Integer empId, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = employeeService.deleteById(empId);
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		}
		return "/hrm/getEmployeeByPage.action";
	}

	@RequestMapping("/hrm/findEmpById.action")
	public String findEmp(Integer empId, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		Employee emp = employeeService.findById(empId);
		
		List<Department> depts = deptService.findAll();
		List<Position> positions = positionService .findAll();
		
		request.setAttribute("emp", emp);
		request.setAttribute("depts", depts);
		request.setAttribute("positions", positions);
		
		return "/pages_hr/public_hr_employee_edit.jsp";
	}

	@RequestMapping("/hrm/updateEmployee.action")
	public String updateEmp(HttpServletRequest request) throws Exception {
		setPrivilegeFilterUser(request);
		Employee emp = editEmp(request);
		int num = employeeService.updateEmp(emp);
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		}
		return "/hrm/getEmployeeByPage.action";
	}

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	

}
