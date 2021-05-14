package proj2;

public class DrawFromStackOperation implements Operation {
    private Hand hand;

    public DrawFromStackOperation(Hand h) {
        hand = h;
    }

    public void execute(Engine engine) {
        hand.addCard(engine.getStack().pop());
    }
}
