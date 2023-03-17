package com.medicare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.backend.entity.Category;
import com.medicare.backend.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo crepo;

	@Override
	public Category addCategory(Category cat) {
		return crepo.save(cat);
	}

	@Override
	public Category updateCategory(Category cat, int cid) {
		if(crepo.findById(cid).isPresent()) {
			Category oldCategory = crepo.findById(cid).get();
			oldCategory.setCname(cat.getCname());
			oldCategory.setProducts(cat.getProducts());
			Category updatedCategory = crepo.save(oldCategory);
			return new Category(updatedCategory.getCid(), updatedCategory.getCname(), updatedCategory.getProducts());
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteCategory(int cid) {
		crepo.deleteById(cid);
		
	}

	@Override
	public Category getCategoryById(int cid) {
		
		return crepo.findById(cid).get();
	}

	@Override
	public List<Category> getAllCategory() {
		
		return crepo.findAll();
	}

}
