import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void BothPlayersHave21() throws FileNotFoundException {
		// File input: SA, CA, HK, CK
		URL url = Test.class.getClassLoader().getResource("BothHave21.txt");
		Blackjack game = new Blackjack(url.getPath());
		game.startGame();
		int[] score = game.getScore();
		assertEquals(21, score[0]);
		assertEquals(21, score[1]);
	}
	
	@Test
	public void BothPlayersHave22() throws FileNotFoundException {
		// File input: HA, CA, SA, DA
				URL url = Test.class.getClassLoader().getResource("BothHave22.txt");
				Blackjack game = new Blackjack(url.getPath());
				game.startGame();
				int[] score = game.getScore();
				assertEquals(22, score[0]);
				assertEquals(22, score[1]);
	}
	
	@Test
	public void DealerBustPlayerWin() throws FileNotFoundException {
		// File input: HK, H6, H7, H8, H10
		URL url = Test.class.getClassLoader().getResource("DealerBustPlayerWin.txt");
		Blackjack game = new Blackjack(url.getPath());
		game.startGame();
		int[] score = game.getScore();
		assertEquals(17, score[0]);
		assertEquals(24, score[1]);
	}
	
	@Test
	public void DealerHave21() throws FileNotFoundException {
		// File input: H10, HA, HK, HQ
		URL url = Test.class.getClassLoader().getResource("DealerHave21.txt");
		Blackjack game = new Blackjack(url.getPath());
		game.startGame();
		String statusMsg = game.gui.statusMsg.getText();
		assertEquals("Dealer have 21. Dealer Win", statusMsg);
	}
	
	@Test
	public void PlayerHave21() throws FileNotFoundException {
		// File input: HA, H10, HK, HQ
		URL url = Test.class.getClassLoader().getResource("playerHave21.txt");
		Blackjack game = new Blackjack(url.getPath());
		game.startGame();
		String statusMsg = game.gui.statusMsg.getText();
		assertEquals("Player have 21. Player Win", statusMsg);
	}
	
	@Test
	public void PlayerBustDealerWin() throws FileNotFoundException {
		// File input: H10, HK, H6, HQ, HJ, 
		URL url = Test.class.getClassLoader().getResource("playerBustDealerWin.txt");
		Blackjack game = new Blackjack(url.getPath());
		game.startGame();
		game.newPlayerCard();
		game.newPlayerCard();
		String statusMsg = game.gui.statusMsg.getText();
		assertEquals("Player have 26. Dealer Win", statusMsg);
	}
	

}
