package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	//other buttons
	private JButton[] opButtons;
	
	//add the text field
	private JTextField field;
	
	//create a new multi-dimenstional array of ints
	//[0] = gridx, [1]=gridy, [2] = gridwidth, [3] = gridheight
	private int[][] numConstraints = new int[][]{
		{0, 5, 2, 1},
		{0 ,4, 1, 1},
		{1, 4 ,1 ,1},
		{2, 4, 1, 1},
		{0, 3, 1, 1},
		{1, 3, 1, 1},
		{2, 3, 1, 1},
		{0, 2, 1, 1},
		{1, 2, 1, 1},
		{2, 2, 1, 1},
	};
	
	private int[][] opConstraints = new int[][]{
		{2, 5, 1, 1},
		{3, 4, 1, 2},
		{3, 3, 1, 1},
		{3, 2, 1, 1},
		{3, 1, 1, 1},
		{2, 1, 1, 1},
		{1, 1, 1, 1},
		{0, 1, 1, 1},
	};
	
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
		
		//initialized 
		gbc = new GridBagConstraints();
		
		//create the buttons 0-9
		numberButtons = new JButton[10];
		for(int i = 0; i < numberButtons.length; i++){
			numberButtons[i] = new JButton("" + i);
			
			//it's gonna take the values  to put the buttons
			gbc.gridx = numConstraints[i][0];
			gbc.gridy = numConstraints[i][1];
			gbc.gridwidth = numConstraints[i][2];
			gbc.gridheight = numConstraints[i][3];
			gbc.fill = GridBagConstraints.BOTH;
			
			//space between the buttons, a kind of padding
			gbc.insets = new Insets(2, 2, 2, 2);
			
			add(numberButtons[i], gbc);
		}
		
		//the rest of the buttons
		
		opButtons = new JButton[8];
		opButtons[0] = new JButton(".");
		opButtons[1] = new JButton("=");
		opButtons[2] = new JButton("+");
		opButtons[3] = new JButton("-");
		opButtons[4] = new JButton("*");
		opButtons[5] = new JButton("/");
		opButtons[6] = new JButton("+/-");
		opButtons[7] = new JButton("c");
		
		
		for(int i = 0; i < opButtons.length; i++){
			gbc.gridx = opConstraints[i][0];
			gbc.gridy = opConstraints[i][1];
			gbc.gridwidth = opConstraints[i][2];
			gbc.gridheight = opConstraints[i][3];
			
			add(opButtons[i], gbc);
		}
		
		//adding the text field
		field = new JTextField();
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setEditable(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		
		add(field, gbc);
		
		//we're gonna add the buttons in a different way
//		gbc.gridx = 0;
//		gbc.gridy = 5;
//		//fill the whole grid position
//		gbc.fill = GridBagConstraints.BOTH;
//		//put the button
//		add(numberButtons[0], gbc);
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
	
	//add a comment for git
}
