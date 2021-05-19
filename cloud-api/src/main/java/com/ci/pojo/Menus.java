package com.ci.pojo;
/**
 * �˵�Ȩ����
 * @author ASUS
 *
 */

import java.util.List;

public class Menus {
	private int mid;// 序号
	private String mname;// 菜单名称
	private String page_url;// 页面路径
	private int pid;// 父类序号
	private int mstatus;//状态
	private int bid;//按钮权限
	private Menus pMenu;//父类对象
	private List<Menus> children;// 子类菜单集合
	private int id;//树状编号
	private String label;//树状名称

	public Menus() {
		super();
	}

	public Menus(int mid, String mname, String page_url, int pid, int rank) {
		super();
		this.mid = mid;
		this.id = mid;
		this.mname = mname;
		this.label = mname;
		this.page_url = page_url;
		this.pid = pid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
		this.id = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
		this.label = mname;
	}

	public String getPage_url() {
		return page_url;
	}

	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getMstatus() {
		return mstatus;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}

	public Menus getpMenu() {
		return pMenu;
	}

	public void setpMenu(Menus pMenu) {
		this.pMenu = pMenu;
	}

	public List<Menus> getChildren() {
		return children;
	}

	public void setChildren(List<Menus> children) {
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
