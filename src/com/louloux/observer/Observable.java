package com.louloux.observer;

import java.util.ArrayList;

import com.louloux.view.TableState;

public interface Observable {
	ArrayList<Observer> listObserver = new ArrayList<Observer>(); 
	
	public void addObserver(Observer listObserver);
	public void removeObserver();
	public void notifyObserver(String[][] table, TableState state);
}
