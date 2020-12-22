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
public class Circle extends JPanel implements Cloneable {

    private final Color color;

    Circle(Color Cl) {
        this.color = Cl;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
         g.fillOval(100, 100, 200, 200);
    }
    
    @Override
    public Circle clone() throws CloneNotSupportedException {
        final Circle copy;

        copy = (Circle) super.clone();

        return copy;
    }
/*
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(340, 20);

    }*/
}
