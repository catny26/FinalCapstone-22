package com.techelevator.dao;

import com.techelevator.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRoleDao implements RoleDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcRoleDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Role role = mapRowToRole(results);
                roles.add(role);
            }
            return roles;
        }


    @Override
    public Role findByRoleID(int id) {
        String sql = "SELECT role_id FROM roles WHERE role_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            return mapRowToRole(results);
        }
            return id;
    }

    @Override
    public Role findByRoleName(String name) {
        String sql = "SELECT role_name FROM roles WHERE role_name = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if (results.next()) {
            return mapRowToRole(results);
        }
        return name;

    }

    public Role findByUserId(Integer id){
        Role roleByUserId = null;
        String sql = "SELECT * FROM users " +
                    "FROM users u " +
                    "JOIN roles r " +
                    "ON u.role_id = r.role_id " +
                    "WHERE u.role_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            roleByUserId = mapRowToRole(results);
        }
        return roleByUserId;
    }

    private Role mapRowToRole(SqlRowSet results) {
        Role role = new Role();
        role.setId(results.getInt("role_id"));
        role.setName(results.getString("role_name"));
        return role;
    }

}
