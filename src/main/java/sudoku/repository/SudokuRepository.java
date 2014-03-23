package sudoku.repository;

import sudoku.model.SudokuPuzzle;

/**
 * The {@code SudokuRepository} object is used for storing and retrieving sudoku puzzles for the sudoku game.
 */
public class SudokuRepository {

	public static final SudokuRepository INSTANCE = new SudokuRepository();

	/**
	 * Private constructor.
	 */
	private SudokuRepository() {
	}

	/**
	 * Getter for the sudoku puzzle.
	 *
	 * @return the sudoku puzzle
	 */
	public SudokuPuzzle getPuzzle() {
		return SudokuMockDB.SAMPLE_PUZZLE;
	}
}
