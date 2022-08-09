package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findAllDoctors();

    List<User> findAllPatients();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role, String fullName);

    boolean create(String username, String password, String role, String fullName, String typeOfDoctor);
}
