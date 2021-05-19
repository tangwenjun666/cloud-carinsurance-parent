package com.ci.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ci.pojo.Page;
import com.ci.pojo.Roles;
import com.ci.service.RolesService;

@SuppressWarnings("all")
@RestController
@CrossOrigin
public class RolesController {
	@Autowired
	RolesService service;

	/**
	 * 添加角色信息
	 */
	@RequestMapping(value = "/addRole", produces = "text/html;charset=UTF-8")
	public String addRole(@RequestBody Roles role) {
		int num = service.addRole(role);
		return num > 0 ? "添加成功" : "添加失败";
	}

	/**
	 * 修改角色状态信息（停用或启用）
	 */
	@RequestMapping(value = "/editRoleStatus", produces = "text/html;charset=UTF-8")
	public String editRoleStatus(@RequestBody Map<String, Object> map) {
		int num = service.editRoleStatus((int) map.get("rid"), (int) map.get("rstatus"));
		return num > 0 ? "修改成功" : "修改失败";
	}

	/**
	 * 修改指定角色信息
	 *
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/editRole", produces = "text/html;charset=UTF-8")
	public String editRole(@RequestBody Roles role) {
		int num = service.editRole(role);
		return num > 0 ? "修改成功" : "修改失败";
	}

	/**
	 * 删除指定角色信息
	 *
	 * @param rid
	 * @return
	 */
	@RequestMapping("/delRole")
	public String delRole(int rid) {
		int num = service.delRole(rid);
		return num > 0 ? "删除成功" : "删除失败";
	}

	/**
	 * 授予角色菜单权限
	 *
	 * @param rid
	 * @param mids
	 * @param bids
	 * @return
	 */
	@RequestMapping(value = "/addDelRoleMenus", produces = "text/html;charset=UTF-8")
	public String addDelRoleMenus(@RequestBody Map<String, Object> map) {
		int num = 0;
		int rid = (int) map.get("rid");
		service.delRoleMenus(rid);
		//需要赋权的菜单编号的集合
		List<Integer> mids = (List<Integer>) map.get("mids");
		//菜单和按钮关系的集合
		List<Map<String, Object>> mbids =  (List<Map<String, Object>>) map.get("mbids");
		//需要赋权的菜单按钮权限的集合
		Map<Integer, List<String>> mbMap = new HashMap<Integer, List<String>>();
		for (Map<String, Object> mbid : mbids) {
			mbMap.put((Integer)mbid.get("mid"), (List<String>)mbid.get("bids"));
		}
		for (Integer mid : mids) {
			String bids = "";
			if (mbids.size()<=0 || mbMap.get(mid)==null || mbMap.get(mid).size()<=0) {
				num = service.addRoleMenu(rid, mid, 0);
			} else {
				List<String> mb = mbMap.get(mid);
				Collections.sort(mb);
				for (String bid : mb) {
					bids += bid;
				}
				int bid = Integer.parseInt(bids);
				num = service.addRoleMenu(rid, mid, bid>0?bid:0);
			}
		}
		if (mids.size()<=0) {
			num = 1;
		}
		return num > 0 ? "授权成功" : "授权失败";
	}

	/**
	 * 获取指定角色信息
	 *
	 * @param rid
	 * @return
	 */
	@RequestMapping("/getRole")
	public Roles getRole(int rid) {
		Roles role = service.getRole(rid);
		return role;
	}

	/**
	 * 获取所有角色信息
	 *
	 * @return
	 */
	@RequestMapping("/getRoles")
	public List<Roles> getRoles() {
		List<Roles> roles = service.getRoles();
		return roles;
	}

	/**
	 * 获取角色菜单权限信息
	 *
	 * @param rid
	 * @return
	 */
	@RequestMapping("/getRoleMenus")
	public Roles getRoleMenus(int rid) {
		Roles role = service.getRoleMenus(rid);
		return role;
	}

	/**
	 * 获取角色分页信息
	 *
	 * @param rname
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/getRolesPage")
	public Page getRoles(@RequestParam(defaultValue = "") String rname, @RequestParam(defaultValue = "1") int pageNo,
						 @RequestParam(defaultValue = "3") int pageSize) {
		Page roles = service.getRolesPage(rname, pageNo, pageSize);
		return roles;
	}
}
