package sudoku.model;

import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SudokuCell implements Serializable {

	private static final long serialVersionUID = -8840221914149844975L;

	private final int value;
	private final boolean isInitial;
	private final SudokuCellBorder cellBorder;
	private final Point cellLocation;
	private final Rectangle bounds;

	private final List<Integer> possibleValues = new ArrayList<>(SudokuConstants.PUZZLE_WIDTH);

	private int guessValue;

	public SudokuCell(final int value, final boolean isInitial, final SudokuCellBorder cellBorder,
					  final Point cellLocation) {
		this.value = value;
		this.isInitial = isInitial;
		this.cellBorder = cellBorder;

		this.cellLocation = cellLocation;
		bounds = getRectangle(cellLocation);

		reset();
	}

	private static Rectangle getRectangle(final Point cellLocation) {

		final int row = cellLocation.x;
		final int column = cellLocation.y;

		final int drawWidth = SudokuConstants.DRAW_WIDTH;

		final int x = column * drawWidth;
		final int y = row * drawWidth;

		return new Rectangle(x, y, drawWidth, drawWidth);
	}

	public final void reset() {
		guessValue = 0;
		possibleValues.clear();

		for (int i = 1; i <= SudokuConstants.PUZZLE_WIDTH; i++) {
			possibleValues.add(i);
		}
	}

	public int getValue() {
		return value;
	}

	public boolean isInitial() {
		return isInitial;
	}

	public SudokuCellBorder getCellBorder() {
		return cellBorder;
	}

	public Point getCellLocation() {
		return cellLocation;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public int getGuessValue() {
		return guessValue;
	}

	public void setGuessValue(final int guessValue) {
		this.guessValue = guessValue;
	}

	public List<Integer> getPossibleValues() {
		return possibleValues;
	}

	public int getPossibleValuesCount() {
		return possibleValues.size();
	}

	public boolean isPossibleValue(final Integer possibleValue) {
		return possibleValues.contains(possibleValue);
	}

	public void removePossibleValue(final Integer possibleValue) {
		possibleValues.remove(possibleValue);
	}

	public void clearPossibleValues() {
		possibleValues.clear();
	}

	public boolean contains(final Point point) {
		return bounds.contains(point);
	}
}
