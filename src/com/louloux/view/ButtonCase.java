package com.louloux.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ButtonCase extends JButton implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int posX;
	private int posY;
	
	private String name;
	
	Font nameFont = new Font( "SansSerif", Font.BOLD, 100);
	
	private Color defaultColor = new Color(244, 247, 247);
	private Color enteredColor = new Color(227, 246, 243);
	private Color pressedColor = new Color(196, 237, 228);
	
	private Color currentColor = defaultColor;
	
	public ButtonCase(int posX, int posY, String name) {
		super(name);
		this.posX = posX;
		this.posY = posY;
		this.name = name;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		
		g.setFont(nameFont);
		FontMetrics fm = g.getFontMetrics();
	    int height = fm.getHeight();
	    int width = fm.stringWidth(this.name);
		
		g.setColor(currentColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		g.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4)); 
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		currentColor = enteredColor;
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		currentColor = defaultColor;
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		currentColor = pressedColor;
		
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth()))
			currentColor = enteredColor;
		else
			currentColor = defaultColor;
		
	}
	
	public boolean isModifiable() {
		if(this.name == CaseState.NULL_STATE.getValue())
			return true;
		return false;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
}
