import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        String str = "Hello, Java Graphics World!";

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position

        String text = "Java Graphics World";
        Font font = new Font("Wide Latin", Font.BOLD, 27);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
    
        int x = (getWidth() - metrics.stringWidth(text)) / 2 + metrics.getAscent(); 
        int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent(); // Centered vertically

        g.drawString(text, x, y);
        
    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);

        //setting the colors 
       

        panel.setForeground(Color.blue);

        panel.setBackground(new Color(255,0,0));


        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
