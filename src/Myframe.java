import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Myframe extends JFrame{
	
	Button bt[] = new Button[9];
	
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
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 60));
	}
	void onClick(int i) {
		bt[i].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setX(i);
					
			}
		});
	}
}
