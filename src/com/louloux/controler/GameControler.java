package com.louloux.controler;

import com.louloux.model.AbstractModel;

public class GameControler extends AbstractControler {

	public GameControler(AbstractModel calculator) {
		super(calculator);
	}

	@Override
	public void control() {
		calculator.setTable(table);
	}

}
