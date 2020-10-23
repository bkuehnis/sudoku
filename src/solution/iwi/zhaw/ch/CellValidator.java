package solution.iwi.zhaw.ch;

import java.util.Arrays;

public class CellValidator {

	/**
	 * Test if the array of cells only contains unique values and the values start from 1 to n
	 * @param cells
	 */
	public boolean isValid(Cell[] cells) {
		int[] values = new int[cells.length];
		for(int i = 0; i != cells.length; i++) {
			values[i] = cells[i].getValue();
		}
		Arrays.sort(values);				
		
		int expectedValue = 1;
		
		for (int i = 0; i != values.length; i++) {
			int cell = values[i];
			
			if(expectedValue != cell) {
				return false;
			}
			expectedValue ++;
		}
		
		expectedValue = 1;
		for (int cell : values) {
			if(expectedValue != cell) {
				return false;
			}
			expectedValue ++;			
		}
		return true;		
	}
}
