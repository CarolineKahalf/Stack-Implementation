package arraystack;
import arraystack.Stack;
/**
 *
 * @author kahalf
 */
public interface Stack {

    public Object pop() throws StackEmptyException;

    public void push(Object element) throws StackFullException;

    public int size();

    public Object top() throws StackEmptyException;

    public boolean isEmpty();

    public static class StackEmptyException extends Exception {

        public StackEmptyException(String args) {
            super(args);
        }
    }

    public static class StackFullException extends Exception {

        public StackFullException(String args) {
            super(args);
        }
    }
}
