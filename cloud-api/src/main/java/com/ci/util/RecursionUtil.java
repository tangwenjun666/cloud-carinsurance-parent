package com.ci.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ci.pojo.Menus;

@Component
public class RecursionUtil {

	// 获取所有权限
	/*
	 * public Menus getMenus(Menus menu) { List<Menus> list =
	 * dao.selectChildrenMenus(menu.getMid()); if (list != null) { for (Menus menu2
	 * : list) { getMenus(menu2); } } menu.setpMenu(dao.selectMenu(menu.getMid()));
	 * menu.setChildren(list); return menu; }
	 */

	/**
	 * 使用递归获取用户拥有的菜单权限
	 *
	 * @param list
	 * @return
	 */
	// 获取根节点，获取指定用户权限
	public List<Menus> getMenus(List<Menus> list) {
		List<Menus> rootMenuLists = new ArrayList<Menus>();
		for (Menus menuNode : list) {
			if (menuNode.getPid() == 0) {
				rootMenuLists.add(buildChilTree(list, menuNode));
			}
		}
		return rootMenuLists;
	}

	// 建立树形结构
	public List<Menus> builTree(List<Menus> list) {
		List<Menus> treeMenus = new ArrayList<Menus>();
		for (Menus menuNode : getMenus(list)) {
			menuNode = buildChilTree(list, menuNode);
			treeMenus.add(menuNode);
		}
		return treeMenus;
	}

	// 递归，建立子树形结构
	private Menus buildChilTree(List<Menus> list, Menus pNode) {
		List<Menus> chilMenus = new ArrayList<Menus>();
		for (Menus menuNode : list) {
			if (menuNode.getPid() == pNode.getMid()) {
				chilMenus.add(buildChilTree(list, menuNode));
			}
		}
		pNode.setChildren(chilMenus);
		return pNode;
	}

}
