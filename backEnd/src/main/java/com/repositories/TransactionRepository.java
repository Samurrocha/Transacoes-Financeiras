package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Transaction;
import com.enuns.TransactionType;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	
	List<Transaction> findAll();

	
	
	public List<Transaction> findByType(TransactionType type);

}
