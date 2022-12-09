package com.example.onlinereportcomplaining_backend.controller;

import com.example.onlinereportcomplaining_backend.dao.OnlineReportComplainingDao;
import com.example.onlinereportcomplaining_backend.model.OnlineReportComplaining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class OnlineReportComplainingController {

    @Autowired
    private OnlineReportComplainingDao dao;

    @GetMapping("/")
    public String HomePage()
    {
        return "Welcome home page";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userReg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserRegistration(@RequestBody OnlineReportComplaining o)
    {
        HashMap<String,String> map=new HashMap<>();
        List<OnlineReportComplaining> result=(List<OnlineReportComplaining>) dao.FindUser(o.getUsername());
        if (result.size()!=0)
        {
            map.put("status","success");
        }
        else
        {
            dao.save(o);
            map.put("status","failed");

        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserLogin(@RequestBody OnlineReportComplaining o)
    {
        List<OnlineReportComplaining> result=(List<OnlineReportComplaining>) dao.userLogin(o.getUsername(),o.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if (result.size()==0)
        {
            map.put("status","failed");
        }
        else
        {
            dao.save(o);
            map.put("status","success");

        }
        return map;

    }


}
