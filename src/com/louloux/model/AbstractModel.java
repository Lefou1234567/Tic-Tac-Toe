package com.louloux.model;


import java.util.ArrayList;

import com.louloux.observer.Observable;
import com.louloux.observer.Observer;
import com.louloux.view.ButtonCase;

public abstract class AbstractModel implements Observable {
	 
	
	@Override
	public void addObserver(Observer observer) {
		listObserver.add(observer);
		
	}

	@Override
	public void removeObserver() {
		ArrayList<Observer> listObserver = new ArrayList<Observer>();
		
	}

	@Override
	public void notifyObserver() {
		
		for (Observer observer : listObserver) {
			observer.update();
		}
		
	}
	
	public abstract void reset();
	
	public abstract void observeGameTable();
	
	public abstract void clickButton(ButtonCase button);

}
