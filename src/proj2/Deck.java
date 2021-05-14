package proj2;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

   LinkedList deck;
   private int index;


  /**
   * Creates an empty deck of cards.
   */
   public Deck() {
      deck = new LinkedList();

   }
	public Card peek()
	{
		if(deck.size() == 0)
			return null;
		else
			return (Card)deck.getLast();
	}

   public void addCard( Card card ) {
      deck.add( card );
   }

    public Card getCard(int idx) {
        return (Card) deck.get(idx);
}

   public int getSizeOfDeck() {
      return deck.size();
   }

   public Card dealCard() {
   
	 if ( deck.size() == 0 )
         return null;
      else
       
		return (Card) deck.removeFirst();
   }
   public Card removeCard() {
 
	if (deck.size() == 0)
         return null;
      else{
		
         return (Card) deck.removeLast( );
	}
   }


  /**
   * Shuffles the cards present in the deck.
   */
   public void shuffle() {
      Collections.shuffle( deck );
   }


  /**
   * Looks for an empty deck.
   * @return <code>true</code> if there are no cards left to be dealt from the deck.
   */
   public boolean isEmpty() {
		return deck.size() == 0;
   }



  /**
   * Restores the deck to "full deck" status.
   */
  public void restoreDeck() {
	//not sure if kosher
      deck.removeAll(deck);
   }

    public String toString() {
        return deck.toString();
    }
}
