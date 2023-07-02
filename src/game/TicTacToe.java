package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe<Jlabel> implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(Color.black);
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Comic Sans MS", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("TIC-TAC-TOE");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,900,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(245,25,90));
		
		for (int i=0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Comic Sans MS",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i =0; i< 9;i++) {
			if(e.getSource()==buttons[i]) {
			if(player1_turn) {
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(255,0,0));
					buttons[i].setText("X");
					player1_turn=false;
					textfield.setText("O turn");
					check();
				}
			}else {
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(0,0,255));
					buttons[i].setText("O");
					player1_turn=true;
					textfield.setText("X turn");
					check();
				}
				
			}
		}
		}
		
	}
	
	public void firstTurn() {
		try {
		Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn = true;
			textfield.setText("X turn");
		}else {
			player1_turn = false;
			textfield.setText("O turn");
			
		}
		
	}
	public void check() {
		// check X win conditions
		// row conditions
		if (
				(buttons[0].getText().equals("X")) &&
				(buttons[1].getText().equals("X")) &&
				(buttons[2].getText().equals("X"))
		) {
			xWins(0, 1, 2);
		}
		if (
				(buttons[3].getText().equals("X")) &&
				(buttons[4].getText().equals("X")) &&
				(buttons[5].getText().equals("X"))
		) {
			xWins(3, 4, 5);
		}
		if (
				(buttons[6].getText().equals("X")) &&
				(buttons[7].getText().equals("X")) &&
				(buttons[8].getText().equals("X"))
		) {
			xWins(6, 7, 8);
		}
		// diagonal conditions
		if (
				(buttons[0].getText().equals("X")) &&
				(buttons[4].getText().equals("X")) &&
				(buttons[8].getText().equals("X"))
		) {
			xWins(0, 4, 8);
		}
		if (
				(buttons[2].getText().equals("X")) &&
				(buttons[4].getText().equals("X")) &&
				(buttons[6].getText().equals("X"))
		) {
			xWins(2, 4, 6);
		}
		// column conditions
		if (
				(buttons[0].getText().equals("X")) &&
				(buttons[3].getText().equals("X")) &&
				(buttons[6].getText().equals("X"))
		) {
			xWins(0, 3, 6);
		}
		if (
				(buttons[1].getText().equals("X")) &&
				(buttons[4].getText().equals("X")) &&
				(buttons[7].getText().equals("X"))
		) {
			xWins(1, 4, 7);
		}
		if (
				(buttons[2].getText().equals("X")) &&
				(buttons[5].getText().equals("X")) &&
				(buttons[8].getText().equals("X"))
		) {
			xWins(2, 5, 8);
		}
		
		// check O win conditions
		// row conditions
		if (
				(buttons[0].getText().equals("O")) &&
				(buttons[1].getText().equals("O")) &&
				(buttons[2].getText().equals("O"))
		) {
			oWins(0, 1, 2);
		}
		if (
				(buttons[3].getText().equals("O")) &&
				(buttons[4].getText().equals("O")) &&
				(buttons[5].getText().equals("O"))
		) {
			oWins(3, 4, 5);
		}
		if (
				(buttons[6].getText().equals("O")) &&
				(buttons[7].getText().equals("O")) &&
				(buttons[8].getText().equals("O"))
		) {
			oWins(6, 7, 8);
		}
		// diagonal conditions
		if (
				(buttons[0].getText().equals("O")) &&
				(buttons[4].getText().equals("O")) &&
				(buttons[8].getText().equals("O"))
		) {
			oWins(0, 4, 8);
		}
		if (
				(buttons[2].getText().equals("O")) &&
				(buttons[4].getText().equals("O")) &&
				(buttons[6].getText().equals("O"))
		) {
			oWins(2, 4, 6);
		}
		// column conditions
		if (
				(buttons[0].getText().equals("O")) &&
				(buttons[3].getText().equals("O")) &&
				(buttons[6].getText().equals("O"))
		) {
			oWins(0, 3, 6);
		}
		if (
				(buttons[1].getText().equals("O")) &&
				(buttons[4].getText().equals("O")) &&
				(buttons[7].getText().equals("O"))
		) {
			oWins(1, 4, 7);
		}
		if (
				(buttons[2].getText().equals("O")) &&
				(buttons[5].getText().equals("O")) &&
				(buttons[8].getText().equals("O"))
		) {
			oWins(2, 5, 8);
		}
	}
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
		
	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
		
	}
	
	
}