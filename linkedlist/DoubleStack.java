/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Santanass
 */
public interface DoubleStack {
    public int size();

    public boolean isEmpty();

    public Object first() throws StackEmptyException;

    public Object last() throws StackEmptyException;

    public void addFirst(Object element);

    public void addLast(Object element);

    public Object removeFirst() throws StackEmptyException;

    public Object removeLast() throws StackEmptyException;

    public void addAt(int index, Object element);

    public static class StackEmptyException extends Exception{
        public StackEmptyException(String args){
            super(args);
        }
    }

    public static class OutOfBoundException extends Exception{
        public OutOfBoundException(String args){
            super(args);
        }
    }

}

    

