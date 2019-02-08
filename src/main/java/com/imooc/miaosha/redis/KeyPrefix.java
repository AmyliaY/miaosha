package com.imooc.miaosha.redis;
/**
* @author 全恒
*/
public interface KeyPrefix {

	//比较器
	public int expireSeconds();
	
	public String getPrefix();
	
}
