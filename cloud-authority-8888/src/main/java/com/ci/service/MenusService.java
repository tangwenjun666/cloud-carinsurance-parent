package com.ci.service;

import java.util.List;

import com.ci.pojo.Menus;
import com.ci.pojo.Page;

public interface MenusService {
	int addMenu(Menus menu);
	
	int editMenuStatus(int mid,int mstatus);
	
	int editMenu(Menus menu);
	
	int delMenu(int mid);
	
	Menus getMenu(int mid);
	
	List<Menus> getMenusAll();
	
	List<Menus> getMenusTree();
	
	Page getMenusPage(String mname, int pageNo, int pageSize);
}
