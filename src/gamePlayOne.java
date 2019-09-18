import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gamePlayOne extends JFrame{
	
	JPanel pa = new JPanel();
	Button bt[] = new Button[9];
	JPanel botPanel = new JPanel();
	Button returnButton = new Button("New Game");
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
    Main m = new Main();
    
    static int indexData[] = {0,1,2,3,4,5,6,7,8};

	public gamePlayOne(String str) {
		setTitle(str);
		setLayout(null);
		setBounds(300, 200, 400, 500);
		pa.setLayout(new GridLayout(3, 3));
		pa.setBounds(3, 0, 380, 360);
		
		botPanel.setLayout(new GridLayout(0, 1));
		botPanel.setBounds(3, 360, 380, 100);
		
		botPanel.add(msg);
		botPanel.add(returnButton);
		win();
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
        int ind = findIndex(indexData, i);
        indexData = removeTheElement(indexData,ind);
		arrX.add(i);
	}
	void setO(int i) {
		bt[i].setLabel("O");
		bt[i].setBackground(Color.RED);
		bt[i].setFont(new Font("Tahoma", Font.BOLD, 100));
        bt[i].setEnabled(false);
        int ind = findIndex(indexData, i);
        indexData = removeTheElement(indexData,ind);
		arrO.add(i);
	}
	void onClick(int i) {
		bt[i].addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
                setTitle("Next Player X");
                msg.setText("Next Player X");
                setX(i);
                try {
					int ran = getRandom(indexData);
					setO(ran);
					System.out.println("ran = "+ran);
				} catch (IllegalArgumentException e) {
					
				}
                countO++;
                countX++;
                count++;
                
                for (int i = 0; i < indexData.length; i++) {
                    System.out.print(indexData[i]+ " ");
                }
                System.out.println();
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
		    resetWin();
		}else if (oWin) {
			message = "O win" ;
			input = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION);
			resetWin();
		}
		if (countX== 5|| countO==5)
		{
			message = "Tie" ;
			input = JOptionPane.showConfirmDialog(null, message, "Message", JOptionPane.DEFAULT_OPTION);
			resetWin();
		}

	}
	void resetWin() {
		if (JOptionPane.OK_OPTION == input) {
			reset();
		}
	}
	void reset(){
		pa.removeAll();
		createButton();
		pa.validate();
		arrO.removeAll(arrO);
		arrX.removeAll(arrX);
		countX=0;
        countO=0;
        indexData = new int[9];
        for (int i = 0; i < 9; i++) {
            indexData[i] = i;
        }
        
	}
	void returnBT() {
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
	}

	void win(){
		addWindowListener(new WindowListener(){
		
			@Override
			public void windowOpened(WindowEvent e) {

			}		
			@Override
			public void windowIconified(WindowEvent e) {

			}		
			@Override
			public void windowDeiconified(WindowEvent e) {

			}		
			@Override
			public void windowDeactivated(WindowEvent e) {

			}		
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				reset();
				m.menu.setVisible(true);
			}		
			@Override
			public void windowClosed(WindowEvent e) {	

			}		
			@Override
			public void windowActivated(WindowEvent e) {
								
			}
		});
    }
    int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    int[] removeTheElement(int[] arr, int index) 
    { 
        if (arr == null || index < 0 || index >= arr.length) { 
            return arr; 
        }  
        int[] anotherArray = new int[arr.length - 1]; 
        for (int i = 0, k = 0; i < arr.length; i++) { 
            if (i == index) { 
                continue; 
            } 
            anotherArray[k++] = arr[i]; 
        } 
        return anotherArray; 
    }    
    int findIndex(int arr[], int t){ 
        int index = Arrays.binarySearch(arr, t); 
        return (index < 0) ? -1 : index; 
    }
}
