package com.louloux.model;

import com.louloux.view.CaseState;
import com.louloux.view.Window;

public class Calculator extends AbstractModel {
	
	public void reset() {
		Window.gameTable.setNewTable();
	}
	
	public void observeGameTable() {
		Window.gameTable.updateState();
		notifyObserver();
		
	}
	
	

}
