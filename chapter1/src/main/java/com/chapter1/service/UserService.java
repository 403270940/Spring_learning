package com.chapter1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chapter1.beans.LoginInfo;
import com.chapter1.beans.User;
import com.chapter1.dao.LogInfoDao;
import com.chapter1.dao.UserDao;

/**
 * Hello world!
 *
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LogInfoDao logInfoDao;
	
	public boolean hasMatchUser(String userName,String passwd){
		return userDao.getMatchCount(userName, passwd)>0;
	}
	
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user){
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId(user.getUserId());
		loginInfo.setIP(user.getLastIP());
		loginInfo.setLoginDate(user.getLastVisit());
		logInfoDao.insert_login_info(loginInfo);
	}
}
