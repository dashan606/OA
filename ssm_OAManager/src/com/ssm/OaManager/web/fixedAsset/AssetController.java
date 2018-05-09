package com.ssm.OaManager.web.fixedAsset;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.fixedAsset.Asset;
import com.ssm.OaManager.entity.fixedAsset.AssetType;
import com.ssm.OaManager.entity.fixedAsset.FortifyType;
import com.ssm.OaManager.entity.hrm.Department;
import com.ssm.OaManager.service.fixedAsset.AssetService;
import com.ssm.OaManager.service.fixedAsset.AssetTypeService;
import com.ssm.OaManager.service.fixedAsset.FortifyTypeService;
import com.ssm.OaManager.service.hrm.DeptService;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

@Controller
public class AssetController extends BaseController {
	
	@Resource
	private AssetService assetService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private FortifyTypeService fortifyTypeService;
	
	@Resource
	private AssetTypeService assetTypeService;

	@Resource
	private DeptService deptService;
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findAssetByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		List<Asset>  pageBean = this.assetService.findAll();
		model.addAttribute("pageBean", pageBean);
		
		return "/fixedAsset/oa_asset_list.jsp";
		
	}
	
	/**
	 * 查询当前用户的资产
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findAssetAllUserId.action")
	public String findByUserAll(Model model, HttpServletRequest request){
		setPrivilegeFilterUser(request);
		PageBean<Asset> pageBean = new PageBean<Asset>();
		User user = (User) request.getSession().getAttribute("user");
		pageBean.getParaMap().put("userId", user.getUserId());
		pageBean.setPageSize(1000);
		this.assetService.findPageBean(pageBean);
		model.addAttribute("pageBean", pageBean);
		
		return "/fixedAsset/oa_assetUser_list.jsp";
		
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/saveAsset.action")
	public String insert(Asset asset,HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		asset.setAssetDate(new Date(System.currentTimeMillis()));
		int num = this.assetService.insert(asset);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetByPage.action";
	}
	
	/**
	 * 删除
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/deleteAsset.action")
	public String delete(String assetNo,HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		int num = this.assetService.deleteById(assetNo);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetByPage.action";
	}
	
	/**
	 * 修改
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/updateAsset.action")
	public String update(String usingUrl,Asset asset,HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		if(usingUrl!=null&&usingUrl.trim().equals("1")){
			asset.setUsingDate(new Date(System.currentTimeMillis()));
		}
		int num = this.assetService.update(asset);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetByPage.action";
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByAssetId.action")
	public String findById(String assetNo,HttpServletResponse response,HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		try {
				Asset asset = this.assetService.findById(assetNo);
				String functions = JSON.toJSONString(asset);
				// 发送给客户端
				response.getWriter().write(functions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询全部用户 资产 维护类型
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByAllUAFP.action")
	public String findByAllUAM(HttpServletResponse response,HttpServletRequest request){
		try {
				setPrivilegeFilterUser(request);
				List<Object> obj = new ArrayList<Object>();
				List<Department> departments =this.deptService.findAll();
				List<FortifyType> fortifyTypes = this.fortifyTypeService.findAll();     
				List<AssetType> assetTypes = this.assetTypeService.findAll();
				obj.add(fortifyTypes);
				obj.add(assetTypes);
				obj.add(departments);
			String assets1 = JSON.toJSONString(obj);
			// 发送给客户端
			response.getWriter().write(assets1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询全部用户 资产 维护类型
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByAllU.action")
	public String findByAllU(Integer num,HttpServletResponse response,HttpServletRequest request){
		try {
				setPrivilegeFilterUser(request);
					User user = new User();
					Department dept = new Department();
					dept.setDeptId(num);
					user.setDep(dept);
					List<User> users =this.userService.findByDeptId(user);
			String assets1 = JSON.toJSONString(users);
			// 发送给客户端
			response.getWriter().write(assets1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public void setFortifyTypeService(FortifyTypeService fortifyTypeService) {
		this.fortifyTypeService = fortifyTypeService;
	}

	public void setAssetTypeService(AssetTypeService assetTypeService) {
		this.assetTypeService = assetTypeService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public void setPrivilegeFilter(PrivilegeFilter privilegeFilter) {
		this.privilegeFilter = privilegeFilter;
	}

	
}
