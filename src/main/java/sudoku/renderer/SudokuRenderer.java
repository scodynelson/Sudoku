package sudoku.renderer;

import java.awt.Graphics;

public interface SudokuRenderer<TYPE> {

	void draw(TYPE object, Graphics g);
}
