package com.example.nadahassanplatform.orders.repository;

import com.example.nadahassanplatform.orders.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ShippingRepository extends JpaRepository<Shipping, Long> {

    @Query("SELECT s.governmentName FROM Shipping s")
    List<String> getAllShippingGovernments();
}