package com.example.onlinereportcomplaining_backend.dao;

import com.example.onlinereportcomplaining_backend.model.OnlineReportComplaining;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OnlineReportComplainingDao extends CrudRepository<OnlineReportComplaining,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `online_report_complaining` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<OnlineReportComplaining> userLogin(@Param("username")String username,@Param("password")String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `online_report_complaining` WHERE `username`= :username",nativeQuery = true)
    List<OnlineReportComplaining> FindUser(@Param("username")String username);
}
