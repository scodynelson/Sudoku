package sudoku.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Map;

public class SudokuPuzzle implements Serializable {

	private static final long serialVersionUID = -6545823351348099121L;

	private final Map<Point, SudokuCell> cellMap;

	public SudokuPuzzle(final Map<Point, SudokuCell> cellMap) {
		this.cellMap = cellMap;
		reset();
	}

	public Map<Point, SudokuCell> getCellMap() {
		return cellMap;
	}

	public SudokuCell getCellAtPoint(final Point point) {
		for (final SudokuCell cell : cellMap.values()) {
			if (cell.contains(point)) {
				return cell;
			}
		}
		return null;
	}

	public final void reset() {
		for (final SudokuCell cell : cellMap.values()) {
			cell.reset();
		}
	}

	public final void validate() {
	}
}
