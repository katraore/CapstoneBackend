package com.medicare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.backend.entity.Category;
import com.medicare.backend.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat){
		Category catcreated = cservice.addCategory(cat);
		if(catcreated !=null)
			return new ResponseEntity<Category>(catcreated, HttpStatus.OK);
		else
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("")
	public List<Category> getAllCategory(){
		return cservice.getAllCategory();
	}
	@RequestMapping("{cid}")
	public ResponseEntity<Category> getCategoryBId(@PathVariable int cid){
		if (cservice.getCategoryById(cid)!=null)
			return new ResponseEntity<Category>(cservice.getCategoryById(cid), HttpStatus.FOUND);
		else
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="{cid}")
	public void updateCategory(@PathVariable int cid, @RequestBody Category cat) {
		cservice.updateCategory(cat, cid);
	}
	@RequestMapping(method = RequestMethod.DELETE, value ="{cid}")
	public void deleteCategory(@PathVariable int cid) {
		cservice.deleteCategory(cid);
	}
	

}
