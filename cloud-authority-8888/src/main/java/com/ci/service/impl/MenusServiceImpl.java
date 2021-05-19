package com.ci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.mapper.MenusMapper;
import com.ci.pojo.Menus;
import com.ci.pojo.Page;
import com.ci.service.MenusService;
import com.ci.util.RecursionUtil;

@Service
public class MenusServiceImpl implements MenusService {
	@Autowired
	private MenusMapper mapper;
	@Autowired
	RecursionUtil util;

	/**
	 * 实现添加菜单权限信息业务功能
	 */
	@Override
	public int addMenu(Menus menu) {
		return mapper.insertMenu(menu);
	}

	/**
	 * 实现修改菜单权限状态信息（停用或启用）业务功能
	 */
	@Override
	public int editMenuStatus(int mid, int mstatus) {
		return mapper.updateMenuStatus(mid, mstatus);
	}

	/**
	 * 实现修改菜单权限信息业务功能
	 */
	@Override
	public int editMenu(Menus menu) {
		return mapper.updateMenu(menu);
	}

	/**
	 * 实现修改指定菜单权限信息业务功能
	 */
	@Override
	public int delMenu(int mid) {
		return mapper.deleteMenu(mid);
	}

	/**
	 * 实现获取指定菜单权限信息业务功能
	 */
	@Override
	public Menus getMenu(int mid) {
		return mapper.selectMenu(mid);
	}

	/**
	 * 实现获取所有菜单权限信息业务功能
	 */
	@Override
	public List<Menus> getMenusAll() {
		return mapper.selectMenusAll();
	}

	/**
	 * 实现带条件菜单权限信息的分页的功能业务
	 */
	@Override
	public Page getMenusPage(String mname, int pageNo, int pageSize) {
		// 创建分页对象
		Page page = new Page(mapper.selectMenusCount(mname), pageSize, pageNo);
		// 获取并设置菜单信息
		List<Menus> menus = mapper.selectMenusPage(mname, (pageNo-1)*pageSize, pageSize);
		for (Menus menu : menus) {
			menu.setpMenu(mapper.selectMenu(menu.getPid()));
		}
		page.setListMenus(menus);
		return page;
	}

	/**
	 * 实现获取所有菜单权限树状信息业务功能
	 */
	@Override
	public List<Menus> getMenusTree() {
		List<Menus> menus = mapper.selectMenusAll();
		List<Menus> menusTreeList = util.getMenus(menus);
		return menusTreeList;
	}
}
