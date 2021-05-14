package proj2;

import java.util.ArrayList;

public class Engine implements EngineInterface {
    int initialDealCount = 9;
    private ArrayList<Operation> queue;
    private ArrayList<Card> table;
    private Deck deck;
    private Pile stack;

    /**
     * Initialize the game and deck.
     */
    public Engine() {
        queue = new ArrayList<Operation>();
        table = new ArrayList<Card>();
        deck = new Deck();
        stack = new Pile();

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

    /**
     * Take an operation and render it immediately.
     * @param op - An Operation-derived class
     */
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

    /**
     * Initialize the hand with the initial deal.
     * @param hand
     */
    public void initializeHand(Hand hand) {
        for (int i = 0; i < initialDealCount; i++) {
            hand.addCard(deck.dealCard());
        }
    }

    /**
     * Initializes the stack with a single card from the deck.
     */
    public void initializeStack() {
        stack.push(deck.dealCard());
    }

    public ArrayList getTable() {
        return table;
    }

    public Deck getDeck() {
        return deck;
    }

    public Pile getStack() {
        return stack;
    }
}
