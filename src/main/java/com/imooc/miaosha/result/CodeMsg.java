package com.imooc.miaosha.result;
/**
* @author 全恒
*/
public class CodeMsg {

	private int code;
	private String msg;
	
	//根据模块定义异常
	//通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	//登陆模块异常 5002XX
	
	//商品模块异常 5003XX
	
	//订单模块异常 5004XX
	
	//秒杀模块异常 5005XX
	
	private CodeMsg(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
