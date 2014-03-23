package sudoku.renderer;

import sudoku.SudokuUtils;
import sudoku.model.SudokuCell;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SudokuCellRenderer} object is used for rendering a sudoku cell for the sudoku game.
 */
public class SudokuCellRenderer implements SudokuRenderer<SudokuCell> {

	public static final SudokuCellRenderer INSTANCE = new SudokuCellRenderer();

	/**
	 * Private constructor.
	 */
	private SudokuCellRenderer() {
	}

	@Override
	public void draw(final SudokuCell object, final Graphics g) {

		final int widthHeight = SudokuUtils.DRAW_WIDTH;
		final int cellPosition = object.getCellPosition();
		final Rectangle bounds = object.getBounds();
		final int x = bounds.x;
		final int y = bounds.y;

		g.setColor(Color.WHITE);
		g.fillRect(x, y, widthHeight, widthHeight);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, widthHeight, widthHeight);

		drawBorder(g, x, y, widthHeight, cellPosition);

		final Font font = g.getFont();
		final FontRenderContext frc = new FontRenderContext(null, true, true);

		final boolean isInitial = object.isInitial();
		final Integer value = object.getValue();
		final Integer guessValue = object.getGuessValue();

		if (isInitial)

		{
			final String s = Integer.toString(value);

			final BufferedImage image = createImage(font, frc, widthHeight, s, object.isInitial());

			final int xx = x + ((widthHeight - image.getWidth()) / 2);
			final int yy = y + ((widthHeight - image.getHeight()) / 2);
			g.drawImage(image, xx, yy, null);
		} else if (guessValue > 0)

		{
			final String s = Integer.toString(guessValue);

			final BufferedImage image = createImage(font, frc, widthHeight, s, object.isInitial());

			final int xx = x + ((widthHeight - image.getWidth()) / 2);
			final int yy = y + ((widthHeight - image.getHeight()) / 2);
			g.drawImage(image, xx, yy, null);
		} else

		{
			final List<String> list = concatenatePossibleValues(object);

			double imageWidth = 0.0D;
			double imageHeight = 0.0D;
			double stringHeight = 0.0D;
			for (final String s : list) {
				final Rectangle2D r = font.getStringBounds(s, frc);
				imageWidth = Math.max(imageWidth, r.getWidth());
				imageHeight += r.getHeight();
				stringHeight = Math.max(stringHeight, r.getHeight());
			}

			final BufferedImage image = createImage(list, imageWidth, imageHeight, stringHeight);

			final int xx = x + ((widthHeight - image.getWidth()) / 2);
			final int yy = y + ((widthHeight - image.getHeight()) / 2);
			g.drawImage(image, xx, yy, null);
		}

	}

	private static void drawBorder(final Graphics g, final int x, final int y, final int width,
								   final int cellPosition) {
		switch (cellPosition) {
			case 1:
				drawLeftBorder(g, x, y, width);
				drawTopBorder(g, x, y, width);
				break;
			case 2:
				drawTopBorder(g, x, y, width);
				break;
			case 3:
				drawTopBorder(g, x, y, width);
				drawRightBorder(g, x, y, width);
				break;
			case 4:
				drawLeftBorder(g, x, y, width);
				break;
			case 6:
				drawRightBorder(g, x, y, width);
				break;
			case 7:
				drawLeftBorder(g, x, y, width);
				drawBottomBorder(g, x, y, width);
				break;
			case 8:
				drawBottomBorder(g, x, y, width);
				break;
			case 9:
				drawBottomBorder(g, x, y, width);
				drawRightBorder(g, x, y, width);
				break;
			default:
				break;
		}
	}

	private static void drawTopBorder(final Graphics g, final int x, final int y, final int width) {
		g.drawLine(x, y + 1, x + width, y + 1);
		g.drawLine(x, y + 2, x + width, y + 2);
	}

	private static void drawRightBorder(final Graphics g, final int x, final int y, final int width) {
		g.drawLine((x + width) - 1, y, (x + width) - 1, y + width);
		g.drawLine((x + width) - 2, y, (x + width) - 2, y + width);
	}

	private static void drawBottomBorder(final Graphics g, final int x, final int y, final int width) {
		g.drawLine(x, (y + width) - 1, x + width, (y + width) - 1);
		g.drawLine(x, (y + width) - 2, x + width, (y + width) - 2);
	}

	private static void drawLeftBorder(final Graphics g, final int x, final int y, final int width) {
		g.drawLine(x + 1, y, x + 1, y + width);
		g.drawLine(x + 2, y, x + 2, y + width);
	}

	private static BufferedImage createImage(final Font font, final FontRenderContext frc,
											 final int width, final String s, final boolean isInitial) {
		final int margin = 6;
		final double extra = (double) margin + margin;

		final Font largeFont = font.deriveFont((float) ((width * 2) / 3));
		final Rectangle2D r = largeFont.getStringBounds(s, frc);

		final BigDecimal imgWidth = BigDecimal.valueOf(Math.round(r.getWidth() + extra));
		final BigDecimal imgHeight = BigDecimal.valueOf(Math.round(extra - r.getY()));

		final BufferedImage image = new BufferedImage(imgWidth.intValue(), imgHeight.intValue(), BufferedImage.TYPE_INT_RGB);

		final Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

		if (isInitial) {
			graphics.setColor(Color.MAGENTA);
		} else {
			graphics.setColor(Color.BLUE);
		}

		final BigDecimal rY = BigDecimal.valueOf(Math.round(r.getY()));

		final int x = margin;
		final int y = -rY.intValue();

		graphics.setFont(largeFont);
		graphics.drawString(s, x, y);
		graphics.dispose();
		return image;
	}

	private static List<String> concatenatePossibleValues(final SudokuCell sudokuCell) {
		final List<String> list = new ArrayList<>();
		final StringBuilder builder = new StringBuilder();

		int stringIndex = 0;

		final List<Integer> possibleValues = sudokuCell.getPossibleValues();
		for (int index = 0; index < sudokuCell.getPossibleValuesCount(); index++) {
			builder.append(possibleValues.get(index));
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

	private static BufferedImage createImage(final List<String> list, final double imageWidth,
											 final double imageHeight, final double stringHeight) {
		final int margin = 6;
		final double extra = (double) margin + margin;

		final BigDecimal imgWidth = BigDecimal.valueOf(Math.round(imageWidth + extra));
		final BigDecimal imgHeight = BigDecimal.valueOf(Math.round(imageHeight + extra));

		final BufferedImage image = new BufferedImage(imgWidth.intValue(), imgHeight.intValue(), BufferedImage.TYPE_INT_RGB);

		final Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

		graphics.setColor(Color.DARK_GRAY);

		final BigDecimal imgStringHeight = BigDecimal.valueOf(Math.round(stringHeight));

		final int x = margin;
		int y = (margin / 2) + imgStringHeight.intValue();

		for (final String s : list) {
			graphics.drawString(s, x, y);
			y += imgStringHeight.intValue();
		}
		graphics.dispose();
		return image;
	}
}
