package com.example.nadahassanplatform.orders.repository;

import com.example.nadahassanplatform.orders.model.Orders.Status;
import com.example.nadahassanplatform.orders.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Orders, UUID> {

    List<Orders> findOrdersByOrderStatusIs(Status orderStatus);
}
