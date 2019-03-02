package com.imooc.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.util.ValidatorUtil;
import com.imooc.miaosha.vo.LoginVo;

/**
* @author 全恒
*/

@Controller
@RequestMapping("/goods")
public class GoodsController {

	private static Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	MiaoshaUserService userService;
	
	@RequestMapping("/to_list")
    public String toLogin(Model model,
    		@CookieValue(value=MiaoshaUserService.COOKIE_NAME_TOKEN, required=false)String cookieToken,
    		@RequestParam(value=MiaoshaUserService.COOKIE_NAME_TOKEN, required=false)String paramToken) {
		if(StringUtils.isEmpty(paramToken) && StringUtils.isEmpty(cookieToken))
			return "login";
		String token = StringUtils.isEmpty(paramToken)? cookieToken : paramToken;
		MiaoshaUser user = userService.getByToken(token);
		model.addAttribute("user", user);
        return "goods_list";
    }
	
	
}
