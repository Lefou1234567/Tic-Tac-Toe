package com.louloux.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.louloux.controler.AbstractControler;
import com.louloux.observer.Observer;

public class Window extends JFrame implements Observer {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Grid gameTable;
	
	 private AbstractControler controler;
	
	
	public Window(AbstractControler controler) {
		this.controler = controler; 
		
		this.setTitle("Tic-Tac-Toe");
		this.setSize(700, 700); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		initComponents();
		this.setVisible(true);
		
	}
	
	public  void initComponents() {
		gameTable =  new Grid(new Dimension((int)(this.getWidth() * 0.32), (int)(this.getHeight() * 0.32)));
		this.setContentPane(gameTable);
	}
	
	public void modifyCase(ButtonCase buttonCase) {
		controler.setValue(buttonCase.getPosX(), buttonCase.getPosY(), CaseState.X_STATE);
	}

	@Override
	public void update(String[][] table, TableState state) {
		updateTable();
		
	}
	
	public void updateTable() {
		

	}
	
}
