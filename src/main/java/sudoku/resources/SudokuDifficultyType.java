package sudoku.resources;

/**
 * The {@code SudokuDifficultyType} defines the type of difficulty of puzzle that will be returned to the UI.
 */
public enum SudokuDifficultyType {

	EASY("Easy"),
	MEDIUM("Medium"),
	HARD("Hard"),
	CHALLENGING("Challenging");

	private final String value;

	/**
	 * Package constructor.
	 *
	 * @param value text value of the difficulty type
	 */
	SudokuDifficultyType(final String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
