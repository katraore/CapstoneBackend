package com.medicare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
