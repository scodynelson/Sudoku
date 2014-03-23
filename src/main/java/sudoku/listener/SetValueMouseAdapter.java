package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.SudokuResources;
import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;
import sudoku.model.SudokuPuzzleService;

import javax.swing.JOptionPane;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
				SudokuPuzzleService.removeValue(puzzle.getCellMap(), value, sudokuCell.getCellLocation());
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
}
