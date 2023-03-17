package com.medicare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
