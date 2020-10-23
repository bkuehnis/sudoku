package solution.iwi.zhaw.ch;

public class Box {
	private Cell[] cells = new Cell[9];
	private int index = 0;
	private CellValidator cellValidator;
	
	public Box(CellValidator cellValidator) {
		this.cellValidator = cellValidator;
	}

	public boolean addCell(int value) {
		cells[index] = new Cell(value);
		index++;
		return true;
	}
	
	public boolean addCell(Cell cell) {
		cells[index] = cell;
		index++;
		return true;
	}
	
	public Cell[] getCells() {
		return cells;
	}
		
	public boolean canAdd() {
		return index <= 8;
	}
	
	public boolean isValid() {
		return cellValidator.isValid(cells);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(Cell cell : cells) {
			sb.append(cell.getValue() + " ");
			if(i == 2 || i == 5) {
				sb.append("\n");
			}
			i++;
		}		
		return sb.toString();
	}
}
