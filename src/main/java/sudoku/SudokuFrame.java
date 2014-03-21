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

public class SudokuFrame implements Serializable {

	private static final long serialVersionUID = 5661505075061593233L;

	private final SudokuPuzzle model;

	private JFrame frame;
	private SudokuPanel sudokuPanel;

	public SudokuFrame(final SudokuPuzzle model) {
		this.model = model;
		init();
	}

	private void init() {
		sudokuPanel = new SudokuPanel(this, model);

		frame = new JFrame();
		frame.setTitle(SudokuResources.get("sudoku.frame.title"));
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(final WindowEvent e) {
				exitProcedure();
			}
		});

		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(sudokuPanel);

		final ButtonPanel buttonPanel = new ButtonPanel(this, model);

		final JPanel holderPanel = new JPanel(new FlowLayout());
		holderPanel.add(buttonPanel.getPanel());
		mainPanel.add(holderPanel);

		frame.setLayout(new FlowLayout());
		frame.add(mainPanel);
		frame.pack();
		frame.setBounds(getBounds());
		frame.setVisible(true);
	}

	private void exitProcedure() {
		frame.dispose();
		System.exit(0);
	}

	public Rectangle getBounds() {
		final Rectangle f = frame.getBounds();
		final Rectangle w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		f.x = (w.width - f.width) / 2;
		f.y = (w.height - f.height) / 2;
		return f;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void repaintSudokuPanel() {
		sudokuPanel.repaint();
	}
}
