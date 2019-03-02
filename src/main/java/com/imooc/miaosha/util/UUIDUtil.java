package com.imooc.miaosha.util;

import java.util.UUID;

/**
* @author 全恒
*/
public class UUIDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
