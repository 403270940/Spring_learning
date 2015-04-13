package com.chapter1.beans;

import java.io.Serializable;
import java.util.Date;



public class User implements Serializable{
	private int userId;
	private String userName;
	private String password;
	private String lastIP;
	private Date lastVisit;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return password;
	}
	public void setPasswd(String passwd) {
		this.password = passwd;
	}
	public String getLastIP() {
		return lastIP;
	}
	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	
}
