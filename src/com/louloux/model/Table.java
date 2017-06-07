package com.louloux.model;

import com.louloux.view.TableState;

public class Table {

	public static void printTable(String[][] table) {

		for (String[] strings : table) {
			for (String string : strings) {
				System.out.print(string + " ");
			}
			System.out.print("\n");
		}
	}

	public static TableState observeGame(String[][] table) {

		if (xWin(table))
			return TableState.X_WIN;
		else if (oWin(table))
			return TableState.O_WIN;
		else if (nbdWin(table))
			return TableState.NB_WIN;

		return TableState.IS_PLAYING;
	}

	public static boolean xWin(String[][] table) {

		if (isAligned(table, "X"))
			return true;
		return false;
	}

	public static boolean oWin(String[][] table) {

		if (isAligned(table, "0"))
			return true;
		return false;
	}

	public static boolean nbdWin(String[][] table) {

		if (!(isAligned(table, "0") || isAligned(table, "X")))
			if(isFilled(table))
				return true;
		return false;
	}

	public static boolean isAligned(String[][] table, String chara) {

		if(isDiagonalAlignment(table, chara))
			return true;
		for (int y = 0; y < table.length; y++) {
			if (isHorizontalAlignment(table, chara, y))
				return true;
		}

		for (int x = 0; x < table[0].length; x++) {
			if (isVerticalAlignment(table, chara, x))
				return true;
		}
		
		return false;

	}
	
	public static boolean isFilled(String[][] table) {
		
		for (String[] strings : table) {
			for (String string : strings) {
				if (string == "")
					return false;
			}
		}
		return true;
	}

	public static boolean isDiagonalAlignment(String[][] table, String chara) {
		
		if (isThreeStringEquality(table[0][0], table[1][1], table[2][2]) && table[0][0] == chara)
			return true;
		if (isThreeStringEquality(table[2][0], table[1][1], table[0][2]) && table[2][0] == chara)
			return true;
		
		return false;
		
	}
	
	public static boolean isHorizontalAlignment(String[][] table, String chara, int y) {

		String[] list = table[y];

		for (String string : list) {
			if (string != chara)
				return false;
		}

		return true;
	}
	
	public static boolean isVerticalAlignment(String[][] table, String chara, int x) {

		if(isThreeStringEquality(table[0][x], table[1][x], table[2][x]) && table[0][x] == chara)
			return true;
		
		return false;
	}
	
	public static boolean isThreeStringEquality(String string1, String string2, String string3){
		
		if(string1 == string2 && string2 == string3)
			return true;
		
		return false;
	}

}
