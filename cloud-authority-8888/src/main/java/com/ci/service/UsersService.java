package com.ci.service;

import com.ci.pojo.Page;
import com.ci.pojo.Users;

public interface UsersService {
	Users getUser(String uname,String upwd);
	
	int addUser(Users user);
	
	int editUserStatus(int uid,int ustatus);
	
	int editUser(Users user);
	
	int delUser(int uid);
	
	int delUserRoles(int uid);
	
	int addUserRole(int uid,int rid);
	
	Users getUser(int uid);
	
	Users getUserRoles(int uid);
	
	Page getUsersPage(String uname, int pageNo, int pageSize);
}
