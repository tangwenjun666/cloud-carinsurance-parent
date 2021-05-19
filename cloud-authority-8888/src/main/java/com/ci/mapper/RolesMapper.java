package com.ci.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ci.pojo.Roles;

public interface RolesMapper {
	//添加角色信息
	int insertRole(Roles role);
	//修改角色状态信息（停用或启用）
	int updateRoleStatus(@Param("rid") int rid,@Param("rstatus") int rstatus);
	//修改指定角色信息
	int updateRole(Roles role);
	//删除指定角色信息
	int deleteRole(int rid);
	//根据条件查询所有角色的总数量
	int selectRolesCount(@Param("rname") String rname);
	//根据序号查询用户角色信息
	Roles selectRole(int rid);
	//查询所有角色信息
	List<Roles> selectRoles();
	//根据条件查询所有角色信息
	List<Roles> selectRolesPage(@Param("rname") String rname,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
}
