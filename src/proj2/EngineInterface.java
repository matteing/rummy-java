package proj2;

public interface EngineInterface {
    /**
     * This method takes an Operation derived object and adds it to the Engine queue.
     * @param op - An Operation-derived class
     */
    public void take(Operation op);


    /**
     * This method takes an Operation derived object, adds it to the Engine queue, and renders it immediately.
     * @param op - An Operation-derived class
     */
    public void takeAndRender(Operation op);

    /**
     * Executes all operations in the Engine queue.
     */
    public void render();
}
