package com;

import com.louloux.controler.AbstractControler;
import com.louloux.controler.GameControler;
import com.louloux.model.AbstractModel;
import com.louloux.model.Calculator;
import com.louloux.view.Window;


public class Main {
	public static void main(String[] args) {
		
		AbstractModel calculator = new Calculator();
		AbstractControler controler = new GameControler(calculator);
		Window window = new Window(controler);
		calculator.addObserver(window); 
	}
}
