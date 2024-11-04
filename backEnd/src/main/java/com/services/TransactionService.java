package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.TransactionDto;
import com.entities.Category;
import com.entities.Transaction;
import com.enuns.TransactionType;
import com.repositories.CategoryRepository;
import com.repositories.TransactionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Transaction save(TransactionDto transactionDto) {

		String nomeCategoria = transactionDto.getCategoria();

		Category categoria = categoryRepository.findByNome(nomeCategoria);

		TransactionType type = transactionDto.getType();

		if (categoria == null) {
			throw new RuntimeException("categoria nao encontrada, verifique a categoria inserida");
		}
		;

		Transaction transaction = new Transaction();

		transaction.setCategoria(categoria);
		transaction.setDescription(transactionDto.getDescription());
		transaction.setData(transactionDto.getData());
		transaction.setType(type);
		transaction.setValor(transactionDto.getValor());

		return transactionRepository.save(transaction);
	}

	public List<TransactionDto> readTransaction() {

		List<Transaction> transactions = transactionRepository.findAll();

		List<TransactionDto> listTransactionsDto = new ArrayList<TransactionDto>();

		if (transactions.size() <= 0) {
			throw new EntityNotFoundException("nao foi encotrada nenhuma transacao");
		}

		transactions.forEach(transaction -> {
			TransactionDto transactionDto = new TransactionDto();

			transactionDto.setId(transaction.getId());
			transactionDto.setValor(transaction.getValor());
			transactionDto.setData(transaction.getData());
			transactionDto.setDescription(transaction.getDescription());
			transactionDto.setCategoria(transaction.getCategoria().getNome());
			transactionDto.setType(transaction.getType());

			listTransactionsDto.add(transactionDto);
		});

		return listTransactionsDto;
	}

	public List<TransactionDto> readTransactionsByType(TransactionType type) {

		List<Transaction> transactions = transactionRepository.findByType(type);

		if (transactions.size() <= 0) {
			throw new EntityNotFoundException("Transacoes do tipo" + type + "nao encontrada");
		}

		List<TransactionDto> listTransactionsDto = new ArrayList<TransactionDto>();

		transactions.forEach(transaction -> {
			TransactionDto transactionDto = new TransactionDto();

			transactionDto.setId(transaction.getId());
			transactionDto.setValor(transaction.getValor());
			transactionDto.setData(transaction.getData());
			transactionDto.setDescription(transaction.getDescription());
			transactionDto.setCategoria(transaction.getCategoria().getNome());
			transactionDto.setType(transaction.getType());

			listTransactionsDto.add(transactionDto);
		});

		return listTransactionsDto;
	}

	public Optional<Transaction> readTransactionsById(long id) {

		if (!transactionRepository.existsById(id)) {
			throw new EntityNotFoundException("Transação não encontrada");
		}

		return transactionRepository.findById(id);
	}

	public void updateTransaction(long id, Transaction transaction) {
		if (!transactionRepository.existsById(id)) {
			throw new EntityNotFoundException("Transação não encontrada");
		}
		;

		transactionRepository.save(transaction);
	}

	public Optional<Transaction> deleteTransaction(long id) {

		if (!transactionRepository.existsById(id)) {
			throw new EntityNotFoundException("Transação não encontrada");
		}

		transactionRepository.deleteById(id);

		return transactionRepository.findById(id);
	}

}
