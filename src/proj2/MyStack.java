package proj2;

import java.util.ArrayList;

public class MyStack<T> implements MyStackInterface {
    protected ArrayList<Object> stack;

    public MyStack(int size) {
        stack = new ArrayList<Object>();
    }

    public void push(Object item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new Error("Underflow error. Stack is empty.");
        }

        T val = (T) stack.get(getTop());
        stack.remove(getTop());
        return val;
    }

    public T top() {
        return (T) stack.get(getTop());
    }

    protected int getTop() {
        return stack.size() - 1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}