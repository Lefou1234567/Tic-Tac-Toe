package com.louloux.view;

public enum CaseState {
	X_STATE("X"), O_STATE("O"), NULL_STATE("");
	
	private String value;
	
	CaseState(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
