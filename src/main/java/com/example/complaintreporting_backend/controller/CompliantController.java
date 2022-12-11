package com.example.complaintreporting_backend.controller;

import com.example.complaintreporting_backend.dao.CompliantDao;
import com.example.complaintreporting_backend.model.Complaints;
import com.example.complaintreporting_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class CompliantController {

    @Autowired
    private CompliantDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addCompliant",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addCompliant(@RequestBody Complaints c)
    {
        HashMap<String,String> map=new HashMap<>();
        dao1.save(c);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllCompliant")
    public List<Map<String,String>> ViewAllCompliant()
    {
        return (List<Map<String, String>>) dao1.compliants();
    }

//    @CrossOrigin(origins = "*")
//    @GetMapping(path = "/viewMyCompliant")
//    public List<Complaints> ViewMyCompliant(@RequestBody Integer userId)
//    {
//        return (List<Complaints>) dao1.findAllByUserId(userId);
//    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewMyCompliant",consumes = "application/json",produces = "application/json")
    public List<Complaints>viewMyCompliant(@RequestBody Complaints c)
    {
        System.out.println(c.getUserId());
        return (List<Complaints>) dao1.viewMyCompliant(c.getUserId());
    }


}
