package sudoku.model;

import sudoku.SudokuResources;

import java.awt.Point;
import java.io.Serializable;

public class SudokuPuzzle implements Serializable {

	private static final long serialVersionUID = -6545823351348099121L;

	private final SudokuCell[][] cells;

	public SudokuPuzzle(final SudokuCell[][] cells) {
		this.cells = cells;
		reset();
	}

	public SudokuCell[][] getCells() {
		return cells;
	}

	public SudokuCell getCellAtPoint(final Point point) {
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");
		for (int i = 0; i < puzzleWidth; i++) {
			for (int j = 0; j < puzzleWidth; j++) {
				if (cells[i][j].contains(point)) {
					return cells[i][j];
				}
			}
		}
		return null;
	}

	public final void reset() {
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");
		for (int i = 0; i < puzzleWidth; i++) {
			for (int j = 0; j < puzzleWidth; j++) {
				cells[i][j].reset();
			}
		}
	}
}
