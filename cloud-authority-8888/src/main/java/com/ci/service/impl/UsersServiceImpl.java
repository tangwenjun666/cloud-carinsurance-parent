package com.ci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.mapper.MenusMapper;
import com.ci.mapper.RoleMenusMapper;
import com.ci.mapper.RolesMapper;
import com.ci.mapper.UserRolesMapper;
import com.ci.mapper.UsersMapper;
import com.ci.pojo.Menus;
import com.ci.pojo.Page;
import com.ci.pojo.RoleMenus;
import com.ci.pojo.Roles;
import com.ci.pojo.UserRoles;
import com.ci.pojo.Users;
import com.ci.service.UsersService;
import com.ci.util.RecursionUtil;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper mapper;
	@Autowired
	private RolesMapper rolesMapper;
	@Autowired
	private MenusMapper menusMapper;
	@Autowired
	private UserRolesMapper userRolesMapper;
	@Autowired
	private RoleMenusMapper roleMenusMapper;
	@Autowired
	RecursionUtil util;

	/**
	 * 实现登录业务功能
	 */
	@Override
	public Users getUser(String uname, String upwd) {
		// 获取用户对象
		Users user = mapper.selectUser(uname, upwd);
		if (user != null) {// 用户不为空
			// 获取用户的角色的集合
			List<UserRoles> userRoles = userRolesMapper.selectUserRoles(user.getUid());
			if (userRoles != null) {// 该用户的角色不为空
				// 创建用户角色对象的集合
				List<Roles> roles = new ArrayList<Roles>();
				for (UserRoles userRole : userRoles) {
					// 根据序号获取角色对象
					Roles role = rolesMapper.selectRole(userRole.getRid());
					if (role != null) {
						// 获取角色菜单的集合
						List<RoleMenus> roleMenus = roleMenusMapper.selectRoleMenus(role.getRid());
						// 创建菜单对象的集合
						List<Menus> menus = new ArrayList<Menus>();
						for (RoleMenus roleMenu : roleMenus) {
							// 根据序号获取菜单对象
							Menus menu = menusMapper.selectMenu(roleMenu.getMid());
							if (menu != null) {
								menu.setBid(roleMenu.getBid());
								menus.add(menu);
							}
						}
						role.setMenus(util.builTree(menus));
						roles.add(role);
					}
				}
				user.setRoles(roles);
			}
		}
		return user;
	}

	/**
	 * 实现添加用户信息业务功能
	 */
	@Override
	public int addUser(Users user) {
		return mapper.insertUser(user);
	}

	/**
	 * 实现修改用户状态信息（停用或启用）业务功能
	 */
	@Override
	public int editUserStatus(int uid, int ustatus) {
		return mapper.updateUserStatus(uid, ustatus);
	}

	/**
	 * 实现修改指定用户信息业务功能
	 */
	@Override
	public int editUser(Users user) {
		return mapper.updateUser(user);
	}

	/**
	 * 实现删除指定用户信息业务功能
	 */
	@Override
	public int delUser(int uid) {
		return mapper.deleteUser(uid);
	}

	/**
	 * 实现取消授予角色操作业务功能
	 */
	@Override
	public int delUserRoles(int uid) {
		return userRolesMapper.deleteUserRoles(uid);
	}

	/**
	 * 实现授予角色操作业务功能
	 */
	@Override
	public int addUserRole(int uid, int rid) {
		return userRolesMapper.insertUserRole(uid, rid);
	}

	/**
	 * 实现获取指定用户信息业务功能
	 */
	@Override
	public Users getUser(int uid) {
		return mapper.selectUserById(uid);
	}

	/**
	 * 实现根据用户id获取角色信息业务功能
	 */
	@Override
	public Users getUserRoles(int uid) {
		Users user = mapper.selectUserById(uid);
		List<UserRoles> userRoles = userRolesMapper.selectUserRoles(uid);
		List<Roles> roles = new ArrayList<Roles>();
		for (UserRoles userRole : userRoles) {
			Roles role = rolesMapper.selectRole(userRole.getRid());
			roles.add(role);
		}
		user.setRoles(roles);
		return user;
	}

	/**
	 * 实现带条件用户信息的分页的业务功能
	 */
	@Override
	public Page getUsersPage(String uname, int pageNo, int pageSize) {
		// 创建分页对象
		Page page = new Page(mapper.selectUsersCount(uname), pageSize, pageNo);
		// 获取并设置用户信息
		List<Users> users = mapper.selectUsersPage(uname, (pageNo-1)*pageSize, pageSize);

		for (Users user : users) { // 获取用户的角色的集合
			List<UserRoles> userRoles = userRolesMapper.selectUserRoles(user.getUid());
			if (userRoles != null) {// 该用户的角色不为空 //
				// 创建用户角色对象的集合
				List<Roles> roles = new ArrayList<Roles>();
				for (UserRoles userRole : userRoles) { // 根据序号获取角色对象
					Roles role = rolesMapper.selectRole(userRole.getRid());
					roles.add(role);
				}
				user.setRoles(roles);
			}
		}

		page.setListUsers(users);
		return page;
	}


}
