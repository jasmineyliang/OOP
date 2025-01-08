package lab7;
import java.util.Random;

import lab7.Card.Suit;
public class Deck {
	/**
	   * The cards comprising this deck.
	   */
	  private Card[] cards;
	  
	  /**
	   * The random number generator to use for selecting cards.
	   */
	  private Random rand;
	  
	  /**
	   * Constructs a new deck with a default random number generator.
	   */
	  public Deck()
	  {
	    rand = new Random();
	    init();
	  }

	  /**
	   * Constructs a new deck with the given random number generator.
	   */
	  public Deck(Random givenGenerator)
	  {
	    rand = givenGenerator;
		init();
	  }
	  
	  /**
	   * Returns a new array containing k elements selected
	   * at random from this deck.
	   */
	  public Card[] select(int k)
	  {
		  Card[] hand = new Card[5];
		    for (int i = 0; i < 5; i += 1)
		    {
		    //int	cards []=null;
		      int index = rand.nextInt(52);
		      hand[i] = cards[index];
		      
		      Card temp = cards[51];
		      cards[51] = cards[index];
		      cards[index] = temp;
		      
		      
		      index = rand.nextInt(51);
		      hand[i] = cards[index];
		      int temp2 [] = cards[index];
		      cards[index] = cards[50];
		      cards[50] = temp2 [];
		      
		    }
	  }
	  
	  /**
	   * Initializes a new deck of 52 cards.
	   */
	  private void init()
	  {
	    cards = new Card[52];
	    int index = 0;
	    for (int rank = 1; rank <= 13; ++rank)
	    {
	      cards[index] = new Card(rank, Suit.CLUBS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.DIAMONDS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.HEARTS);
	      index += 1;
	      cards[index] = new Card(rank, Suit.SPADES);
	      index += 1;
	    }

	  }

}
