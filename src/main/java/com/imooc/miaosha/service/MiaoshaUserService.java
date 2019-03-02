package com.imooc.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.LoginVo;

/**
* @author 全恒
*/

@Service
public class MiaoshaUserService {
	
	public static final String COOKIE_NAME_TOKEN = "token";
	
	@Autowired
	MiaoshaUserDao miaoshaUserDao;
	
	@Autowired
	RedisService redisService;

	public MiaoshaUser getById(long id){
		return miaoshaUserDao.getById(id);
	}

	public boolean login(HttpServletResponse response, LoginVo loginVo) {
		if(loginVo == null)
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		String mobile = loginVo.getMobile();
		String formPass = loginVo.getPassword();
		//判断手机号是否存在
		MiaoshaUser user = getById(Long.parseLong(mobile));
		if(user == null)
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		//验证密码
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
		if(!calcPass.equals(dbPass))
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		//生成cookie
		String token = UUIDUtil.uuid();
		redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
		return true;
	}

	public MiaoshaUser getByToken(String token) {
		if(StringUtils.isEmpty(token))
			return null;
		return redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
	}
}
