package com.medicare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Category;
import com.medicare.backend.entity.Product;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	

}
