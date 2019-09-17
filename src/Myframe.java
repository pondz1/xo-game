import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Myframe extends JFrame{
	
	JPanel pa = new JPanel();
	Button bt[] = new Button[9];
	JPanel botPanel = new JPanel();
	Button returnButton = new Button("return");
	JLabel msg = new JLabel();
	int count = 0;
	ArrayList<Integer> arrX = new ArrayList<Integer>();
	ArrayList<Integer> arrO = new ArrayList<Integer>();
	
	ArrayList<Integer> lineTop = new ArrayList<Integer>();
	ArrayList<Integer> lineMid = new ArrayList<Integer>();
	ArrayList<Integer> lineBot = new ArrayList<Integer>();
	
	ArrayList<Integer> lineleft = new ArrayList<Integer>();
	ArrayList<Integer> lineMidV = new ArrayList<Integer>();
	ArrayList<Integer> lineright = new ArrayList<Integer>();
	
	ArrayList<Integer> left = new ArrayList<Integer>();
	ArrayList<Integer> right = new ArrayList<Integer>();
	
	int input = 100;
	int countX=0;
	int countO=0;
	public Myframe(String str) {
		setTitle(str);
		//setLayout(new GridLayout(0, 1));
		setLayout(null);
		setBounds(300, 200, 400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pa.setLayout(new GridLayout(3, 3));
		pa.setBounds(3, 0, 380, 360);
		
		botPanel.setLayout(new GridLayout(0, 1));
		botPanel.setBounds(3, 360, 380, 100);
		
		botPanel.add(msg);
		botPanel.add(returnButton);
		
		add(pa);
		add(botPanel);
		theCondition();
		createButton();
		returnBT();
		
	}
	void createButton() {
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new Button();
			pa.add(bt[i]);
			onClick(i);
		}
	}
	void setX(int i) {
		bt[i].setLabel("X");
		bt[i].setBackground(Color.BLUE);
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 100));
		bt[i].setForeground(Color.BLACK);
		bt[i].setEnabled(false);
		arrX.add(i);
	}
	void setO(int i) {
		bt[i].setLabel("O");
		bt[i].setBackground(Color.RED);
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 100));
		bt[i].setEnabled(false);
		arrO.add(i);
	}
	void onClick(int i) {
		bt[i].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count%2 == 0) {
					setTitle("Next Player O");
					msg.setText("Next Player O");
					setX(i);
					countX++;
				}else {
					setTitle("Next Player X");
					msg.setText("Next Player X");
					setO(i);
					countO++;
				}
				count++;
				checkWin();
			}
		});
	}
	void theCondition() {
		lineTop.add(0);lineTop.add(1);lineTop.add(2);
		lineMid.add(3);lineMid.add(4);lineMid.add(5);
		lineBot.add(6);lineBot.add(7);lineBot.add(8);
		
		lineleft.add(0);lineleft.add(3);lineleft.add(6);
		lineMidV.add(1);lineMidV.add(4);lineMidV.add(7);
		lineright.add(2);lineright.add(5);lineright.add(8);
		
		left.add(0);left.add(4);left.add(8);
		right.add(2);right.add(4);right.add(6);
	}
	void checkWin() {
		
		String  message = " "; 
		boolean xWin = (arrX.containsAll(lineTop) || arrX.containsAll(lineMid) || arrX.containsAll(lineBot) || arrX.containsAll(lineleft) || arrX.containsAll(lineMidV) || arrX.containsAll(lineright) || arrX.containsAll(left) || arrX.containsAll(right));
		boolean oWin = (arrO.containsAll(lineTop) || arrO.containsAll(lineMid) || arrO.containsAll(lineBot) || arrO.containsAll(lineleft) || arrO.containsAll(lineMidV) || arrO.containsAll(lineright) || arrO.containsAll(left) || arrO.containsAll(right)); 
		if (xWin) {
			message = "X win" ;
		    input = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION);
		    reset();
		}else if (oWin) {
			message = "O win" ;
			input = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION);
			reset();
		}
		if (countX== 5|| countO==5)
		{
			message = "Tie" ;
			input = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION);
			reset();
		}

	}
	void reset() {
		if (JOptionPane.OK_OPTION == input) {
			pa.removeAll();
			createButton();
			pa.validate();
			arrO.removeAll(arrO);
			arrX.removeAll(arrX);
			countX=0;
			countO=0;
		}
	}
	void returnBT() {
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				reset();
			}
		});
	}
}
