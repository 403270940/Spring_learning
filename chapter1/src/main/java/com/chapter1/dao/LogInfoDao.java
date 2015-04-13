package com.chapter1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.chapter1.beans.LoginInfo;

@Component
public class LogInfoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert_login_info(LoginInfo loginInfo){
		String sql = "insert into login_info(userid,ip,logindate) "
				+ "values(?,?,?)";
		jdbcTemplate.update(sql,new Object[]{loginInfo.getUserId(),loginInfo.getIP(),loginInfo.getLoginDate()});
	}
}
