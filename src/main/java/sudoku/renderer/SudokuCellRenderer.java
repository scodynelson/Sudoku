package sudoku.renderer;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuCellBorderType;
import sudoku.resources.SudokuConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SudokuCellRenderer} object is used for rendering a sudoku cell for the sudoku game.
 */
public class SudokuCellRenderer implements SudokuRenderer<SudokuCell> {

	public static final SudokuCellRenderer INSTANCE = new SudokuCellRenderer();

	private static final int WIDTH_HEIGHT = SudokuConstants.DRAW_WIDTH;

	private static final int SIX_INT = 6;
	private static final float THREE_FLOAT = 3.0F;
	private static final double TWELVE_DOUBLE = 12.0;

	/**
	 * Private constructor.
	 */
	private SudokuCellRenderer() {
	}

	@Override
	public void render(final SudokuCell object, final Graphics g) {

		final Rectangle bounds = object.getBounds();
		final int x = bounds.x;
		final int y = bounds.y;

		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH_HEIGHT, WIDTH_HEIGHT);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, WIDTH_HEIGHT, WIDTH_HEIGHT);

		final SudokuCellBorderType cellBorder = object.getCellBorderType();
		drawBorder(g, x, y, cellBorder);

		final Font font = g.getFont();
		final FontRenderContext frc = new FontRenderContext(null, true, true);

		final boolean isInitial = object.isInitial();
		final boolean isValid = object.isValid();
		final int guessValue = object.getGuessValue();
		final boolean isShowHints = object.isShowHints();

		final BufferedImage image;
		if (isInitial) {
			image = createImage(font, frc, WIDTH_HEIGHT, object.getValue(), true, isValid);
		} else if (guessValue > 0) {
			image = createImage(font, frc, WIDTH_HEIGHT, guessValue, false, isValid);
		} else if (isShowHints) {
			final List<String> possibleValues = concatenatePossibleValues(object);
			image = createImage(font, frc, possibleValues);
		} else {
			image = null;
		}

		if (image != null) {
			final int xx = x + ((WIDTH_HEIGHT - image.getWidth()) / 2);
			final int yy = y + ((WIDTH_HEIGHT - image.getHeight()) / 2);
			g.drawImage(image, xx, yy, null);
		}
	}

	/**
	 * This method renders the borders for a cell.
	 *
	 * @param g          the graphic
	 * @param x          the x value
	 * @param y          the y value
	 * @param cellBorder the type of cell boarder to render
	 */
	private static void drawBorder(final Graphics g, final int x, final int y, final SudokuCellBorderType cellBorder) {
		switch (cellBorder) {
			case TOP_LEFT:
				drawLeftBorder(g, x, y);
				drawTopBorder(g, x, y);
				break;
			case TOP:
				drawTopBorder(g, x, y);
				break;
			case TOP_RIGHT:
				drawTopBorder(g, x, y);
				drawRightBorder(g, x, y);
				break;
			case LEFT:
				drawLeftBorder(g, x, y);
				break;
			case RIGHT:
				drawRightBorder(g, x, y);
				break;
			case BOTTOM_LEFT:
				drawLeftBorder(g, x, y);
				drawBottomBorder(g, x, y);
				break;
			case BOTTOM:
				drawBottomBorder(g, x, y);
				break;
			case BOTTOM_RIGHT:
				drawBottomBorder(g, x, y);
				drawRightBorder(g, x, y);
				break;
			case NONE:
				break;
			default:
				break;
		}
	}

	/**
	 * This method renders the top border for a cell.
	 *
	 * @param g the graphic
	 * @param x the x value
	 * @param y the y value
	 */
	private static void drawTopBorder(final Graphics g, final int x, final int y) {
		g.drawLine(x, y + 1, x + WIDTH_HEIGHT, y + 1);
		g.drawLine(x, y + 2, x + WIDTH_HEIGHT, y + 2);
	}

	/**
	 * This method renders the right border for a cell.
	 *
	 * @param g the graphic
	 * @param x the x value
	 * @param y the y value
	 */
	private static void drawRightBorder(final Graphics g, final int x, final int y) {
		g.drawLine((x + WIDTH_HEIGHT) - 1, y, (x + WIDTH_HEIGHT) - 1, y + WIDTH_HEIGHT);
		g.drawLine((x + WIDTH_HEIGHT) - 2, y, (x + WIDTH_HEIGHT) - 2, y + WIDTH_HEIGHT);
	}

	/**
	 * This method renders the bottom border for a cell.
	 *
	 * @param g the graphic
	 * @param x the x value
	 * @param y the y value
	 */
	private static void drawBottomBorder(final Graphics g, final int x, final int y) {
		g.drawLine(x, (y + WIDTH_HEIGHT) - 1, x + WIDTH_HEIGHT, (y + WIDTH_HEIGHT) - 1);
		g.drawLine(x, (y + WIDTH_HEIGHT) - 2, x + WIDTH_HEIGHT, (y + WIDTH_HEIGHT) - 2);
	}

	/**
	 * This method renders the left border for a cell.
	 *
	 * @param g the graphic
	 * @param x the x value
	 * @param y the y value
	 */
	private static void drawLeftBorder(final Graphics g, final int x, final int y) {
		g.drawLine(x + 1, y, x + 1, y + WIDTH_HEIGHT);
		g.drawLine(x + 2, y, x + 2, y + WIDTH_HEIGHT);
	}

	/**
	 * This method gets the list of possible values to be rendered as a list of formatted strings.
	 *
	 * @param sudokuCell the cell containing the possible values
	 * @return a list of formatted strings of possible values
	 */
	private static List<String> concatenatePossibleValues(final SudokuCell sudokuCell) {
		final List<String> list = new ArrayList<>();
		final StringBuilder builder = new StringBuilder();

		int stringIndex = 0;

		final List<Integer> possibleValues = sudokuCell.getPossibleValues();
		for (final Integer possibleValue : possibleValues) {
			builder.append(possibleValue);
			if (stringIndex < 2) {
				builder.append(' ');
				stringIndex++;
			} else {
				list.add(builder.toString());
				builder.delete(0, builder.length());
				stringIndex = 0;
			}
		}
		if (builder.length() > 0) {
			list.add(builder.toString());
		}

		return list;
	}

	/**
	 * This method creates a {@code BufferedImage} to be rendered with the provided {@code value} using the provided
	 * {@code font}, {@code frc}, {@code width}, {@code isInitial}, and {@code isValid} values.
	 *
	 * @param font      the font of the value to render
	 * @param frc       the font render context for rendering the value
	 * @param width     the width of the value to render
	 * @param value     the value to render
	 * @param isInitial whether or not the value to render is the initial value or not
	 * @param isValid   whether or not the render is valid
	 * @return the created {@code BufferedImage} to draw in the cell
	 */
	private static BufferedImage createImage(final Font font, final FontRenderContext frc, final int width,
											 final int value, final boolean isInitial, final boolean isValid) {
		final String valueString = Integer.toString(value);

		final Font largeFont = font.deriveFont((width * 2) / THREE_FLOAT);
		final Rectangle2D r = largeFont.getStringBounds(valueString, frc);

		final Long imgWidth = Math.round(r.getWidth() + TWELVE_DOUBLE);
		final Long imgHeight = Math.round(TWELVE_DOUBLE - r.getY());

		final BufferedImage image = new BufferedImage(imgWidth.intValue(), imgHeight.intValue(), BufferedImage.TYPE_INT_RGB);

		final Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());

		if (isInitial) {
			g.setColor(Color.MAGENTA);
		} else if (!isValid) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLUE);
		}

		final Long rY = Math.round(r.getY());
		final int y = -rY.intValue();

		g.setFont(largeFont);
		g.drawString(valueString, SIX_INT, y);
		g.dispose();
		return image;
	}

	/**
	 * This method creates a {@code BufferedImage} to be rendered with the provided {@code possibleValues} list using the
	 * provided {@code font} and {@code frc} values.
	 *
	 * @param font           the font of the values to render
	 * @param frc            the font render context for rendering the values
	 * @param possibleValues the possible values to render
	 * @return the created {@code BufferedImage} to draw in the cell
	 */
	private static BufferedImage createImage(final Font font, final FontRenderContext frc, final List<String> possibleValues) {
		double imageWidth = 0.0D;
		double imageHeight = 0.0D;
		double stringHeight = 0.0D;
		for (final String possibleValue : possibleValues) {
			final Rectangle2D r = font.getStringBounds(possibleValue, frc);
			imageWidth = Math.max(imageWidth, r.getWidth());
			imageHeight += r.getHeight();
			stringHeight = Math.max(stringHeight, r.getHeight());
		}

		final Long imgWidth = Math.round(imageWidth + TWELVE_DOUBLE);
		final Long imgHeight = Math.round(imageHeight + TWELVE_DOUBLE);

		final BufferedImage image = new BufferedImage(imgWidth.intValue(), imgHeight.intValue(), BufferedImage.TYPE_INT_RGB);

		final Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());

		g.setColor(Color.DARK_GRAY);

		final Long imgStringHeight = Math.round(stringHeight);
		final int imgStringHeightInt = imgStringHeight.intValue();
		int y = (SIX_INT / 2) + imgStringHeightInt;

		for (final String possibleValue : possibleValues) {
			g.drawString(possibleValue, SIX_INT, y);
			y += imgStringHeightInt;
		}
		g.dispose();
		return image;
	}

	@Override
	public String toString() {
		return "SudokuCellRenderer{}";
	}
}
