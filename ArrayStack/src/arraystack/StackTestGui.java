package arraystack;


/**
 *
 * @author Kahalf
 */
import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//import javax.swing.SwingUtilities.invokeLater;
import javax.swing.border.LineBorder;
//import org.apache.commons.lang3.StringUtils;




public class StackTestGui implements ActionListener {

    private final JPanel panel = new JPanel();
    private final JPanel btnPanel = new JPanel();
    private final JButton btnPop = new JButton("Pop");
    private final JButton btnPush = new JButton("Push");
    private final JButton btnTop = new JButton("Top");
    private final JButton btnEmpty = new JButton("Empty");
    private final JButton btnSize = new JButton("Size");
    private final JLabel capLabel = new JLabel();
    protected Random rand = new Random();
    private JFrame frame;
    private final ArrayStack arr;
    private String strArrSize;
    private int arrSize;
    String[] possibilities = {"Circle","Square"};

    StackTestGui() {
        while (true) {
            try {
                this.strArrSize = JOptionPane.showInputDialog(null, "Enter maximum stack capacity", "Maximum capacity");
                this.arrSize = Integer.parseInt(strArrSize);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a number not letter\nYou entered " + this.strArrSize,
                        "Error",
                        2);
            }
        }

        this.capLabel.setText("Maximum capacity: " + this.arrSize);
        this.arr = new ArrayStack(arrSize);
    }

    protected void createAndShowGUI() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(btnPanel);

        btnPanel.add(btnPop);
        btnPanel.add(btnPush);
        btnPanel.add(btnTop);
        btnPanel.add(btnEmpty);
        btnPanel.add(btnSize);
        btnPanel.add(capLabel);

        btnPush.addActionListener(this);
        btnPop.addActionListener(this);
        btnTop.addActionListener(this);
        btnEmpty.addActionListener(this);
        btnSize.addActionListener(this);

        frame = new JFrame();
        frame.setTitle("Adding Stacks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.pack();
    }

    private void getSize() {
        JOptionPane.showMessageDialog(null, "Stack size: " + arr.size(), "Size", 1);
    }

    private void checkEmpty() {
        JOptionPane.showMessageDialog(null, StringUtils.capitalize(String.valueOf(arr.isEmpty())), "Empty", 1);
    }

    private void getTop() throws Stack.StackEmptyException, CloneNotSupportedException {
        JOptionPane.showMessageDialog(null, ((DrawRectangle) arr.top()).clone(), "Top", 1);
  
    }

    private void addStack() throws Stack.StackFullException {
        float rd = rand.nextFloat();
        float gr = rand.nextFloat();
        float bl = rand.nextFloat();
        final DrawRectangle r = new DrawRectangle(new Color(rd, gr, bl));
        r.setBorder(new LineBorder(Color.black));
        arr.push(r);
        panel.add(r, 0);
    }

    private void removeStack() throws Stack.StackEmptyException {
        DrawRectangle top = ((DrawRectangle) arr.top());
        panel.remove(top);
        arr.pop();
        JOptionPane.showMessageDialog(null, top, "Element popped", 1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("Push".equals(ae.getActionCommand())) {
            try {
                addStack();
            } catch (Stack.StackFullException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("Pop".equals(ae.getActionCommand())) {
            try {
                removeStack();
            } catch (Stack.StackEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("Top".equals(ae.getActionCommand())) {
            try {
                getTop();
            } catch (Stack.StackEmptyException | CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("Empty".equals(ae.getActionCommand())) {
            checkEmpty();
        }

        if ("Size".equals(ae.getActionCommand())) {
            getSize();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
 public static void main(String[] args) {
        new StackTestGui();
        SwingUtilities.invokeLater(new StackTestGui()::createAndShowGUI);
        
          
    }


}
