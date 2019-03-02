package com.imooc.miaosha.redis;

/**
* @author 全恒
*/

public class MiaoshaUserKey extends BasePrefix {

	private static final int TOKEN_EXPIRE = 3600*24*2;
	
	private MiaoshaUserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	
	public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");

}
