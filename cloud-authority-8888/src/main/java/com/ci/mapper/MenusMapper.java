package com.ci.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ci.pojo.Menus;

public interface MenusMapper {
	//添加菜单权限
	int insertMenu(Menus menu);
	//修改指定菜单权限状态信息
	int updateMenuStatus(@Param("mid") int mid,@Param("mstatus") int mstatus);
	//修改指定菜单权限
	int updateMenu(Menus menu);
	//删除指定菜单权限
	int deleteMenu(int mid);
	//根据条件查询所有菜单权限的总数量
	int selectMenusCount(@Param("mname") String mname);
	//查询指定菜单信息
	Menus selectMenu(int mid);
	//查询所有菜单信息
	List<Menus> selectMenusAll();
	//根据条件查询所有角色信息
	List<Menus> selectMenusPage(@Param("mname")String mname,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
}
