
public class Card {
	String rank;
	String suit;
	
	Card(String suit, String rank) {
		this.rank = rank;
		this.suit = suit;
	}
	
	Card(String preDefinedDeck) {
		this.rank = "" + preDefinedDeck.charAt(1);
		this.suit = "" + preDefinedDeck.charAt(0);
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	@Override
	public String toString() {
		return this.suit + this.rank;
	}
	
	public int getValue() {
		int value;
		switch(this.rank) {
		case "2": value = 2; break;
		case "3": value = 3; break;
		case "4": value = 4; break;
		case "5": value = 5; break;
		case "6": value = 6; break;
		case "7": value = 7; break;
		case "8": value = 8; break;
		case "9": value = 9; break;
		case "10": value = 10; break;
		case "J": value = 10; break;
		case "Q": value = 10; break;
		case "K": value = 10; break;
		case "A": value = 11; break;
		default: value = 0;
		}
		return value;
	}
}
