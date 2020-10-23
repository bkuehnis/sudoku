package solution.iwi.zhaw.ch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {

	private Cell[] cells = new Cell[81];
	private Row[] rows = new Row[9];
	private Column[] columns = new Column[9];
	private Box[] boxes = new Box[9];
	
	
	public boolean isValid() { 			
		for (int i = 0; i < 9; i++) {			
			if(!rows[i].isValid() || !columns[i].isValid() || !boxes[i].isValid()) {
				return false;
			}		
		}		
		return true;
	}		
	

	/**
	 * Loads the sudoku values of {@code fileName} 
	 * @param fileName name of file located under ./data
	 * @throws IOException
	 */
	public void load(String fileName) throws IOException {
		File file = new File("data/" + fileName);

		// Open the file
		FileInputStream fstream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		int indexOfCell = 0;
		
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			for(char c : strLine.toCharArray()) {
				if(c != ' '){
					cells[indexOfCell] = new Cell(Character.getNumericValue(c));
					indexOfCell++;															
				}
			}							
		}
		// Close the input stream
		fstream.close();
		
		
		for(int i = 0; i != 9; i++) {
			columns[i] = new Column(new CellValidator());
			rows[i] = new Row(new CellValidator());
			boxes[i] = new Box(new CellValidator());
		}
		
		int rowIndex = 0;
		int cellCounter = 0;
		int boxIndex = 0;
		
		
		for(Cell cell : cells) {
			
			//add cell to row
			if(!rows[rowIndex].canAdd()) {	
				rowIndex ++;
			}
			rows[rowIndex].addCell(cell);
			
			//add cell to column
			columns[cellCounter % 9].addCell(cell); 
			cellCounter++;
			
			//add cell to the corresponding box
			boxes[boxIndex].addCell(cell);
			if(cellCounter % 3 == 0) {
				if(cellCounter % 9 == 0 && boxes[boxIndex].canAdd()) {
					boxIndex = boxIndex - 2;
				}else {
					boxIndex++;	
				}
			}
		}
	}		
	

	/**
	 * Return the Sudoku as String
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(Row row : rows) {
			sb.append(row + "\n");
			
			if(i == 2 || i == 5) {
				sb.append("------|-------|-------\n");
			}
			i++;
		}		
		return sb.toString();
	}		
}
