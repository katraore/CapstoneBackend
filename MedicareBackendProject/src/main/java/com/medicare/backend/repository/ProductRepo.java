package com.medicare.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.backend.entity.Category;
import com.medicare.backend.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findAllProductByCategory(Category category);

	Product findByPname(String pname);

	


	

}
