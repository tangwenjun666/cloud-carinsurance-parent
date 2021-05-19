package com.ci.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ci.pojo.Users;

public interface UsersMapper {
	//根据用户名密码查询用户信息
	Users selectUser(@Param("uname") String uname,@Param("upwd") String upwd);
	//添加用户信息
	int insertUser(Users user);
	//修改指定用户状态（启用或停用）
	int updateUserStatus(@Param("uid") int uid,@Param("ustatus") int ustatus);
	//修改用户信息
	int updateUser(Users user);
	//删除用户信息
	int deleteUser(int uid);
	//根据条件查询所有用户的总数量
	int selectUsersCount(@Param("uname") String uname);
	//查询指定用户信息
	Users selectUserById(int uid);
	//根据条件查询所有用户信息
	List<Users> selectUsersPage(@Param("uname") String uname,@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
}
