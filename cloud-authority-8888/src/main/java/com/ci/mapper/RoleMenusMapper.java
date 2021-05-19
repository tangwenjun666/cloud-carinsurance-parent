package com.ci.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ci.pojo.RoleMenus;

public interface RoleMenusMapper {
	//根据角色序号查询角色菜单信息
	List<RoleMenus> selectRoleMenus(int rid);
	//根据角色菜单序号查询指定角色菜单信息
	int selectRoleMenusById(@Param("rid") int rid,@Param("mid") int mid);
	//删除角色菜单权限信息
	int deleteRoleMenus(int rid);
	//添加角色菜单权限信息
	int insertRoleMenu(@Param("rid") int rid,@Param("mid") int mid,@Param("bid") int bid);
	//修改角色菜单权限信息
	int updateRoleMenu(@Param("rid") int rid,@Param("mid") int mid,@Param("bid") int bid);
}
