package proj2;

public class DeckIterator implements DeckIteratorInterface {
    private Deck deck;
    private int idx = 0;

    public DeckIterator(Deck d) {
        deck = d;
    }

    public boolean hasNext() {
        return idx < deck.getSizeOfDeck();
    }

    public Card next() {
        if (hasNext()) return deck.getCard(idx++);
        return null;
    }
}
