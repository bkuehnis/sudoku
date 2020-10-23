package solution.iwi.zhaw.ch;

import java.io.IOException;

public class Start {
	
	public static void main(String[] args) {	
		Sudoku sudoku = new Sudoku();

		try {
			sudoku.load("sudoku1");
			System.out.println(sudoku.toString());
			
			System.out.println("Sudoku is " + (sudoku.isValid() ? "correct" : "incorrect"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
