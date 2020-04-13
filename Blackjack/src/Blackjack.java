import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
    final String[] suit = {"S", "C", "D", "H"};
    final String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    GameGUI gui;
	ArrayList<Card> deck;
	ArrayList<Card> playerCards;
	ArrayList<Card> dealerCards;
	boolean isDrawing = true;
	boolean playerBust = false; // Testing 
	boolean dealerBust = false; // Testing
	boolean importedDeck = false;
	int playerScore;
	int dealerScore;
	
	// Constructor
	public Blackjack() {
		this.gui = new GameGUI();
		this.gui.newGame.setVisible(false);
		this.deck = IntilizeDeck();
		addActionListeners();
	}
	
	public Blackjack(String path) throws FileNotFoundException {
		this.gui = new GameGUI();
		this.gui.newGame.setVisible(false);
		this.deck = InitilizeDeck(path);
		addActionListeners();
	}
	
	// Metoder for å lage en ny kortstokk
	public ArrayList<Card> IntilizeDeck() {
		ArrayList<Card> list = new ArrayList<Card>();
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				list.add(new Card(suit[i], rank[j]));
			}
		}
		Collections.shuffle(list); // Stokker listen.	
		return list;
	}
	
	// Metode som tar en fil som argument for kortstokk
	public ArrayList<Card> InitilizeDeck(String path) throws FileNotFoundException {
		ArrayList<Card> deck = new ArrayList<Card>();
		File deckFile = new File(path);
		Scanner reader =  new Scanner(deckFile);
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			String[] splitted = data.split(",");
			for (int i = 0; i < splitted.length; i++) {
				deck.add(new Card(splitted[i].replaceAll("\\s+","")));
			}
		}
		return deck;
	}
	
	public void startGame() {
		isDrawing = true;
		playerBust = false;
		dealerBust = false;
		playerCards = new ArrayList<Card>();
		dealerCards = new ArrayList<Card>();
		playerCards.add(deck.remove(0));
		dealerCards.add(deck.remove(0));
		playerCards.add(deck.remove(0));
		dealerCards.add(deck.remove(0));
		checkConditions();
	}
	
	public int[] getScore() {
		int[] score = new int[2];
			for (int i = 0; i < playerCards.size(); i++) {
				score[0] += playerCards.get(i).getValue();
			}
			for (int i = 0; i < dealerCards.size(); i++) {
				score[1] += dealerCards.get(i).getValue();
			}
		return score;
	}
	
	// Fjerner et kort fra stokken og legger til playerCards
	public void newPlayerCard() {
		playerCards.add(deck.remove(0));
		checkConditions();
	}
	
	// Calles dersom spiller står
	public void newDealerCard() {
		playerScore = getScore()[0];
		dealerScore = getScore()[1];
		checkConditions();
		while(dealerScore < playerScore) {
			dealerCards.add(deck.remove(0));
			checkConditions();
			dealerScore = getScore()[1];
		}
	}

	public void checkConditions() {
		playerScore = getScore()[0];
		dealerScore = getScore()[1];
		
		if (dealerScore == 21 && playerScore == 21) {
			gui.statusMsg.setText("Dealer and player have 21. Player Wins!");
			stopGame();
		} else if (dealerScore == 21 && playerScore != 21) {
			gui.statusMsg.setText("Dealer have 21. Dealer Win");
			stopGame();
		} else if (playerScore == 21 && dealerScore != 21) {
			gui.statusMsg.setText("Player have 21. Player Win");
			stopGame();
		} else if (dealerScore == 22 && playerScore == 22) {
			gui.statusMsg.setText("Dealer and player have 22. Dealer Win");
			stopGame();
		} else if (playerScore > 21) {
			gui.statusMsg.setText("Player have " + playerScore + ". Dealer Win");
			stopGame();
		} else if (dealerScore > 21) {
			gui.statusMsg.setText("Dealer have " + dealerScore + ". Player Win");
			stopGame();
		} else if (dealerScore > playerScore && dealerScore <= 21 && isDrawing == false) {
			gui.statusMsg.setText("Dealer have " + dealerScore + ", player have " + playerScore + ". Dealer win");
			stopGame();
		} else if (playerScore >= 17 && isDrawing == true) {
			isDrawing = false;
			newDealerCard();
		}
		gui.playerMsg.setText("Player " + playerCards.toString() + " (" + playerScore + ")");
		gui.dealerMsg.setText("Dealer: " + dealerCards.toString() + " (" + dealerScore + ")");
		gui.frame.pack();
	}		
	
	public void stopGame() {
		gui.drawBtn.setVisible(false);
		gui.standBtn.setVisible(false);
		gui.newGame.setVisible(true);
	}
	
	public void addActionListeners() {
		gui.drawBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newPlayerCard();
			}
		});
		
		gui.standBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isDrawing = false;
				newDealerCard();
			}
		});
		
		gui.newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.newGame.setVisible(false);
				gui.standBtn.setVisible(true);
				gui.drawBtn.setVisible(true);
				gui.statusMsg.setText("Draw or stand");
				startGame();
			}
			
		});
	}
	
	
}


