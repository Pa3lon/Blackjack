import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) throws FileNotFoundException {
		Blackjack game;
		
		// Om bruker sender med en deck fil hentes den inn og lager en ArrayList med Card objekter som sendes med som parameter til Game constructor.
		if (args.length > 0) {
			game = new Blackjack(args[0]);
			game.startGame();
		} else {
		game = new Blackjack();
		game.startGame();
		}
	}
}

