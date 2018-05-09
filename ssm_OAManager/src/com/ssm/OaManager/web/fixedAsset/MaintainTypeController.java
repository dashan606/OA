package com.ssm.OaManager.web.fixedAsset;

import java.io.IOException;
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
import com.ssm.OaManager.entity.fixedAsset.MaintainType;
import com.ssm.OaManager.service.fixedAsset.MaintainTypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;
/**
 * 增加类别控制层
 * @author Administrator
 *
 */
@Controller
public class MaintainTypeController extends BaseController  {
	
	@Resource
	private MaintainTypeService maintainTypeService;

	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setMaintainTypeService(MaintainTypeService maintainTypeService) {
		this.maintainTypeService = maintainTypeService;
	}

	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findMaintainTypeByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		List<MaintainType> pageBean = this.maintainTypeService.findAll();
		model.addAttribute("pageBean", pageBean);
		return "/fixedAsset/oa_maintainType_list.jsp";
		
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/saveMaintainType.action")
	public String insert(MaintainType maintainType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		maintainType.setMaintainTypeDate(new Date(System.currentTimeMillis()));
		int num = this.maintainTypeService.insert(maintainType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findMaintainTypeByPage.action";
	}
	
	/**
	 * 删除
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/deleteMaintainType.action")
	public String delete(Integer maintainTypeId,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.maintainTypeService.deleteById(maintainTypeId);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}else if(num==-2){
			request.setAttribute("result", "删除失败！");
		}
		return "/fixedAsset/findMaintainTypeByPage.action";
	}
	
	/**
	 * 修改
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/updateMaintainType.action")
	public String update(MaintainType maintainType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.maintainTypeService.update(maintainType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findMaintainTypeByPage.action";
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByMaintainTypeId.action")
	public String findById(Integer maintainTypeId,HttpServletResponse response,HttpServletRequest request){
		try {
			MaintainType maintainType = this.maintainTypeService.findById(maintainTypeId);
				String functions = JSON.toJSONString(maintainType);
				// 发送给客户端
				response.getWriter().write(functions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}
}
