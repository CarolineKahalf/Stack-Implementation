package arraystack;

/**
 *
 * @author Kahalf
 */
import arraystack.Stack.StackFullException;
import arraystack.Stack;
import java.util.*; 

public class ArrayStack implements Stack {

    public static final int CAPACITY = 1000;
    private int top = -1;
    private int capacity;
    private Object S[];

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int cap) {
        capacity = cap;
        S = new Object[capacity];
    }

    @Override
    public Object pop() throws StackEmptyException {
        Object elem;

        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }

        elem = S[top];
        S[top--] = null;

        return elem;
    }

    @Override
    public void push(Object obj) throws StackFullException {
        if (size() == capacity) {
            throw new StackFullException("Stack Overflow");
        }

        S[++top] = obj;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public Object top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is Empty");
        }

        return S[top];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }
   
}
