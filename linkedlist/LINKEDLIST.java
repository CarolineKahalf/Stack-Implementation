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
import java.util.LinkedList;
public class LINKEDLIST {
    public class LinkedListDoubleStack implements DoubleStack {
    private LinkedList<Object> list = new LinkedList<>();
    public LinkedListDoubleStack(){

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object first() throws StackEmptyException {
        if(isEmpty())
            throw new StackEmptyException("STACK IS EMPTY!");

        return list.getFirst();
    }

    @Override
    public Object last() throws StackEmptyException {
        if(isEmpty())
            throw new StackEmptyException("STACK IS EMPTY!");

        return list.getLast();
    }

    @Override
    public void addFirst(Object element) {
        list.addFirst(element);
    }

    @Override
    public void addLast(Object element) {
        list.addLast(element);
    }

    @Override
    public Object removeFirst() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException("STACK EMPTY!");

        return  list.removeFirst();
    }

    @Override
    public Object removeLast() throws StackEmptyException {
        if (isEmpty())
            throw new StackEmptyException("STACK EMPTY!");

        return  list.removeLast();
    }

    @Override
    public void addAt(int index, Object element) {
        list.add(index, element);
    }
}

    

   
    
}
