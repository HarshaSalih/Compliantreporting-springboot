package com.example.complaintreporting_backend.dao;

import com.example.complaintreporting_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `online_report_complaining` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<User> userLogin(@Param("username")String username, @Param("password")String password);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `online_report_complaining` WHERE `username`= :username",nativeQuery = true)
    List<User> FindUser(@Param("username")String username);

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone`, `username` FROM `online_report_complaining` WHERE `id`= :id",nativeQuery = true)
    List<User>viewProfile(@Param("id")Integer id);
}
