package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	public Calculator(){
		//set the size of the calculator
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
