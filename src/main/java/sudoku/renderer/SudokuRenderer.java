package sudoku.renderer;

import java.awt.Graphics;

/**
 * The {@code SudokuRenderer} object is an abstraction for the rendering capabilities needed when drawing the sudoku game.
 *
 * @param <TYPE> the type of object to render
 */
public interface SudokuRenderer<TYPE> {

	/**
	 * The rendering method for drawing the sudoku game object.
	 *
	 * @param object the object to render
	 * @param g      the graphic used when rendering the object
	 */
	void draw(TYPE object, Graphics g);
}
