package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.Role;

public interface RoleDao {
 //List<Role> searchRole(Role role) ;
 List<Role> searchAllRole();
 boolean addRole(Role role);
 boolean delRole(Role role);
 boolean updateRole(Role role);
}
