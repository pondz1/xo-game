import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;

public class Myframe extends JFrame{
	
	Button bt[] = new Button[9];
	int count = 0;
	Random ran = new Random();
	int num[] = {0,1,2,3,4,5,6,7,8};
	
	public Myframe(String str) {
		setTitle(str);
		setLayout(new GridLayout(3, 3));
		setBounds(300, 200, 400, 400);
		createButton();
		
	}
	void createButton() {
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new Button();
			this.add(bt[i]);
			onClick(i);
		}
	}
	void setX(int i) {
		bt[i].setLabel("X");
		bt[i].setBackground(Color.BLUE);
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 100));
		bt[i].setForeground(Color.BLACK);
		bt[i].setEnabled(false);
	}
	void setO(int i) {
		bt[i].setLabel("O");
		bt[i].setBackground(Color.RED);
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 100));
		bt[i].setEnabled(false);
	}
	void onClick(int i) {
		bt[i].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count%2 == 0) {
					setTitle("Next Player O");
					setX(i);
				}else {
					setTitle("Next Player X");
					setO(i);
				}
				count++;
			}
		});
	}
}
