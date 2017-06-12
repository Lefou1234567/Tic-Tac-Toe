package com.louloux.controler;

import com.louloux.model.AbstractModel;
import com.louloux.view.ButtonCase;
import com.louloux.view.TableState;
import com.louloux.view.Window;

public class GameControler extends AbstractControler {

	public GameControler(AbstractModel calculator) {
		super(calculator);
	}

	@Override
	public void control() {
		calculator.observeGameTable();
	}
	
	public void clickButton(ButtonCase buttonCase) { 
		if(buttonCase.isModifiable())
				calculator.clickButton(buttonCase);
	}
}
