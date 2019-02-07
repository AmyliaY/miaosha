package com.imooc.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;

/**
* @author 全恒
*/

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User getById(int id){
		return userDao.getUserById(id);
	}
	
	@Transactional	//此注释用来给该方法加上事务
	public boolean tx(){
		User user1 = new User();
		user1.setId(2);
		user1.setName("222");
		userDao.insert(user1);
		
		User user2 = new User();
		user1.setId(1);
		user1.setName("111");
		userDao.insert(user2);
		
		return true;
	}
}
