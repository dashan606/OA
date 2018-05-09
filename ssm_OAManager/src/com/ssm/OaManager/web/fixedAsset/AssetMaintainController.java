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
import com.ssm.OaManager.entity.fixedAsset.AssetMaintain;
import com.ssm.OaManager.entity.fixedAsset.MaintainType;
import com.ssm.OaManager.service.fixedAsset.AssetMaintainService;
import com.ssm.OaManager.service.fixedAsset.AssetService;
import com.ssm.OaManager.service.fixedAsset.MaintainTypeService;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;
/**
 * 固定资产维护控制层
 * @author Administrator
 *
 */
@Controller
public class AssetMaintainController extends BaseController  {
	
	@Resource
	private AssetMaintainService assetMaintainService;

	@Resource
	private UserService userService;
	
	@Resource
	private MaintainTypeService maintainTypeService;
	
	@Resource
	private AssetService assetService;
	
	@Resource
	private PrivilegeFilter privilegeFilter;
	
	public void setFortifyTypeService(AssetMaintainService assetMaintainService) {
		this.assetMaintainService = assetMaintainService;
	}
	
	
	/**
	 * 分页查询全部
	 * @param currentPage
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/fixedAsset/findAssetMaintainByPage.action")
	public String findByPage(Model model, HttpServletRequest request){
		List<AssetMaintain> pageBean = this.assetMaintainService.findAll();
		model.addAttribute("pageBean", pageBean);
		return "/fixedAsset/oa_assetMaintain_list.jsp";
		
	}
	
	/**
	 * 添加
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/saveAssetMaintain.action")
	public String insert(String massage,AssetMaintain assetMaintain,HttpServletRequest request){
		 setPrivilegeFilterUser(request);
		assetMaintain.setMaintainDate(new Date(System.currentTimeMillis()));
		int num = this.assetMaintainService.insert(assetMaintain);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		if(massage!=null&&"".equals(massage)){
			if(massage.equals("1")){
				return "/fixedAsset/findAssetByPage.action";
			}
		}
		return "/fixedAsset/findAssetMaintainByPage.action";
	}
	
	/**
	 * 删除
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/deleteAssetMaintain.action")
	public String delete(Integer assetMaintainId,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.assetMaintainService.deleteById(assetMaintainId);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetMaintainByPage.action";
	}
	
	/**
	 * 修改
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/updateAssetMaintain.action")
	public String update(AssetMaintain assetMaintain,HttpServletRequest request){
		setPrivilegeFilterUser(request);
		int num = this.assetMaintainService.update(assetMaintain);
		if(num==-1){
			request.setAttribute("result", "权限不足");
		}
		return "/fixedAsset/findAssetMaintainByPage.action";
	}

	/**
	 * 查询
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/fixedAsset/findByAssetMaintainId.action")
	public String findById(Integer assetMaintainId,HttpServletResponse response,HttpServletRequest request){
		try {
			AssetMaintain assetMaintain = this.assetMaintainService.findById(assetMaintainId);
				String functions = JSON.toJSONString(assetMaintain);
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
	@RequestMapping("/fixedAsset/findByAllUAM.action")
	public String findByAllUAM(Integer assetMaintainId,HttpServletResponse response,HttpServletRequest request){
		try {
				List<Object> obj = new ArrayList<Object>();
				List<User> users = this.userService.findAll();
				List<Asset> assets = this.assetService.findAll();
				List<MaintainType> mainmtainTypes = this.maintainTypeService.findAll();
				obj.add(users);
				obj.add(assets);
				obj.add(mainmtainTypes);
			String assets1 = JSON.toJSONString(obj);
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
	
	public void setAssetMaintainService(AssetMaintainService assetMaintainService) {
		this.assetMaintainService = assetMaintainService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void setMaintainTypeService(MaintainTypeService maintainTypeService) {
		this.maintainTypeService = maintainTypeService;
	}


	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	
}
