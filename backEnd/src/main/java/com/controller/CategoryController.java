package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Category;
import com.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody Category category) {

		

	

		categoryService.save(category);

		return ResponseEntity.ok(category);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Category>> listCategory(){
		
		List<Category> categorias = categoryService.listCategory();
		
		return ResponseEntity.ok(categorias);
	}
	
	
	
	

}
