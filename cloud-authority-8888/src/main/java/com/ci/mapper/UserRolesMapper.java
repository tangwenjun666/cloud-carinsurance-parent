package com.ci.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ci.pojo.UserRoles;

public interface UserRolesMapper {
	//根据用户序号查询用户角色关系信息
	List<UserRoles> selectUserRoles(int uid);
	//删除用户角色信息
	int deleteUserRoles(int uid);
	//添加用户角色信息
	int insertUserRole(@Param("uid") int uid,@Param("rid") int rid);
}
