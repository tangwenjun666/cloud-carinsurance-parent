package com.ci.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ci.pojo.Menus;
import com.ci.pojo.Page;
import com.ci.service.MenusService;

@RestController
@CrossOrigin
public class MenusController {
	@Autowired
	MenusService service;

	/**
	 * 添加菜单权限信息
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/addMenu",produces = "text/html;charset=UTF-8")
	public String addMenu(@RequestBody Menus menu) {
		int num = service.addMenu(menu);
		return num>0?"添加成功":"添加失败";
	}

	/**
	 * 修改菜单权限状态信息（停用或启用）
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/editMenuStatus",produces = "text/html;charset=UTF-8")
	public String editMenuStatus(@RequestBody Map<String, Object> map) {
		int num = service.editMenuStatus((int)map.get("mid"),(int)map.get("mstatus"));
		return num>0?"修改成功":"修改失败";
	}

	/**
	 * 修改指定菜单权限信息
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/editMenu",produces = "text/html;charset=UTF-8")
	public String editMenu(@RequestBody Menus menu) {
		int num = service.editMenu(menu);
		return num>0?"修改成功":"修改失败";
	}

	/**
	 * 删除指定菜单权限信息
	 * @param mid
	 * @return
	 */
	@RequestMapping(value = "/delMenu",produces = "text/html;charset=UTF-8")
	public String delMenu(int mid) {
		int num = service.delMenu(mid);
		return num>0?"删除成功":"删除失败";
	}

	/**
	 * 获取指定菜单权限信息
	 * @param mid
	 * @return
	 */
	@RequestMapping("/getMenu")
	public Menus getMenu(int mid){
		Menus menu = service.getMenu(mid);
		return menu;
	}

	/**
	 * 获取所有菜单权限信息
	 * @return
	 */
	@RequestMapping("/getMenusAll")
	public List<Menus> getMenusAll(){
		List<Menus> menus = service.getMenusAll();
		return menus;
	}

	/**
	 * 获取所有树状菜单权限信息
	 * @return
	 */
	@RequestMapping("/getMenusTree")
	public List<Menus> getMenusTree(){
		List<Menus> menus = service.getMenusTree();
		return menus;
	}

	/**
	 * 获取分页菜单权限信息
	 * @param mname
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/getMenusPage")
	public Page getMenusPage(@RequestParam(defaultValue = "") String mname,@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "3") int pageSize){
		Page menus = service.getMenusPage(mname, pageNo, pageSize);
		return menus;
	}
}
