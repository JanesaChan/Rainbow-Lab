// This code is designed to make a magical rainbow.
// By Janesa Chan

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  // This declares the color of the "sky" as blue with simple RGB values put in
private Color skyColor=new Color(88, 172, 250);	

  public Rainbow()
  {
	// Sets background to sky color
    setBackground(skyColor);
  }

  //The paintComponent method declares integer variables like width, height, and the coordinates of the center
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    
    int xCenter = (int)((double)width/2);
    int yCenter = (int)((double)height*3/4);
    
    // The first arc is made below
    int largeRadius = width/4; //Radius of first arc is set as a fourth of the width declared
    g.setColor(new Color(250,88,88)); //The color for the first arc is set as red
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, 2*largeRadius,2*largeRadius,0, 180); // The coordinates, height and width of first arc is declared
   
    int smallRadius = height/4; //Radius of smaller arc is set as a fourth of the height declared
    
    int mediumRadius = (int) Math.sqrt(smallRadius*largeRadius); //Radius of middle arc is set as the geometric mean of the radius of the large and small arc
    g.setColor(new Color(130,250,88)); //The color for the middle arc is set as green
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, 2*mediumRadius, 2*mediumRadius, 0, 180); //The coordinates, height and width of middle arc is declared
    
    g.setColor(new Color (231,93,201)); //The color for the small arc is set as pink
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, 2*smallRadius, 2*smallRadius, 0, 180); //The coordinates, height and width of the small arc is declared

    // An inner semi-circle is created to finish rainbow
    int innerCircle = - 3 * mediumRadius + 3 * smallRadius + largeRadius; // The radius of the inner semi-circle is set in a way that the width of the middle arc is the arithmetic mean of the widths of the large and small arc
    g.setColor(new Color(88, 172, 250)); //The color of the inner semi-circle is set as the same color as the background
    g.fillArc(xCenter-innerCircle, yCenter-innerCircle, 2*innerCircle, 2*innerCircle, 0, 180); //The coordinates, height and width of the inner semi-circle is declared
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Magical Rainbow of Happiness"); //The title of the window is stated
    w.setBounds(300, 300, 300, 200); //Boundaries of window is set
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
