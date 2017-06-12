package com.louloux.controler;

import com.louloux.model.AbstractModel;
import com.louloux.view.ButtonCase;
import com.louloux.view.CaseState;

public abstract class AbstractControler {

	protected AbstractModel calculator;
	
	public AbstractControler(AbstractModel calculator) { 
		this.calculator = calculator;
	}
	
	public void reset() { 
		calculator.reset();
	}
	
	public void controlState(int x, int y, CaseState state) { 
		control();
	}
	
	public abstract void control();

	public void clickButton(ButtonCase buttonCase) {
		// TODO Auto-generated method stub
		
	}
	
}
