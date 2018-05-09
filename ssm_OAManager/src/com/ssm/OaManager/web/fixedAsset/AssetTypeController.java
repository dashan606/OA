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
import com.ssm.OaManager.entity.fixedAsset.AssetType;
import com.ssm.OaManager.service.fixedAsset.AssetTypeService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

/**
 * 资产类型控制层
 * @author Administrator
 *
 */
@Controller
public class AssetTypeController extends BaseController {
	
	@Resource
	private AssetTypeService assetTypeService;

	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setAssetTypeService(AssetTypeService assetTypeService) {
		this.assetTypeService = assetTypeService;
	}
	
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findAssetTypeByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		List<AssetType> pageBean = this.assetTypeService.findAll();
		model.addAttribute("pageBean", pageBean);
		return "/fixedAsset/oa_assetType_list.jsp";
		
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/saveAssetType.action")
	public String insert(AssetType assetType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		assetType.setAssetTypeDate(new Date(System.currentTimeMillis()));
		int num = this.assetTypeService.insert(assetType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetTypeByPage.action";
	}
	
	/**
	 * 删除
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/deleteAssetType.action")
	public String delete(Integer assetTypeId,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.assetTypeService.deleteById(assetTypeId);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetTypeByPage.action";
	}
	
	/**
	 * 修改
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/updateAssetType.action")
	public String update(AssetType assetType,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.assetTypeService.update(assetType);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetTypeByPage.action";
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByAssetTypeId.action")
	public String findById(Integer assetTypeId,HttpServletResponse response,HttpServletRequest request){
		try {
			AssetType assetType = this.assetTypeService.findById(assetTypeId);
				String functions = JSON.toJSONString(assetType);
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
