package sudoku.ui;

import org.apache.commons.lang3.Range;
import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import javax.swing.JOptionPane;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		final SudokuCell cell = puzzle.getCellAtPoint(point);
		if (cell != null) {
			final int value = getValue(cell);
			if (value > 0) { // Cancel button
				cell.setGuessValue(value);
				puzzle.removeValues(cell);
				cell.clearPossibleValues();
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
	private int getAcceptableValue(final SudokuCell sudokuCell, final String inputValue) {
		final int value = Integer.parseInt(inputValue);
		if (VALUE_RANGE.contains(value) && sudokuCell.isPossibleValue(value)) {
			return value;
		} else {
            JOptionPane.showMessageDialog(frame.getFrame(), SudokuConstants.INVALID_INPUT_TEXT);
        }
		return 0;
	}

	@Override
	public String toString() {
		return "SetValueMouseAdapter{"
				+ "frame=" + frame
				+ ", puzzle=" + puzzle
				+ '}';
	}
}
