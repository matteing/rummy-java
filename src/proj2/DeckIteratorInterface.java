package proj2;

public interface DeckIteratorInterface {
    /**
     * Returns whether the iterator has more cards.
     * @return Boolean indicating the existence of more cards.
     */
    public boolean hasNext();

    /**
     * Returns the next card in the deck.
     * @return The next card.
     */
    public Card next();
}
