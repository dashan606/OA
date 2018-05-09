package com.ssm.OaManager.utils;


/**
 * web帮助类
 * 
 * @author Administrator
 * 
 */
public class WebUtil {

	/**
	 * 通用的判断是否为空的方法
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		}

		return false;
	}

}
