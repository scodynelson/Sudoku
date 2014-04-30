package sudoku.renderer;

import java.awt.Graphics;

/**
 * The {@code SudokuRenderer} object is an abstraction for the rendering capabilities needed when rendering the sudoku game.
 *
 * @param <T> the type of object to render
 */
interface SudokuRenderer<T> {

	/**
	 * The rendering method for rendering the sudoku game object.
	 *
	 * @param object the object to render
	 * @param g      the graphic used when rendering the object
	 */
	void render(T object, Graphics g);
}
