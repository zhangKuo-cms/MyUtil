package com.zhangkuo.common.utils;

public class MatchUtil {

	
	/**
	 * 验证邮箱格式
	 * @param email 要验证的邮箱
	 * @return 格式是否正确
	 */
	public static boolean isEmail(String email) {
		if (StringUtil.isEmpty(email)) return false;
		return email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	}
	
	/**
	 * 验证手机格式
	 * @param mobile 要验证的手机号码
	 * @return 格式是否正确
	 */
	public static boolean isMobile(String mobile){    
		if (StringUtil.isEmpty(mobile)) return false;
		return mobile.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    } 

}
