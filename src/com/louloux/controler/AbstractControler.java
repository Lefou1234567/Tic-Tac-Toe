package com.louloux.controler;

import com.louloux.model.AbstractModel;
import com.louloux.view.CaseState;

public abstract class AbstractControler {

	protected AbstractModel calculator;
	
	protected  String[][] table = new String[3][3];
	
	public AbstractControler(AbstractModel calculator) { 
		this.calculator = calculator;
	}
	
	public void reset() { 
		calculator.reset();
	}
	
	public void setValue(int x, int y, CaseState state) { 
		table[y][x] = state.getValue();
		control();
	}
	
	public abstract void control();
	
}
