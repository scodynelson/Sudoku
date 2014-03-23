package sudoku.listener;

import org.apache.commons.lang3.Range;
import sudoku.SudokuFrame;
import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import javax.swing.JOptionPane;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * The {@code SetValueMouseAdapter} is a mouse adapter for input into the cells in the sudoku game user interface.
 */
public class SetValueMouseAdapter extends MouseAdapter {

	private static final Range<Integer> VALUE_RANGE = Range.between(SudokuConstants.PUZZLE_MIN_VALUE, SudokuConstants.PUZZLE_MAX_VALUE);

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	/**
	 * Public constructor.
	 *
	 * @param frame  the frame
	 * @param puzzle the puzzle
	 */
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
				frame.repaintPanel();
			}
		}
	}

	/**
	 * This method gets an acceptable input value from the user that will be used to set the guess value in the selected cell.
	 *
	 * @param sudokuCell the cell to set the value for
	 * @return the acceptable input value, or 0 if none was chosen
	 */
	private int getValue(final SudokuCell sudokuCell) {
		int value = 0;
		while (value == 0) {
			final String inputValue = JOptionPane.showInputDialog(frame.getFrame(), SudokuConstants.INPUT_DIALOG_TITLE);

			if (inputValue == null) { // Cancel button
				break;
			}

			try {
				value = getAcceptableValue(sudokuCell, inputValue);
			} catch (final NumberFormatException ignored) {
				value = 0;
			}
		}
		return value;
	}

	/**
	 * This method validates and returns an acceptable value. The method will return the selected value if it is an integer,
	 * it is within the valid range for a sudoku input value, and it is an possible value for the cell. If none of the
	 * previous conditions are met, the method will return the value 0.
	 *
	 * @param sudokuCell the cell to check for possible value
	 * @param inputValue the input value to validate
	 * @return an acceptable value if entered, or 0 otherwise
	 */
	private static int getAcceptableValue(final SudokuCell sudokuCell, final String inputValue) {
		final int value = Integer.parseInt(inputValue);
		if (VALUE_RANGE.contains(value) && sudokuCell.isPossibleValue(value)) {
			return value;
		}
		return 0;
	}

	private static void removeValue(final Map<Point, SudokuCell> cellMap, final int value, final Point point) {
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

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

		// Remove from internal block
		final int internalI = point.x / 3;
		final int internalJ = point.y / 3;
		for (int i = internalI * 3; i < ((internalI + 1) * 3); i++) {
			for (int j = internalJ * 3; j < ((internalJ + 1) * 3); j++) {
				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.removePossibleValue(value);
			}
		}
	}

	@Override
	public String toString() {
		return "SetValueMouseAdapter{"
				+ "frame=" + frame
				+ ", puzzle=" + puzzle
				+ '}';
	}
}
