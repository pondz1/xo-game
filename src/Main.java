import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	static JFrame menu = new JFrame("Wellcome");

	public static void main(String[] args) {
		gamePlayTwo gamePlayTwo = new gamePlayTwo("XO");
		gamePlayTwo.setVisible(false);

		
		menu.setLayout(null);
		menu.setBounds(300, 200, 400, 200);
		
		Button playTwo = new Button("2 Player");
		playTwo.setSize(180, 90);
		playTwo.setLocation(5, 20);
		playTwo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(false);
				gamePlayTwo.setVisible(true);
				
			}
		});
		JPanel pan = new JPanel();
		pan.setSize(400, 200);
		pan.setLayout(null);
		pan.add(playTwo);
		menu.setDefaultCloseOperation(3);
		menu.add(pan);
		menu.addWindowListener(new WindowListener(){
		
			@Override
			public void windowOpened(WindowEvent e) {

			}
		
			@Override
			public void windowIconified(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void windowDeiconified(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void windowDeactivated(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void windowClosing(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void windowClosed(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void windowActivated(WindowEvent e) {				// TODO Auto-generated method stub
				
			}
		});
		menu.setVisible(true);
		
	}
}
