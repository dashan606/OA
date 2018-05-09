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
import com.ssm.OaManager.entity.fixedAsset.FortifyType;
import com.ssm.OaManager.service.fixedAsset.FortifyTypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;
/**
 * 增加类别控制层
 * @author Administrator
 *
 */
@Controller
public class FortifyTypeController extends BaseController {
	
	@Resource
	private FortifyTypeService fortifyTypeService;

	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setFortifyTypeService(FortifyTypeService fortifyTypeService) {
		this.fortifyTypeService = fortifyTypeService;
	}
	
	
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findFortifyTypeByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		List<FortifyType> pageBean = this.fortifyTypeService.findAll();
		model.addAttribute("pageBean", pageBean);
		return "/fixedAsset/oa_fortifyType_list.jsp";
		
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/saveFortifyType.action")
	public String insert(FortifyType fortifyType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		fortifyType.setFortifyTypeDate(new Date(System.currentTimeMillis()));
		int num = this.fortifyTypeService.insert(fortifyType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findFortifyTypeByPage.action";
	}
	
	/**
	 * 删除
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/deleteFortifyType.action")
	public String delete(Integer fortifyTypeId,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.fortifyTypeService.deleteById(fortifyTypeId);
		if(num==-1){
			request.setAttribute("result", "权限不足！");
		}else if(num==-2){
			request.setAttribute("result", "删除失败！");
		}
		return "/fixedAsset/findFortifyTypeByPage.action";
	}
	
	/**
	 * 修改
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/updateFortifyType.action")
	public String update(FortifyType fortifyType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.fortifyTypeService.update(fortifyType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findFortifyTypeByPage.action";
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByFortifyTypeId.action")
	public String findById(Integer fortifyTypeId,HttpServletResponse response,HttpServletRequest request){
		try {
			FortifyType fortifyType = this.fortifyTypeService.findById(fortifyTypeId);
				String functions = JSON.toJSONString(fortifyType);
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
