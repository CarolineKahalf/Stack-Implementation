/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Santanass
 
 * 
 **/
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class DoubleStackGui implements ActionListener {

    private final JPanel panel = new JPanel();
    private final JPanel btnPanel = new JPanel();
    private final  JButton btnRemoveFirst = new JButton("REMOVE FIRST");
    private final  JButton btnRemoveLast = new JButton("REMOVE LAST");
    private final JButton btnAddFirst = new JButton("ADD FIRST");
    private final JButton btnAddLast = new JButton("ADD LAST");
    private final JButton btnFirst = new JButton("FIRST");
    private final JButton btnLast = new JButton("LAST");
    private final JButton btnEmpty = new JButton("EMPTY");
    private final JButton btnSize = new JButton("SIZE");
    private final JButton btnAddAt = new JButton("ADDAT");
    private String StringPositionToAdd;
    private int position;
    protected Random random = new Random();
    private JFrame frame;
    private final LinkedListDoubleStack linkedListStack;

    public DoubleStackGui() {
        linkedListStack = new LinkedListDoubleStack();
    }

    protected void createAndShowGui(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(btnPanel);

        btnPanel.add(btnRemoveFirst);
        btnPanel.add(btnRemoveLast);
        btnPanel.add(btnAddFirst);
        btnPanel.add(btnAddLast);
        btnPanel.add(btnFirst);
        btnPanel.add(btnLast);
        btnPanel.add(btnEmpty);
        btnPanel.add(btnSize);
        btnPanel.add(btnAddAt);

        btnRemoveFirst.addActionListener(this);
        btnRemoveLast.addActionListener(this);
        btnAddFirst.addActionListener(this);
        btnAddLast.addActionListener(this);
        btnFirst.addActionListener(this);
        btnLast.addActionListener(this);
        btnEmpty.addActionListener(this);
        btnSize.addActionListener(this);
        btnAddAt.addActionListener(this);

        frame = new JFrame();
        frame.setTitle("LINKED LIST IMPLEMENTATION | *DISPENSER*");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.PAGE_END);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.pack();
    }

    private void getSize(){
        JOptionPane.showMessageDialog(null,
                "SIZE: " + linkedListStack.size() ,
                "SIZE", 1 );
    }

    private void checkEmpty(){
//        JOptionPane.showMessageDialog(null, StringUtils.capitalize(String.valueOf(stackArray.isEmpty())),
//                "Empty", 1);
        JOptionPane.showMessageDialog(null, "FALSE");
    }

    private void getFirst() throws DoubleStack.StackEmptyException, CloneNotSupportedException {
        JOptionPane.showMessageDialog(null,
                ((DrawRectangle)linkedListStack.first()).clone(), "FIRST",1);
    }

    private void addAt(){
        while (true){
            try{
                this.StringPositionToAdd = JOptionPane.showInputDialog(null,
                        "ENTER THE INSERT POSITION: ");
                this.position = Integer.parseInt(StringPositionToAdd);
                break;
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,
                        "Please enter a number and not a letter you entered"+ this.StringPositionToAdd,
                        "Error", 2);
            }
        }

        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        final DrawRectangle drawRect = new DrawRectangle(new Color(red, green, blue));
        drawRect.setBorder(new LineBorder(Color.BLACK));
        linkedListStack.addAt(position, drawRect);
        panel.add(drawRect, 0);

    }

    private void getLast() throws DoubleStack.StackEmptyException, CloneNotSupportedException {
        JOptionPane.showMessageDialog(null,
                ((DrawRectangle)linkedListStack.last()).clone(), "LAST",1);
    }

    private void addFirst(){
        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        final DrawRectangle drawRect = new DrawRectangle(new Color(red, green, blue));
        drawRect.setBorder(new LineBorder(Color.BLACK));
        linkedListStack.addFirst(drawRect);
        panel.add(drawRect, 0);
    }

    private void addLast(){
        float red = random.nextFloat();
        float green = random.nextFloat();
        float blue = random.nextFloat();
        final DrawRectangle drawRect = new DrawRectangle(new Color(red, green, blue));
        drawRect.setBorder(new LineBorder(Color.BLACK));
        linkedListStack.addLast(drawRect);
        panel.add(drawRect, linkedListStack.size());
    }

    public void removeFirst() throws DoubleStack.StackEmptyException{
        DrawRectangle top = ((DrawRectangle) linkedListStack.first());
        panel.remove(top);
        linkedListStack.removeFirst();
        JOptionPane.showMessageDialog(null,
                top, "ELEMENT POPPED", 1);
    }

    public void removeLast() throws DoubleStack.StackEmptyException{
        DrawRectangle top = ((DrawRectangle) linkedListStack.last());
        panel.remove(top);
        linkedListStack.removeLast();
        JOptionPane.showMessageDialog(null,
                top, "ELEMENT POPPED", 1);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if ("ADD FIRST".equals(actionEvent.getActionCommand())){
            addFirst();
        }

        if ("ADD LAST".equals(actionEvent.getActionCommand())){
            addLast();
        }

        if ("FIRST".equals(actionEvent.getActionCommand())){
            try{
                getFirst();
            }catch (DoubleStack.StackEmptyException | CloneNotSupportedException ex){
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "ERROR", 0);
            }
        }

        if ("LAST".equals(actionEvent.getActionCommand())){
            try{
                getLast();
            }catch (DoubleStack.StackEmptyException | CloneNotSupportedException ex){
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "ERROR", 0);
            }
        }

        if ("REMOVE FIRST".equals(actionEvent.getActionCommand())) {
            try {
                removeFirst();
            } catch (DoubleStack.StackEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("REMOVE LAST".equals(actionEvent.getActionCommand())) {
            try {
                removeLast();
            } catch (DoubleStack.StackEmptyException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }

        if ("EMPTY".equals(actionEvent.getActionCommand())){
            checkEmpty();
        }

        if ("SIZE".equals(actionEvent.getActionCommand())){
            getSize();
        }

        if("ADDAT".equals(actionEvent.getActionCommand())){
            addAt();
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
