package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;

/**
* @author 全恒
*/

@Controller
@RequestMapping("/shuitu")
public class DemoController {
	
	@RequestMapping("/lulu")
	@ResponseBody
	String home(){
		return "hello,little lulululu";
	}
	
	/**
	 * controller层输出的数据有两种：
	 *	1、rest api json输出
	 *	2、页面 	
	 */
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello(){
		return Result.success("hello,shuitu");
	}
	
	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError(){
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model){
		model.addAttribute("name", "shuituwan");
		return "hello";
	}
	
}
