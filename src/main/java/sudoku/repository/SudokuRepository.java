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
	public SudokuPuzzle getPuzzle(String difficulty) {
        switch (difficulty) {
            case "Easy":
                return SudokuEasyPuzzle.EASY_PUZZLE;
            case "Medium":
                return SudokuMediumPuzzle.MEDIUM_PUZZLE;
            case "Hard":
                return SudokuHardPuzzle.HARD_PUZZLE;
            case "Challenging":
                return SudokuChallengingPuzzle.CHALLENGING_PUZZLE;
            default:
                break;
        }
        return null;
	}
}
