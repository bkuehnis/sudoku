package solution.iwi.zhaw.ch;

public class Column {
	private Cell[] cells = new Cell[9];
	private int index = 0;
	private CellValidator cellValidator;
	
	public Column(CellValidator cellValidator) {
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
	
	public boolean isValid() {
		return cellValidator.isValid(cells);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Cell cell : cells) {
			sb.append(cell.getValue() + "\n");
		}
		return sb.toString();
	}
}
