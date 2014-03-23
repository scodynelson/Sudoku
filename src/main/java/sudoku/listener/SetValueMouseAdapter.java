package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.SudokuResources;
import sudoku.SudokuUtils;
import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;

import javax.swing.JOptionPane;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class SetValueMouseAdapter extends MouseAdapter {

	private final SudokuFrame frame;

	private final SudokuPuzzle puzzle;

	public SetValueMouseAdapter(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void mousePressed(final MouseEvent e) {
		final Point point = e.getPoint();

		final SudokuCell sudokuCell = puzzle.getCellAtPoint(point);
		if (sudokuCell != null) {
			final int value = getValue(sudokuCell);
			if (value > 0) {
				sudokuCell.setGuessValue(value);
				removeValue(puzzle.getCellMap(), value, sudokuCell.getCellLocation());
				sudokuCell.clearPossibleValues();
				frame.repaintSudokuPanel();
			}
		}
	}

	private int getValue(final SudokuCell sudokuCell) {
		int value = 0;
		while (value == 0) {
			final String inputValue = JOptionPane.showInputDialog(frame.getFrame(), SudokuResources.get("sudoku.input.dialog.title"));

			if (inputValue == null) { // Cancel button
				break;
			}

			try {
				value = testValue(sudokuCell, inputValue);
			} catch (final NumberFormatException ignored) {
				value = 0;
			}
		}
		return value;
	}

	private static int testValue(final SudokuCell sudokuCell, final String inputValue) {

		final int value = Integer.parseInt(inputValue);

		if ((value < 1) || (value > 9)) {
			return 0;
		}
		if (!sudokuCell.isPossibleValue(value)) {
			return 0;
		}
		return value;
	}

	private static void removeValue(final Map<Point, SudokuCell> cellMap, final int value, final Point point) {
		final int puzzleWidth = SudokuUtils.PUZZLE_WIDTH;

		// Remove from Y axis
		for (int i = 0; i < puzzleWidth; i++) {
			final Point pointToGet = new Point(i, point.y);
			final SudokuCell currentCell = cellMap.get(pointToGet);
			currentCell.removePossibleValue(value);
		}

		// Remove from X axis
		for (int j = 0; j < puzzleWidth; j++) {
			final Point pointToGet = new Point(point.x, j);
			final SudokuCell currentCell = cellMap.get(pointToGet);
			currentCell.removePossibleValue(value);
		}

		// Remove from paired block
		final int ii = point.x / 3;
		final int jj = point.y / 3;
		for (int i = ii * 3; i < ((ii + 1) * 3); i++) {
			for (int j = jj * 3; j < ((jj + 1) * 3); j++) {
				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.removePossibleValue(value);
			}
		}
	}
}
