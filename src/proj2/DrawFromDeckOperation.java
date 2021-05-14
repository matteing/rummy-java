package proj2;

public class DrawFromDeckOperation implements Operation {
    private Hand hand;

    public DrawFromDeckOperation(Hand h) {
        hand = h;
    }

    public void execute(Engine engine) {
        hand.addCard(engine.getDeck().dealCard());
    }
}
