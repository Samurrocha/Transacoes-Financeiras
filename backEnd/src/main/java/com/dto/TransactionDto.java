package com.dto;

import java.util.Date;

import com.enuns.TransactionType;

public class TransactionDto {

	private long id;
	private double valor;
	private Date data;
	private String description;
	private String categoria; // Campo para o nome da categoria
	private TransactionType type;

	

	public TransactionDto() {
		
	}

	// Getters e setters
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
