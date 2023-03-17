package com.medicare.backend.service;

import java.util.List;

import com.medicare.backend.entity.Category;
import com.medicare.backend.entity.Product;

public interface ProductService {
	public Product addProduct(Product pr);
	public List<Product> getAllProducts();
	public Product getProductById(int pid);
	public void updateDescription(Product pr, int pid);
	public void deleteProduct(int pid);
	public Product getProductByPname(String pname);
	public List<Product> getAllProductsByCategory(Category category);
	
	

}
