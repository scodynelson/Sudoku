package sudoku.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SudokuCell implements Serializable {

	private static final long serialVersionUID = -8840221914149844975L;

	public static final int MAX_VALUE = 9;

	private final int value;
	private final boolean isInitial;
	private final Point cellLocation;
	private final int cellPosition;

	private final List<Integer> possibleValues = new ArrayList<>(MAX_VALUE);

	private int guessValue;
	private Rectangle bounds;

	public SudokuCell(final int value, final boolean isInitial, final Point cellLocation, final int cellPosition) {
		this.value = value;
		this.isInitial = isInitial;
		this.cellLocation = cellLocation;
		this.cellPosition = cellPosition;

		reset();
	}

	public final void reset() {
		guessValue = 0;
		possibleValues.clear();

		for (int i = 1; i <= MAX_VALUE; i++) {
			possibleValues.add(i);
		}
	}

	public int getValue() {
		return value;
	}

	public boolean isInitial() {
		return isInitial;
	}

	public Point getCellLocation() {
		return cellLocation;
	}

	public int getCellPosition() {
		return cellPosition;
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

	public void setBounds(final Rectangle bounds) {
		this.bounds = bounds;
	}

	public boolean contains(final Point point) {
		return bounds.contains(point);
	}
}
