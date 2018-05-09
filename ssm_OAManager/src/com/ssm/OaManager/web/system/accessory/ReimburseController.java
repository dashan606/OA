package com.ssm.OaManager.web.system.accessory;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.service.system.accessory.ReimburseService;
import com.ssm.OaManager.web.BaseController;

/**
 * 报销的业务层
 * @author Administrator
 *
 */
@Controller
public class ReimburseController extends BaseController{

	//报销的业务接口
	private ReimburseService reimburseService;

	@Resource
	public void setReimburseService(ReimburseService reimburseService) {
		this.reimburseService = reimburseService;
	}


	/**
	 * 附件选择成功
	 * @param model
	 * @param flow
	 * @param reimburse
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="reimburse_selectOk.action")
	public String selectOk(Model model,FlowTemplate flow,Reimburse reimburse) throws Exception{

		//get请求转码
		String str = new String(flow.getFlowName().getBytes("iso8859-1"), "UTF-8");
		flow.setFlowName(str);

		//获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date());
		
		//将时间放入作用域
		model.addAttribute("date", date);

		//将流程放入作用域
		model.addAttribute("flow", flow);

		//将报销放入作用域
		model.addAttribute("reimburse", reimburse);

		model.addAttribute("s",Reimburse.ALREADY);
		
		//转发至公文添加页面
		return "forward:page/official/official_addView.jsp";
	}
}
