package arraystack;
import arraystack.Stack;
/**
 *
 * @author Kahalf
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawRectangle extends JPanel implements Cloneable {

    private final Color color;

    DrawRectangle(Color Cl) {
        this.color = Cl;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(0, 0, 500, 50);
    }
    
    @Override
    public DrawRectangle clone() throws CloneNotSupportedException {
        final DrawRectangle copy;

        copy = (DrawRectangle) super.clone();

        return copy;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(340, 20);
    }
}
