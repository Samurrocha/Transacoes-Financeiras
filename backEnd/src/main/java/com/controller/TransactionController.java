package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.TransactionDto;
import com.entities.Transaction;
import com.enuns.TransactionType;
import com.services.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	public ResponseEntity<Object> createTransaction(@RequestBody TransactionDto transactionDto) {


		transactionService.save(transactionDto);
		
		return ResponseEntity.ok(transactionDto);

	}

	@GetMapping
	public ResponseEntity<List<TransactionDto>> readAll() {

		return ResponseEntity.ok(transactionService.readTransaction());

	}
	
	
	@GetMapping("filtered")
	public ResponseEntity<List<TransactionDto>> readFiltered(@RequestParam TransactionType type) {

		return ResponseEntity.ok(transactionService.readTransactionsByType(type));

	}
	 
	
	@PutMapping
	public ResponseEntity<Transaction> updateTransaction(long id,Transaction transaction){
		
		transactionService.updateTransaction(id, transaction);
		
		return ResponseEntity.ok(transaction);
	}
	
	
	
	@DeleteMapping
	public ResponseEntity<Optional<Transaction>> deleteTransaction(long transactionId){
		
		Optional<Transaction> transactionDeleted = transactionService.deleteTransaction(transactionId);
		
		return ResponseEntity.ok(transactionDeleted);
	}
	
}
