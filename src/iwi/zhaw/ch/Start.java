package iwi.zhaw.ch;

import java.io.IOException;



public class Start {
	public static void main(String[] args) {
		
		
		Sudoku sudoku = new Sudoku();
		try {
			sudoku.load("sudoku1");
			System.out.println(sudoku.toString());
			
			System.out.println(sudoku.isValid());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
