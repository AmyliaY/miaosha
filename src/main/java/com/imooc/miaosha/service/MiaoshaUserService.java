package com.imooc.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.vo.LoginVo;

/**
* @author 全恒
*/

@Service
public class MiaoshaUserService {
	
	@Autowired
	MiaoshaUserDao miaoshaUserDao;

	public MiaoshaUser getById(long id){
		return miaoshaUserDao.getById(id);
	}

	public CodeMsg login(LoginVo loginVo) {
		if(loginVo == null)
			return CodeMsg.SERVER_ERROR;
		String mobile = loginVo.getMobile();
		String formPass = loginVo.getPassword();
		//判断手机号是否存在
		MiaoshaUser user = getById(Long.parseLong(mobile));
		if(user == null)
			return CodeMsg.MOBILE_NOT_EXIST;
		//验证密码
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
		if(!calcPass.equals(dbPass))
			return CodeMsg.PASSWORD_ERROR;
		return CodeMsg.SUCCESS;
	}
}
