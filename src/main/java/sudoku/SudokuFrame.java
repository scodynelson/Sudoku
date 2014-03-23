package sudoku;

import sudoku.model.SudokuPuzzle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

/**
 * The {@code SudokuFrame} object creates a sudoku board frame for the sudoku game user interface.
 */
public class SudokuFrame implements Serializable {

	private static final long serialVersionUID = 5661505075061593233L;

	private final SudokuPuzzle puzzle;

	private JFrame frame;
	private SudokuPanel panel;

	/**
	 * Public constructor.
	 *
	 * @param puzzle the puzzle to use
	 */
	public SudokuFrame(final SudokuPuzzle puzzle) {
		this.puzzle = puzzle;
		init();
	}

	/**
	 * Initialization method.
	 */
	private void init() {
		panel = new SudokuPanel(this, puzzle);

		frame = new JFrame();
		frame.setTitle(SudokuResources.get("sudoku.frame.title"));
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});

		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(panel);

		final ButtonPanel buttonPanel = new ButtonPanel(this, puzzle);

		final JPanel holderPanel = new JPanel(new FlowLayout());
		holderPanel.add(buttonPanel.getPanel());
		mainPanel.add(holderPanel);

		frame.setLayout(new FlowLayout());
		frame.add(mainPanel);
		frame.pack();
		frame.setBounds(getBounds());
		frame.setVisible(true);
	}

	/**
	 * This private method is used to get the rectangular bounds for initializing the frame.
	 *
	 * @return the rectangular bounds for the frame
	 */
	private Rectangle getBounds() {
		final Rectangle bounds = frame.getBounds();
		final Rectangle windowBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		bounds.x = (windowBounds.width - bounds.width) / 2;
		bounds.y = (windowBounds.height - bounds.height) / 2;
		return bounds;
	}

	/**
	 * Getter for the frame value.
	 *
	 * @return the frame value
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * This method is used to repaint the board with any updated values.
	 */
	public void repaintPanel() {
		panel.repaint();
	}

	@Override
	public String toString() {
		return "SudokuFrame{"
				+ "puzzle=" + puzzle
				+ ", frame=" + frame
				+ ", panel=" + panel
				+ '}';
	}
}
