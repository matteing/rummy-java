package proj2;

import java.util.ArrayList;

public class Engine implements EngineInterface {
    int initialDealCount = 9;
    private ArrayList<Operation> queue;
    private ArrayList<Card> table;
    private Deck deck;
    private Deck stack;

    public Engine() {
        queue = new ArrayList<Operation>();
        table = new ArrayList<Card>();
        deck = new Deck();
        stack = new Deck();

        // Distribute initial cards to deck
        for(int i = 0; i < Card.suit.length; i++){
            for(int j = 0; j < Card.rank.length; j++){
                Card card = new Card(Card.suit[i],Card.rank[j]);
                deck.addCard(card);
            }
        }

        deck.shuffle();
    }

    public void take(Operation op) {
        queue.add(op);
    }

    public void takeAndRender(Operation op) {
        queue.add(op);
        render();
    }

    public void render() {
        for (Operation op : queue) {
            op.execute(this);
        }
        queue.clear();
    }

    public void initializeHand(Hand hand) {
        for (int i = 0; i < initialDealCount; i++) {
            hand.addCard(deck.dealCard());
        }
    }

    public void initializeStack() {
        stack.addCard(deck.dealCard());
    }

    public ArrayList getTable() {
        return table;
    }

    public Deck getDeck() {
        return deck;
    }

    public Deck getStack() {
        return stack;
    }
}
