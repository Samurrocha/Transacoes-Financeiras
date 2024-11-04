package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Category;
import com.repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}

	public void updateCategory(long id, Category category) {
		if (!categoryRepository.existsById(id)) {
			throw new EntityNotFoundException("Transação não encontrada");
		}
		;
		categoryRepository.save(category);
	}

	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

}
