import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) {
		Myframe gamePlay = new Myframe("XO");
		gamePlay.setVisible(false);

		JFrame menu = new JFrame("Wellcome");
		menu.setLayout(null);
		menu.setBounds(300, 200, 400, 200);
		
		Button playTwo = new Button("2 Player");
		playTwo.setSize(180, 90);
		playTwo.setLocation(5, 20);
		playTwo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//menu.setVisible(false);
				gamePlay.setVisible(true);
				
			}
		});
		JPanel pan = new JPanel();
		pan.setSize(400, 200);
		pan.setLayout(null);
		pan.add(playTwo);
		
		menu.add(pan);
		//menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
		
	}
}
