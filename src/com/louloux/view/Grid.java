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
				initState(x, y);
				initButton(x, y);
				this.add(buttons[y][x]);
			}
		}
	}
	
	public void initState(int x, int y) {
		states[y][x] = CaseState.NULL_STATE;
	}
	
	public void initButton(int x, int y) {
		buttons[y][x] = new ButtonCase(x, y, states[y][x]); 
		buttons[y][x].setPreferredSize(caseDimension);
		buttons[y][x].addActionListener(new CaseListener());
	}
	
	class CaseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ButtonCase buttonCase = (ButtonCase)e.getSource();
			
			if(buttonCase.isModifiable())
				System.out.println("This case can be modified !");
			else
				System.out.println("This case can't be modified !");
			
		} 		
	}
	
}
