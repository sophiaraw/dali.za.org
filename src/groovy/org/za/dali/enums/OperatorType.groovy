package org.za.dali.enums

enum OperatorType {
	GREATER_THAN('GT','>'),
	GREATER_THAN_EQUAL('GE','>='),
	LESS_THAN('LT','<'),
	LESS_THAN_EQUAL('LE','<=')
	
	String id
	String symbol
	
	OperatorType(String id, String symbol) {
		this.id = id
		this.symbol = symbol
	}
	
	String toString() {
		return symbol
	}
}
