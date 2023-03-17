package com.medicare.backend.service;

import java.util.List;

import com.medicare.backend.entity.Category;

public interface CategoryService {
	public Category addCategory(Category cat);
	public Category updateCategory(Category cat, int cid);
	public void deleteCategory(int cid);
	public Category getCategoryById(int cid);
	public List<Category> getAllCategory();

}
