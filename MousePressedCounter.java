import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */
public class MousePressedCounter extends MouseAdapter implements Runnable, ActionListener {

	private String toDisplay;
    private int counter = 0;
    private JLabel count = new JLabel("Mouse Press Counts: " + counter);
    private JButton reset = new JButton("Reset");
    

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {
		

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Mouse Pressed");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a main panel for all our content
        JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

        // add counter to the center
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(count);
        content.add(panel, BorderLayout.CENTER);

		// move reset button to the bottom center
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(reset);
		content.add(bottomPanel, BorderLayout.SOUTH);
 
        // add to frame
		frame.add(content);

        // add listeners
		content.addMouseListener(this);
		content.addMouseMotionListener(this);
		reset.addActionListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		counter++;
        count.setText("Mouse Press Count: " + counter);
        
	}

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("Reset")){
           counter = 0;
           count.setText("Mouse Press Count: " + counter);
        }
    }

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressedCounter());
	}
}
