package pa1;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
		int seed = Integer.parseInt(args[0]);
		
		Deck deck = new Deck();    // Create the deck.
		deck.shuffle(seed);        // Shuffle the deck.
		
		/* Your code */
		House house = new House();
		Player player = new Player();
		int num_com = Integer.parseInt(args[1]) - 1;
		Computer[] computer = new Computer[num_com];
		for(int i = 0; i < num_com; ++i) {
			computer[i] = new Computer(i + 2);
		}
		
		for(int i = 0; i < 2; ++i) {
			player.add(deck.dealCard());
			for(int j = 0; j < num_com; ++j) {
				computer[j].add(deck.dealCard());
			}
			house.add(deck.dealCard());
		}
		
		house.printH();
		player.print();
		for(int i = 0; i < num_com; ++i) {
			computer[i].print();
		}
		System.out.println("");
		
		if(!(house.sum() == 21)) {
			String ans;
			Scanner scn = new Scanner(System.in);
		
			System.out.println("--- Player1 turn ---");
			player.print();
			while(player.sum() <= 21) {
				ans = scn.nextLine();
				if(ans.compareTo("Hit") == 0) {
					player.add(deck.dealCard());
					player.print();
				}
				else if(ans.compareTo("Stand") == 0) {
					player.print();
					break;
				}
			}
			System.out.println("");
		
			int is_hit;
			for(int i = 0; i < num_com; ++i) {
				System.out.println("--- Player" + Integer.toString(i + 2) + " turn ---");
				computer[i].print();
				is_hit = 1;
				while(is_hit == 1) {
					if(computer[i].sum() < 14) {
						is_hit = 1;
					}
					else if(computer[i].sum() > 17) {
						is_hit = 0;
					}
					else {
						Random random = new Random();
						is_hit = (int)(random.nextInt(2));
					}
					if(is_hit == 1) {
						System.out.println("Hit");
						computer[i].add(deck.dealCard());
						if(computer[i].sum() > 21) {
							is_hit = 0;
						}
					}
					else {
						System.out.println("Stand");
					}
					computer[i].print();
				}
				System.out.println("");
			}
		
			System.out.println("\n--- House turn ---");
			house.print();
			is_hit = 1;
			while(is_hit == 1) {
				if(house.sum() < 17) {
					is_hit = 1;
				}
				else {
					is_hit = 0;
				}
				if(is_hit == 1) {
					System.out.println("Hit");
					house.add(deck.dealCard());
					if(house.sum() > 21) {
						is_hit = 0;
					}
				}
				else {
					System.out.println("Stand");
				}
				house.print();
			}
			System.out.println("");
		}
		
		System.out.println("--- Game Result ---");
		house.print();
		player.result(house.sum());
		for(int i = 0; i < num_com; ++i) {
			computer[i].result(house.sum());
		}
	}
}

class Card {
	int value, suit;
	
	public Card() {}
	public Card(int theValue, int theSuit) {
		value = theValue;
		suit = theSuit;
	}
	
	void print() {
		if(value == 1) {
			System.out.print('A');
		}
		else if(value == 11) {
			System.out.print('J');
		}
		else if(value == 12) {
			System.out.print('Q');
		}
		else if(value == 13) {
			System.out.print('K');
		}
		else {
			System.out.print(value);
		}
		System.out.print((char) suit);
	}
}

class Deck {
	private Card[] deck;
	private int cardsUsed;
	
	public Deck() {
		deck = new Card[52];
		for(int i = 1; i < 14; ++i) {
			for(int j = 0; j < 4; ++j) {
				int suit = 0;
				switch(j) {
				case 0:
					suit = 'c';
					break;
				case 1:
					suit = 'h';
					break;
				case 2:
					suit = 'd';
					break;
				case 3:
					suit = 's';
					break;
				}
				deck[i * 4 - 4 + j] = new Card(i, suit);
			}
		}
	}
	
	public void shuffle(int seed) {
		Random random = new Random(seed);
		for ( int i = deck.length-1; i > 0; i-- ) {
			int rand = (int)(random.nextInt(i+1));
			Card temp = deck[i];
			deck[i] = deck[rand];
			deck[rand] = temp;
		}
		cardsUsed = 0;
	}
	public Card dealCard() {
		if (cardsUsed == deck.length)
			throw new IllegalStateException("No cards are left in the deck.");
		cardsUsed++;
		return deck[cardsUsed - 1];
	}
	
}

class Hand {
	/* Your code */
	protected Card[] hand;
	protected int len;
	
	public Hand() {
		hand = new Card[15];
		len = 0;
	}
	
	void add(Card newCard) {
		hand[len++] = newCard;
	}
	protected int sum() {
		int res = 0, cnt = 0;
		
		for(int i = 0; i < len; ++i) {
			if(hand[i].value == 11 || hand[i].value == 12 || hand[i].value == 13) {
				res += 10;
			}
			else {
				res += hand[i].value;
				if(hand[i].value == 1){
					++cnt;
				}
			}
		}
		
		while(cnt-- > 0 && res < 12) {
			res += 10;
		}
		
		return res;
	}
	void print() {
		for(int i = 0; i < len - 1; ++i) {
			hand[i].print();
			System.out.print(", ");
		}
		hand[len-1].print();
		System.out.print(" (" + Integer.toString(sum()) + ")");
		if(sum() > 21) {
			System.out.print(" - Bust!");
		}
		System.out.println("");
	}
	void result(int house) {
		String res = "Draw";
		
		if(sum() > 21) {
			res = "Lose";
		}
		else if(house > 21) {
			res = "Win";
		}
		else if(sum() < house) {
			res = "Lose";
		}
		else if(sum() > house) {
			res = "Win";
		}
		System.out.print("[" + res + "] ");
	}
}                      //Set of cards in your hand
class Computer extends Hand {
	/* Your code */
	private int id;
	
	public Computer(int n) {
		id = n;
	}
	
	void print() {
		System.out.print("Player" + Integer.toString(id) + ": ");
		super.print();
	}
	void result(int house) {
		super.result(house);
		print();
	}
}     //Player automatically participates
class Player extends Hand {
	/* Your code */
	void print() {
		System.out.print("Player1: ");
		super.print();
	}
	void result(int house) {
		super.result(house);
		print();
	}
}       //Player you control
class House extends Hand {
	/* Your code */
	void print() {
		System.out.print("House: ");
		super.print();
	}
	void printH() {
		System.out.print("House: HIDDEN, ");
		hand[1].print();
		System.out.println("");
	}
}