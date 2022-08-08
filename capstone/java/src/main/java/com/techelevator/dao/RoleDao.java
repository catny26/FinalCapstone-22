package com.techelevator.dao;

import com.techelevator.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Role findByRoleID(int id);

    Role findByRoleName(String name);
}
