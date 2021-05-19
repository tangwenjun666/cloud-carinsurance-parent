package com.ci.pojo;

import java.util.List;


/**
 * 角色类
 *
 * @author ASUS
 *
 */
public class Roles {
	private int rid;// 序号
	private String rname;// 名称
	private String rdescribe;// 描述
	private int rstatus;// 状态
	private List<Menus> menus;// 菜单集合对象

	public Roles() {
		super();
	}

	public Roles(String rname, String rdescribe) {
		super();
		this.rname = rname;
		this.rdescribe = rdescribe;
	}
	
	public Roles(int rid, String rname, String rdescribe, int rstatus) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdescribe = rdescribe;
		this.rstatus = rstatus;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdescribe() {
		return rdescribe;
	}

	public void setRdescribe(String rdescribe) {
		this.rdescribe = rdescribe;
	}

	public int getRstatus() {
		return rstatus;
	}

	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

}
