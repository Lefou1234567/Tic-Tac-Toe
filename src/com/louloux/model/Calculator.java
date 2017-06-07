package com.louloux.model;

import com.louloux.view.CaseState;

public class Calculator extends AbstractModel {
	String[][] table = { { "", "", "" }, { "", "", "" }, { "", "", "" } };
	
	public void reset() {
		setNewTable();
	}
	
	public void setNewTable() {
		setTable(getNewTable());
	}
	
	public String[][] getNewTable() {
		String[][] table = new String[3][3];
		
		for(int y = 0; y < table.length; y++) {
			for(int x = 0; x < table[y].length; x++) {
				table[y][x] = CaseState.NULL_STATE.getValue();
			}
		}
		return table;
	}
	
	public void observeTable(String [][] table) {
		Table.observeGame(table);
	}


	public void setTable(String[][] table) { 

		this.table = table;
		
		notifyObserver(table, Table.observeGame(table));
	}
}
