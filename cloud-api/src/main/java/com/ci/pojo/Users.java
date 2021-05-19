package com.ci.pojo;

import java.util.List;

/**
 * 用户类
 *
 * @author ASUS
 *
 */
public class Users {
	private int uid;// 序号
	private String uname;// 用户名
	private String upwd;// 密码
	private String uportrait;//头像
	private int ustatus;// 状态0:停用,1:启用
	private List<Roles> roles;//角色集合对象

	public Users() {
		super();
	}

	public Users(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	
	public Users(int uid, String uname, String upwd, int ustatus) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.ustatus = ustatus;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUportrait() {
		return uportrait;
	}

	public void setUportrait(String uportrait) {
		this.uportrait = uportrait;
	}

	public int getUstatus() {
		return ustatus;
	}

	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
