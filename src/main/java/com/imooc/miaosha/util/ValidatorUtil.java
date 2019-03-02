package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
* @author 全恒
*/
public class ValidatorUtil {
	
	public static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

	public static boolean isMobile(String src){
		if(StringUtils.isEmpty(src)){
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}
	
/*	public static void main(String[] args) {
		System.out.println(isMobile("15555555555"));
		System.out.println(isMobile("1559988556"));
	}*/
}
