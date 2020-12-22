package arraystack;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
 /**   A component that shows a colored square.*/
public class Square extends JComponent
{  
    /** Constructs a component that shows a colored square.
    @param aColor the fill color for the square  */
public Square(Color aColor)
{  
 fillColor = aColor;
 }   
 public void paintComponent(Graphics g)
{  
 Graphics2D g2 = (Graphics2D) g;
  // Select color into graphics context
  g2.setColor(fillColor);   
  // Construct and fill a square whose center is
  // the center of the window
  final int SQUARE_LENGTH = 100;
 Rectangle square = new Rectangle(
(getWidth() - SQUARE_LENGTH) / 2,
(getHeight() - SQUARE_LENGTH) / 2,
               SQUARE_LENGTH,
         SQUARE_LENGTH);
          
       g2.fill(square);
    }
        private Color fillColor;
}