package com.louloux.model;

import com.louloux.view.ButtonCase;
import com.louloux.view.CaseState;
import com.louloux.view.TableState;
import com.louloux.view.Window;

public class Calculator extends AbstractModel {
	
	private Players player = Players.X_PLAYER;
	
	public void reset() {
		Window.gameTable.setNewTable();
	}
	
	public void observeGameTable() {
		Window.gameTable.updateState();
		notifyObserver();
		
	}

	public void clickButton(ButtonCase buttonCase) {
		
		if(this.player.equals(Players.X_PLAYER)) { 
			Window.modifyCase(buttonCase, CaseState.X_STATE);
			setOPlayerTurn();
		}
		else {
			Window.modifyCase(buttonCase, CaseState.O_STATE);
			setXPlayerTurn();
		}

	}
	
	public void setOPlayerTurn() {
		player = Players.O_PLAYER;
		
		if(Window.gameTable.getState().equals(TableState.IS_PLAYING))
			System.out.println("C'est au tour des O !");
	}
	
	public void setXPlayerTurn() {
		player = Players.X_PLAYER;
		
		if(Window.gameTable.getState().equals(TableState.IS_PLAYING))
			System.out.println("C'est au tour des X !");
	}
}
