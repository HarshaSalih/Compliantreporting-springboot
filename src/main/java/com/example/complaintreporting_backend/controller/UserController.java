package com.example.complaintreporting_backend.controller;

import com.example.complaintreporting_backend.dao.UserDao;
import com.example.complaintreporting_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String HomePage()
    {
        return "Welcome home page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegistration(@RequestBody User u)
    {
        HashMap<String,String> map=new HashMap<>();
        List<User> result=(List<User>) dao.FindUser(u.getUsername());
        if (result.size()!=0)
        {
            map.put("status","success");
        }
        else
        {
            dao.save(u);
            map.put("status","failed");

        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserLogin(@RequestBody User u)
    {
        List<User> result=(List<User>) dao.userLogin(u.getUsername(),u.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if (result.size()==0)
        {
            map.put("status","failed");
        }
        else
        {
//            dao.save(u);
            map.put("status","success");
            map.put("userId",String.valueOf(result.get(0).getId()));

        }
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewProfile",consumes = "application/json",produces = "application/json")
    public List<User>viewProfile(@RequestBody User u)
    {
        return (List<User>) dao.viewProfile(u.getId());
    }
}
