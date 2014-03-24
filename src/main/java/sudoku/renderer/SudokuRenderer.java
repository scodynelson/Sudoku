package sudoku.renderer;

import java.awt.Graphics;

/**
 * The {@code SudokuRenderer} object is an abstraction for the rendering capabilities needed when rendering the sudoku game.
 *
 * @param <TYPE> the type of object to render
 */
interface SudokuRenderer<TYPE> {

	/**
	 * The rendering method for rendering the sudoku game object.
	 *
	 * @param object the object to render
	 * @param g      the graphic used when rendering the object
	 */
	void render(TYPE object, Graphics g);
}
