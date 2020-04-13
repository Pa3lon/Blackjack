import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// GUI
public class GameGUI {
	public JFrame frame;
	public JPanel panel;
	public JLabel statusMsg;
	public JLabel playerMsg;
	public JLabel dealerMsg;
	public JButton drawBtn;
	public JButton standBtn;
	public JButton newGame;
	
	public GameGUI() {
	 frame = new JFrame();
	 panel = new JPanel();
	 statusMsg = new JLabel("Draw or stand?");
	 playerMsg = new JLabel("Player");
	 dealerMsg = new JLabel("Dealer");
	 drawBtn = new JButton("Draw");
	 standBtn = new JButton("Stand");
	 newGame = new JButton("New Game");
	
	panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	panel.setLayout(new GridLayout(0, 1));
	panel.add(statusMsg);
	panel.add(playerMsg);
	panel.add(dealerMsg);
	panel.add(drawBtn);
	panel.add(standBtn);
	panel.add(newGame);
	
	frame.add(panel, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
	
	}

}
