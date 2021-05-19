package com.ci.service;

import java.util.List;

import com.ci.pojo.Page;
import com.ci.pojo.Roles;

public interface RolesService {
	int addRole(Roles role);

	int editRoleStatus(int rid, int rstatus);

	int editRole(Roles role);

	int delRole(int rid);

	int delRoleMenus(int rid);

	int addRoleMenu(int rid, int mid, int bid);

	Roles getRole(int rid);
	
	Roles getRoleMenus(int rid);

	List<Roles> getRoles();

	Page getRolesPage(String rname, int pageNo, int pageSize);
}
