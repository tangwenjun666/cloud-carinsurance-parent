package com.ci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.mapper.MenusMapper;
import com.ci.mapper.RoleMenusMapper;
import com.ci.mapper.RolesMapper;
import com.ci.pojo.Menus;
import com.ci.pojo.Page;
import com.ci.pojo.RoleMenus;
import com.ci.pojo.Roles;
import com.ci.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	private RolesMapper mapper;
	@Autowired
	private RoleMenusMapper roleMenusMapper;
	@Autowired
	private MenusMapper menusMapper;


	/**
	 * 实现添加角色信息业务功能
	 */
	@Override
	public int addRole(Roles role) {
		return mapper.insertRole(role);
	}

	/**
	 * 实现修改指定角色状态信息（停用或启用）业务功能
	 */
	@Override
	public int editRoleStatus(int rid, int rstatus) {
		return mapper.updateRoleStatus(rid, rstatus);
	}

	/**
	 * 实现修改指定角色信息业务功能
	 */
	@Override
	public int editRole(Roles role) {
		return mapper.updateRole(role);
	}

	/**
	 * 实现删除指定角色信息业务功能
	 */
	@Override
	public int delRole(int rid) {
		return mapper.deleteRole(rid);
	}

	/**
	 * 实现删除所有角色菜单权限信息业务功能
	 */
	@Override
	public int delRoleMenus(int rid) {
		return roleMenusMapper.deleteRoleMenus(rid);
	}

	/**
	 * 实现添加角色菜单权限信息业务功能
	 */
	@Override
	public int addRoleMenu(int rid, int mid, int bid) {
		int num;
		Menus menu = menusMapper.selectMenu(mid);
		int count = roleMenusMapper.selectRoleMenusById(rid, mid);
		if (count>0) {
			num = roleMenusMapper.updateRoleMenu(rid, mid, bid);
		} else {
			num = roleMenusMapper.insertRoleMenu(rid, mid, bid);
		}
		if (menu.getPid() != 0) {
			num = addRoleMenu(rid, menu.getPid(), 0);
		}
		return num;
	}

	/**
	 * 实现根据角色id获取角色信息业务功能
	 */
	@Override
	public Roles getRole(int rid) {
		return mapper.selectRole(rid);
	}

	/**
	 * 实现获取角色菜单权限信息业务功能
	 */
	@Override
	public Roles getRoleMenus(int rid) {
		Roles role = mapper.selectRole(rid);
		List<RoleMenus> roleMenus = roleMenusMapper.selectRoleMenus(rid);
		List<Menus> menus = new ArrayList<Menus>();
		for (RoleMenus roleMenu : roleMenus) {
			Menus menu = menusMapper.selectMenu(roleMenu.getMid());
			menu.setBid(roleMenu.getBid());
			menus.add(menu);
		}
		role.setMenus(menus);
		return role;
	}

	/**
	 * 实现获取所有角色信息
	 */
	@Override
	public List<Roles> getRoles() {
		return mapper.selectRoles();
	}

	/**
	 * 实现带条件角色信息的分页的业务功能
	 */
	@Override
	public Page getRolesPage(String rname, int pageNo, int pageSize) {
		//创建分页对象
		Page page = new Page(mapper.selectRolesCount(rname), pageSize, pageNo);
		//获取并设置用户信息
		List<Roles> roles = mapper.selectRolesPage(rname, (pageNo-1)*pageSize, pageSize);
		for (Roles role : roles) {
			// 获取角色菜单的集合
			List<RoleMenus> roleMenus = roleMenusMapper.selectRoleMenus(role.getRid());
			// 创建菜单对象的集合
			List<Menus> menus = new ArrayList<Menus>();
			for (RoleMenus roleMenu : roleMenus) {
				// 根据序号获取菜单对象
				Menus menu = menusMapper.selectMenu(roleMenu.getMid());
				if (menu != null) {
					menus.add(menu);
				}
			}
			role.setMenus(menus);
		}
		page.setListRoles(roles);
		return page;
	}

}
