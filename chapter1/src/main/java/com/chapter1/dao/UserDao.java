package com.chapter1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import com.chapter1.beans.User;
@Component
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName,String passwd){
		String sql = "select count(*) from t_user "
				+ "where username=? and passwd=?";
		return jdbcTemplate.queryForInt(sql, new Object[]{userName,passwd});
	}
	
	public User findUserByUserName(String userName){
		String sql = "select * from t_user"
				+ "where username=?";
		final User user = new User();
		jdbcTemplate.query(sql,new Object[]{userName}, 
				new RowCallbackHandler() {
					
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						user.setUserId(rs.getInt("userid"));
						user.setUserName(rs.getString("username"));
					}
				});
		return user;
	}

	public void updateLogInfo(String lastIp, String lastVisit,int userId){
		String sql = "update t_user set "
				+ "lastip=?,lastvisit=? where userid=?";
		jdbcTemplate.update(sql,new Object[]{lastIp,lastVisit,userId});
	}
}
