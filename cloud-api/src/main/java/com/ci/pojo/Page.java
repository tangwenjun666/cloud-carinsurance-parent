package com.ci.pojo;

import java.util.List;

public class Page {
	private int totalCount;// 总记录数
	private int pageSize;// 页大小
	private int totalPageCount;// 总页面
	private int currentPage = 1;// 当前页码
	private List<Users> listUsers;// 用户页集合
	private List<Roles> listRoles;// 角色页集合
	private List<Menus> listMenus;// 角色页集合

	public Page() {
	}

	public Page(int totalCount, int pageSize, int currentPage) {
		this.setPageSize(pageSize);
		this.setTotalCount(totalCount);
		this.setCurrentPage(currentPage);
	}

	public Page(int totalCount, int pageSize, int currentPage, List<Users> listUsers) {
		this.setPageSize(pageSize);
		this.setTotalCount(totalCount);
		this.setCurrentPage(currentPage);
		this.setListUsers(listUsers);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount>0) {
			if (totalCount%pageSize==0) {
				this.totalPageCount=totalCount/this.pageSize;
			} else {
				this.totalPageCount=(totalCount/this.pageSize)+1;
			}
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize<=0) {
			this.pageSize=10;
		} else {
			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Users> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<Users> listUsers) {
		this.listUsers = listUsers;
	}

	public List<Roles> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Roles> listRoles) {
		this.listRoles = listRoles;
	}

	public List<Menus> getListMenus() {
		return listMenus;
	}

	public void setListMenus(List<Menus> listMenus) {
		this.listMenus = listMenus;
	}

}
