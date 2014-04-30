package sudoku.repository;

import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuDifficultyType;

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
	 * @param difficultyType the difficulty of the puzzle to return
	 * @return the sudoku puzzle
	 */
	public SudokuPuzzle getPuzzle(final SudokuDifficultyType difficultyType) {
		switch (difficultyType) {
			case EASY:
				return SudokuEasyPuzzle.EASY_PUZZLE;
			case MEDIUM:
				return SudokuMediumPuzzle.MEDIUM_PUZZLE;
			case HARD:
				return SudokuHardPuzzle.HARD_PUZZLE;
			case CHALLENGING:
				return SudokuChallengingPuzzle.CHALLENGING_PUZZLE;
			default:
				break;
		}
		return null;
	}

	@Override
	public String toString() {
		return "SudokuRepository{}";
	}
}
