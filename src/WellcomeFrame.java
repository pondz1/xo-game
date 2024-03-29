import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WellcomeFrame extends JFrame{
	
	public WellcomeFrame(String str) {
		gamePlayTwo playTwo = new gamePlayTwo("XO");
		playTwo.setVisible(false);

		gamePlayOne playOne = new gamePlayOne("XO");
		playOne.setVisible(false);
		
		setTitle("XO Game");
		setLayout(null);
		setBounds(300, 200, 400, 200);
		
		Button playTwoButton = new Button("2 Player");
		playTwoButton.setSize(180, 90);
		playTwoButton.setLocation(195, 20);
		playTwoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				playTwo.setVisible(true);
				
			}
		});

		Button playOneButton = new Button("1 Player");
		playOneButton.setSize(180, 90);
		playOneButton.setLocation(5, 20);
		playOneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				playOne.setVisible(true);
				
			}
		});

		JPanel pan = new JPanel();
		pan.setSize(400, 200);
		pan.setLayout(null);
		pan.add(playOneButton);
		pan.add(playTwoButton);
		setDefaultCloseOperation(3);
		add(pan);
		addWindowListener(new WindowListener(){
		
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
		
		
	}
}
