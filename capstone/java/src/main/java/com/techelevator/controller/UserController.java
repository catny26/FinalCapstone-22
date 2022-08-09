package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){this.userDao = userDao;}

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.findAll();
    }

    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){
        return userDao.getUserById(id);
    }

    @RequestMapping(value="/patients", method = RequestMethod.GET)
    public List<User> getPatients(){
        return userDao.findAllPatients();
    }

    @RequestMapping(value="/doctors", method=RequestMethod.GET)
    public List<User> getDoctors(){
        return userDao.findAllDoctors();
    }
}
