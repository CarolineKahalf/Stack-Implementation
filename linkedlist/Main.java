/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import javax.swing.SwingUtilities;

/**
 *
 * @author Santanass
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DoubleStackGui()::createAndShowGui);
    }
    
}
