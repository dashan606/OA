package com.ssm.OaManager.web.hrm;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.service.hrm.PositionService;
import com.ssm.OaManager.utils.PrivilegeFilter;
import com.ssm.OaManager.web.BaseController;

/**
 * 岗位控制层
 * 
 * @author HUX
 * 
 */
@Controller
public class PositionController extends BaseController {

	@Resource
	private PositionService positionService;

	@Resource
	private PrivilegeFilter privilegeFilter;

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	public void setPrivilegeFilterUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		this.privilegeFilter.setUser(user);
	}

	/**
	 * 分页查询全部
	 * 
	 * @param positionId
	 * @return
	 */
	@RequestMapping("/pages_hr/findPositionPages.action")
	public String findByPage(Model model, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		List<Position> pageBean = this.positionService.findAll();

		// model.addAllAttributes(pageBean);
		request.setAttribute("pageBean", pageBean);

		return "/pages_hr/public_hr_position_add.jsp";

	}

	/**
	 * 添加
	 * 
	 * @param function
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_hr/insertPages.action")
	public String insert(Position position, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = this.positionService.insert(position);
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		}
		return "/pages_hr/findPositionPages.action";
	}

	/**
	 * 删除
	 * 
	 * @param positionId
	 * @return
	 */
	@RequestMapping("/pages_hr/deletePosition.action")
	public String delete(Integer positionId, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = this.positionService.deleteById(positionId);
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		} else if(num==-2) {
			request.setAttribute("result", "删除失败");
		}
		return "/pages_hr/findPositionPages.action";

	}

	/**
	 * 修改
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/pages_hr/updatePonsition.action")
	public String update(Position position, HttpServletRequest request) {
		setPrivilegeFilterUser(request);
		int num = this.positionService.updateById(position);
		if (num == -1) {
			request.setAttribute("result", "权限不足");
		}
		return "/pages_hr/findPositionPages.action";
	}

	@RequestMapping("/pages_hr/selectOnePonsition.action")
	public void findByFunId(Integer positionId, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Position position = this.positionService.findById(positionId);

			if (position == null) {
				response.getWriter().write("1");
			} else {
				String functions = JSON.toJSONString(position);
				// 发送给客户端
				response.getWriter().write(functions);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}