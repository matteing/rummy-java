package proj2;

public interface MyStackInterface<T> {
    /**
     * Push objects into MyStack.
     * PreCondition: Called when programmer implements a Deck or Pile class.
     * PostCondition: N/A
     * @param item - Item to push to start of stack.
     */
    public void push(T item);

    /**
     * Delete the object on top and return it.
     * PreCondition: Called when programmer implements a Deck or Pile class.
     * PostCondition: N/A
     * @return Item on top of stack.
     */
    public T pop();

    /**
     * Returns the item on top of the stack.
     * PreCondition: Called when programmer implements a Deck or Pile class.
     * PostCondition: N/A
     * @return Item on top of stack.
     */
    public T top();

    /**
     * Returns whether the stack is empty or not.
     * PreCondition: Called when programmer implements a Deck or Pile class.
     * PostCondition: N/A
     * @return Boolean indicating emptiness
     */
    public boolean isEmpty();
}
