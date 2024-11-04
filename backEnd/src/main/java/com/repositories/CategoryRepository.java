package com.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Category findByNome(String nome);

}
