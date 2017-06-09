package com.louloux.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Grid extends JPanel {

	private CaseState[][] states = new CaseState[3][3];
	private ButtonCase[][] buttons = new ButtonCase[3][3];
	private TableState state;
	
	private Dimension caseDimension;
	 
	
	public Grid(Dimension caseDimension) {
		this.caseDimension = caseDimension;
		initComponents();
	}
	
	public void initComponents() {
		initTables();
	}
	
	public void initTables() {
		
		for(int y = 0; y < buttons.length; y++) {
			for(int x = 0; x < buttons[y].length; x++){
				initCaseState(x, y);
				initButton(x, y);
				this.add(buttons[y][x]);
			}
		}
	}
	
	public void initCaseState(int x, int y) {
		states[y][x] = CaseState.NULL_STATE;
	}
	
	public void initButton(int x, int y) {
		buttons[y][x] = new ButtonCase(x, y, states[y][x]); 
		buttons[y][x].setPreferredSize(caseDimension);
		buttons[y][x].addActionListener(new CaseListener());
	}
	
	public void updateState() {
		state = observeGame();
		System.out.println(this.state.name());
	}
	
	public TableState observeGame() { 
		
		if(xWin())
			return TableState.X_WIN;
		if(oWin())
			return TableState.O_WIN;
		if(nobodyWin())
			return TableState.NOBODY_WIN;
		
		
		return TableState.IS_PLAYING;
	}
	
	public boolean xWin() {
		
		if (xIsAligned())
			return true;
		return false;
	}
	
	public boolean xIsAligned() {
		
		if (isAligned(CaseState.X_STATE)) 
			return true;
		return false;
	}
	
	public boolean oWin() {
		
		if (oIsAligned())
			return true;
		return false;
	}
	
	public boolean oIsAligned() {
		
		if (isAligned(CaseState.O_STATE))
			return true;
		return false;
	}
	
	public boolean nobodyWin() {
		
		if (!(xWin() || oWin()))
			if(isFilled())
				return true;

		return false;
	}
	
	public boolean isFilled() {
		
		for (CaseState[] states : this.states) {
			for (CaseState state : states) {
				if(state.equals(CaseState.NULL_STATE))
					return false;
			}
		}
		
		return true;
	}
	
	public boolean isAligned (CaseState state) {
		
		if(isDiagonalAlignment(state))
			return true;
		
		else if (isHorizontalAlignment(state))
			return true;
		

		else if (isVerticalAlignment(state))
			return true;
		
		return false;
	}
	
	public boolean isDiagonalAlignment(CaseState state) {
		
			if(areCaseStatesEquals(state, this.states[0][0], this.states[1][1], this.states[2][2]))
				return true;
			else if(areCaseStatesEquals(state, this.states[0][2], this.states[1][1], this.states[2][0]))
				return true;
			
		return false;
	}

	public boolean isHorizontalAlignment(CaseState state) {

		for (CaseState[] caseStates : this.states) {
			if (isAlignmentIn(caseStates, state))
				return true;
		}
		
		return false;
	}
	
	public boolean isAlignmentIn(CaseState[] caseStates, CaseState state) {
		
		for (CaseState caseState : caseStates) {
			if (!caseState.equals(state))
				return false;
		}
		
		return true;
	}
	
	public boolean isVerticalAlignment(CaseState state) {
		
		for(int x = 0; x < this.states[0].length; x++) {
			if(areCaseStatesEquals(state, states[0][x], states[1][x], states[2][x]))
				return true;
		}
		
		return false;
	}
	
	public boolean areCaseStatesEquals(CaseState state, CaseState state1, CaseState state2, CaseState state3) {
		if (state.equals(state1) && (state1.equals(state2) && state2.equals(state3))) 
			return true;
		
		return false;
	}
	
	public void updateTable() {
		for(int y = 0; y < buttons.length; y++) {
			for(int x = 0; x < buttons[y].length; x++) {
				buttons[y][x].setState(states[y][x]);
			}
		}
	}
	
	
	public void setNewTable() {
		for(int y = 0; y < this.states.length; y++) {
			for(int x = 0; x < this.states[y].length; x++) {
				states[y][x] = CaseState.NULL_STATE;
			}
		}
	}
	
	public void changeValueAt(int x, int y, CaseState state) {
		this.states[y][x] = state;
		
	}
	
	public CaseState[][] getStates() {
		return states;
	}

	public void setStates(CaseState[][] states) {
		this.states = states;
	}

	public TableState getState() {
		return state;
	}

	public void setCaseDimension(Dimension caseDimension) {
		this.caseDimension = caseDimension;
	}

	class CaseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ButtonCase buttonCase = (ButtonCase)e.getSource();
			
			if(buttonCase.isModifiable())
				Window.modifyCase(buttonCase);
			else
				System.out.println("This case can't be modified !");
			
		} 		
	}
	
}
