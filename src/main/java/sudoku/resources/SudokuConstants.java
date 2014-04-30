package sudoku.resources;

/**
 * The {@code SudokuConstants} interface defines constants for all external resources for use in the application.
 */
public interface SudokuConstants {

	String FRAME_TITLE = SudokuResources.getString("sudoku.frame.title");
	String INPUT_DIALOG_TITLE = SudokuResources.getString("sudoku.input.dialog.title");
	String RESET_BUTTON_TEXT = SudokuResources.getString("sudoku.button.panel.reset.button.text");
	String HINT_BUTTON_TEXT = SudokuResources.getString("sudoku.button.panel.hint.button.text");
	String VALIDATE_BUTTON_TEXT = SudokuResources.getString("sudoku.button.panel.validate.button.text");
	String INVALID_INPUT_TEXT = SudokuResources.getString("sudoku.input.invalid.dialog.title");
	String VALIDATE_PANEL_TITLE = SudokuResources.getString("sudoku.button.validate.panel.title");
	String VALIDATE_PANEL_VALID_MESSAGE = SudokuResources.getString("sudoku.button.validate.panel.message.valid");
	String VALIDATE_PANEL_INVALID_MESSAGE = SudokuResources.getString("sudoku.button.validate.panel.message.invalid");
	String DIFFICULTY_DIALOG_MESSAGE = SudokuResources.getString("sudoku.difficulty.dialog.message");
	String DIFFICULTY_DIALOG_TITLE = SudokuResources.getString("sudoku.difficulty.dialog.title");

	int DRAW_WIDTH = SudokuResources.getInt("sudoku.draw.width");
	int PUZZLE_WIDTH = SudokuResources.getInt("sudoku.puzzle.width");
	int PUZZLE_MIN_VALUE = SudokuResources.getInt("sudoku.puzzle.min.value");
	int PUZZLE_MAX_VALUE = SudokuResources.getInt("sudoku.puzzle.max.value");
}
