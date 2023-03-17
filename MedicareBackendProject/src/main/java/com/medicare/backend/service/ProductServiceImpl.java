package com.medicare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.medicare.backend.entity.Category;
import com.medicare.backend.entity.Product;
import com.medicare.backend.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo prepo;

	@Override
	public Product addProduct(Product pr) {
		
		return prepo.save(pr);
	}

	@Override
	public List<Product> getAllProducts() {
		return prepo.findAll();
		
	}

	@Override
	public Product getProductById(int pid) {
		
		return prepo.findById(pid).get();
	}

	@Override
	public void updateDescription(Product pr, int pid) {
		prepo.save(pr);
	
	}

	@Override
	public void deleteProduct(@PathVariable int pid) {
		prepo.deleteById(pid);
		
	}

	@Override
	public Product getProductByPname(String pname) {
		
		return prepo.findByPname(pname);
	}

	@Override
	public List<Product> getAllProductsByCategory(Category category) {
		
		return prepo.findAllProductByCategory(category);
	}



}
