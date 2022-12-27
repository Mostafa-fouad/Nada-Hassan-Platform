package com.example.nadahassanplatform.orders.repository;

import com.example.nadahassanplatform.orders.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}