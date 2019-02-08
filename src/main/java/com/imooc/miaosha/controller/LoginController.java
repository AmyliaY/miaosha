package com.imooc.miaosha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;
import com.imooc.miaosha.vo.LoginVo;

/**
* @author 全恒
*/

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/do_login")
	@ResponseBody
	public Result<Boolean> doLogin(LoginVo loginVo){
		log.info(loginVo.toString());
		return null;
	}
	
}
