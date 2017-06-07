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
	
	private ButtonCase[][] buttonCases = new ButtonCase[3][3];
	 private static JPanel container = new JPanel();

	 private Dimension caseDimension;
	 private Font caseFont;
	 
	 private String[][] valuesOfCases = new String[3][3];
	
	 private AbstractControler controler;
	
	
	public Window(AbstractControler controler) {
		this.controler = controler; 
		
		this.setTitle("Tic-Tac-Toe");
		this.setSize(700, 700); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		initComponent();
		this.setVisible(true);
		
	}
	
	public  void initComponent() {
		initCases();
		this.setContentPane(container);
	}
	
	public void initContainer() {
		
	}
	
	public  void initCases() {
		caseDimension = new Dimension((int)(this.getWidth() * 0.32), (int)(this.getHeight() * 0.32));
		caseFont = new Font("Impact", Font.BOLD, 50);
		
		for(int y = 0; y < buttonCases.length; y++) {
			for(int x = 0; x < buttonCases[y].length; x++) {
				buttonCases[y][x] = initCaseButton(x, y, buttonCases[y][x]);
				buttonCases[y][x].addActionListener(new CaseListener());
				container.add(buttonCases[y][x]);
			}
		}
	}
	
	public ButtonCase initCaseButton(int posX, int posY, ButtonCase button) {
		button = new ButtonCase(posX, posY, CaseState.NULL_STATE.getValue());
		button.setPreferredSize(caseDimension);
		button.setFont(caseFont);
		return button;
	}
	
	class CaseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ButtonCase buttonCase = (ButtonCase)e.getSource();
			
			if(buttonCase.isModifiable())
				modifyCase(buttonCase);
			else
				System.out.println("This case can't be modified !");
			
		} 		
	}
	
	public void modifyCase(ButtonCase buttonCase) {
		controler.setValue(buttonCase.getPosX(), buttonCase.getPosY(), CaseState.X_STATE);
	}

	@Override
	public void update(String[][] table, TableState state) {
		this.valuesOfCases = table;
		updateTable();
		
	}
	
	public void updateTable() {
		for(int y = 0; y < valuesOfCases.length; y++) {
			for(int x = 0; x < valuesOfCases[y].length; x++) {
				buttonCases[y][x].setName(valuesOfCases[y][x]);
			}
		}

	}
	
}
