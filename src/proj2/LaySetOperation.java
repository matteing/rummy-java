package proj2;

import java.util.ArrayList;

public class LaySetOperation implements Operation {
    private Hand hand;
    private int idx;

    public LaySetOperation(Hand h, int i) {
        hand = h;
        idx = i;
    }

    public void execute(Engine engine) {
        ArrayList<Card> sets = (ArrayList<Card>) hand.findSets().get(idx);
        for (Card card : sets) {
            hand.removeCard(card);
            engine.getTable().add(card);
        }
    }
}
