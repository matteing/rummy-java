package proj2;

public class DiscardOperation implements Operation {
    private Hand hand;
    private int idx;

    public DiscardOperation(Hand h, int i) {
        hand = h;
        idx = i;
    }

    public void execute(Engine engine) {
        Card card = hand.getCard(idx);
        hand.removeCard(card);
        engine.getStack().push(card);
    }
}
