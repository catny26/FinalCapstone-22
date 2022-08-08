package com.techelevator.dao;

import com.techelevator.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcRoleDao implements RoleDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcRoleDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Role> findAll() {
        String sql = "SELECT * FROM roles = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql)
    }

    @Override
    public Long findByRoleID(Long id) {
        return null;
    }

    @Override
    public String findByRoleName(String name) {
        String sql = "SELECT * FROM roles WHERE name = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
    }
}"
