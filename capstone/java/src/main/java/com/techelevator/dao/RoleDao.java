package com.techelevator.dao;

import com.techelevator.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Long findByRoleID(Long id);

    String findByRoleName(String name);
}
