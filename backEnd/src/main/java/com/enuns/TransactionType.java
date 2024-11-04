package com.enuns;

public enum TransactionType {

	Despesa(0),
	Receita(1);

	private final int type;


	TransactionType(int type) {
		this.type = type;
	};
	
	public int getType() {
		return type;
	}
	
	
	public static TransactionType valueOf(int type) {
	        for (TransactionType transactionType : TransactionType.values()) {
	            if (transactionType.getType() == type) {
	                return transactionType;
	            }
	        }
	        throw new IllegalArgumentException("Tipo de transação inválido: " + type);
	    }

};
