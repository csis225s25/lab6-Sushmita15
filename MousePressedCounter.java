import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
        JPanel centered = new JPanel();

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel() {
			//@Override
		/*	public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}*/
		};

        
        panel.add(count);
        panel.add(reset);
		frame.add(panel);
        panel.add(centered);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		reset.addActionListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	//@Override
	//public void mouseClicked(MouseEvent e) {
	//	System.out.println("mouseClicked: " + e);
	//}

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
