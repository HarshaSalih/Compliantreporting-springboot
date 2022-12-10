package com.example.complaintreporting_backend.dao;

import com.example.complaintreporting_backend.model.Complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface CompliantDao extends CrudRepository <Complaints,Integer> {

    @Query(value = "SELECT u.`address`, u.`email`, u.`name`,  u.`phone`,c.complaints FROM `online_report_complaining` u JOIN complaints c ON c.user_id=u.id",nativeQuery = true)
    List<Map<String,String>>compliants();
}
