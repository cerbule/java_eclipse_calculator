package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//width and height of the JFrame
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	//create a new gridbag layout
	private GridBagLayout layout;
	//create gridbag  constraints-it will allow to position our buttons on the screen
	private GridBagConstraints gbc;
	
	//create the buttons 0-9
	private JButton[] numberButtons;
	
	public Calculator(){
		//set the size of the calculator
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		layout = new GridBagLayout();
		//setting the different widths of the columns, split in 4 columns
		layout.columnWidths = new int[] {80, 80, 80, 80};
		//same with the rows
		layout.rowHeights = new int[] {80, 80, 80, 80, 80, 80};
		// use the gridbag layout from above
		setLayout(layout);
		
		//create the buttons 0-9
		numberButtons = new JButton[10];
		for(int i = 0; i < numberButtons.length; i++){
			numberButtons[i] = new JButton("" + i);
		}
		
		//initialized 
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		//fill the whole grid position
		gbc.fill = GridBagConstraints.BOTH;
		//put the button
		add(numberButtons[0], gbc);
	}

	public static void main(String[] args) {
		// creating the JFrame
		JFrame frame = new JFrame("Calculator");
		// when closing the window the program terminates
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// calculator window cannot be resized
		frame.setResizable(false);
		// new panel that allows us to center the panel on the screen
		frame.setLayout(new BorderLayout());
		frame.add(new Calculator(), BorderLayout.CENTER);
		//set the size of the frame to the size of the panel
		frame.pack();
		//center our frame to the screen
		frame.setLocationRelativeTo(null);
		//make the frame visible
		frame.setVisible(true);
	}

}
