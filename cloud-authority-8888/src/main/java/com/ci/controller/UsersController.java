package com.ci.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ci.pojo.Page;
import com.ci.pojo.Users;
import com.ci.service.UsersService;

@RestController
@CrossOrigin
public class UsersController {
	@Autowired
	UsersService service;

	/**
	 * 登录
	 *
	 * @param uname
	 * @param upwd
	 * @return
	 */
	@RequestMapping("isLogin")
	public Users isLogin(String uname, String upwd) {
		Users user = service.getUser(uname, upwd);
		return user;
	}

	/**
	 * 添加用户信息
	 */
	@RequestMapping(value = "/addUser", produces = "text/html;charset=UTF-8")
	public String addUser(@RequestBody Users user) {
		int num = service.addUser(user);
		return num > 0 ? "添加成功" : "删除成功";
	}

	/**
	 * 修改用户状态信息（停用或启用）
	 */
	@RequestMapping(value = "/editUserStatus", produces = "text/html;charset=UTF-8")
	public String editUserStatus(@RequestBody Map<String, Object> map) {
		int num = service.editUserStatus((int) map.get("uid"), (int) map.get("ustatus"));
		return num > 0 ? "修改成功" : "修改失败";
	}

	/**
	 * 修改指定用户信息
	 */
	@RequestMapping(value = "/editUser", produces = "text/html;charset=UTF-8")
	public String editUser(@RequestBody Users user) {
		int num = service.editUser(user);
		return num > 0 ? "修改成功" : "修改失败";
	}

	/**
	 * 删除指定用户信息
	 *
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/delUser", produces = "text/html;charset=UTF-8")
	public String delUser(int uid) {
		int num = service.delUser(uid);
		return num > 0 ? "删除成功" : "删除失败";
	}

	/**
	 * 授予角色或取消授予角色
	 *
	 * @param uid
	 * @param rid
	 * @return
	 */
	@RequestMapping(value = "/addDelUserRole", produces = "text/html;charset=UTF-8")
	public String addDelUserRole(int uid,@RequestParam(defaultValue = "0") int[] rids) {
		int num = 0;
		service.delUserRoles(uid);
		if (rids[0] == 0) {
			num = 1;
		}else {
			for (int i = 0; i < rids.length; i++) {
				num = service.addUserRole(uid, rids[i]);
			}
		}
		return num > 0 ? "授权成功" : "授权失败";
	}

	/**
	 * 获取指定用户信息
	 *
	 * @param uid
	 * @return
	 */
	@RequestMapping("/getUser")
	public Users getUser(int uid) {
		Users user = service.getUser(uid);
		return user;
	}

	/**
	 * 获取用户角色信息
	 *
	 * @param uid
	 * @return
	 */
	@RequestMapping("/getUserRoles")
	public Users getUserRoles(int uid) {
		Users userRoles = service.getUserRoles(uid);
		return userRoles;
	}

	/**
	 * 获取分页用户信息
	 *
	 * @param uname
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/getUsersPage")
	public Page getUsersPage(@RequestParam(defaultValue = "") String uname,
							 @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "3") int pageSize) {
		Page users = service.getUsersPage(uname, pageNo, pageSize);
		return users;
	}
}
