package iwi.zhaw.ch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sudoku {

	private int[][] sudokuArray = new int[9][9];		
	
	public boolean isValid() { 
		//check row only one value from 1-9
		for (int i = 0; i != sudokuArray.length; i++) {
			int[] row =  Arrays.copyOf(sudokuArray[i], sudokuArray[i].length);
						
			if(!isListValid(row)) {
				return false;
			}
		}
		
		//check columns only one value from 1-9				
		for(int index = 0; index != 9; index++) {
			int[] column = new int[9];
			for(int i=0; i<9; i++){
			       column[i] = sudokuArray[i][index];
			}
			
			if(!isListValid(column)) {
				return false;
			}
		}
		
		//check box that in the box only values from 1-9 appear once		
		for (int i = 0; i < 9; i = i + 3) {
			for (int y = 0; y < 9; y = y + 3) {
				if(!isListValid(getBox(i, y))) {
					return false;
				}
			}
		}		
		return true;
	}		
	

	public void load(String fileName) throws IOException {
		File file = new File("data/" + fileName);

		// Open the file
		FileInputStream fstream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		int counter = 0;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			
			int [] values = Stream.of(strLine.split(" "))
					  .mapToInt(Integer::parseInt)
					  .toArray();
			sudokuArray[counter] = values;
			counter ++;
			//System.out.println(strLine);
		}

		// Close the input stream
		fstream.close();
	}		
	

	@Override
	public String toString() {
		if (sudokuArray == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i != sudokuArray.length; i++) {
			for (int y = 0; y != sudokuArray[i].length; y++) {
				if (y == 3 || y == 6) {
					sb.append(" |");
				}
				sb.append(" " + sudokuArray[i][y]);
			}
			sb.append("\n");
			if (i == 2 || i == 5) {
				sb.append("-------|-------|-------\n");
			}
		}
		return sb.toString();
	}
	
	
	private boolean isListValid(int[] list) {
		Arrays.sort(list);
		
		int expectedValue = 1;
		for (int cell : list) {
			if(expectedValue != cell) {
				return false;
			}
			expectedValue ++;			
		}
		return true;
	}
	
	
	private int[] getBox(final int rowIndex, final int columnIndex) {
		List<Integer> box = new ArrayList<Integer>();
		for (int i = rowIndex; i != rowIndex + 3; i++) {
			for (int y = columnIndex; y != columnIndex+3; y++) {
				box.add(sudokuArray[i][y]);
			}
		}
		return box.stream().mapToInt(i -> i).toArray();						
	}	
}
