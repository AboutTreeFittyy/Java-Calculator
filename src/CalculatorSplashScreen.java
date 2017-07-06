/*
 * File name: CalculatorSplashScreen.java
 * Author: Mathew Boland, 040800005
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 1 part 2
 * Date 03/10/2016
 * Professor: Svillen Ranev
 * Purpose: Generates a screen with an image of a calculator
 * and information for indicated amount of time
 */
import java.awt.*;

import javax.swing.*;

/** Purpose: To splash the screen for an indicated amount
 * of time with a calculator pic and information
 * @author Mathew Boland
 * @version 1
 * @see java.swing, java.awt
 * @since 1.8_65
 */
@SuppressWarnings("serial")
public class CalculatorSplashScreen extends JWindow{
	private int time; /**Time in seconds to display*/
	
	/**
	 * Purpose: Sets the time to splash for
	 * @param time Time in miliseconds
	 * @return CalculatorSplashScreen Object
	 */
	public CalculatorSplashScreen(int time)
	{
		 this.time = time;
	}
	
	/**
	 * Purpose: Creates and displays the splash screen
	 * @param
	 * @return 
	 */
	public void showSplashWindow()
	{			
		//create the panel
		JPanel pane = new JPanel(new BorderLayout());
		
		//Set the color
		pane.setBackground(Color.GREEN);
		
		//Get screen dimensions
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		//calculate dimensions for window screen boundary
		int x = (screen.width-700)/2;
		int y = (screen.height-500)/2;		
		
		//set boundary
		setBounds(x,y,700,500);
		
		//add more to pane
		JLabel png = new JLabel(new ImageIcon("Calculator.png"));
		JLabel info = new JLabel("Name: Mathew Boland Student #: 040800005", JLabel.CENTER);
		info.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
		pane.add(png, BorderLayout.CENTER);
		pane.add(info, BorderLayout.SOUTH);
	 
		Color customColor = new Color(44, 197, 211);
		pane.setBorder(BorderFactory.createLineBorder(customColor, 10));

		setContentPane(pane);

		setVisible(true);

		try {			    	
				Thread.sleep(time); 
			}
		catch (Exception e) {e.printStackTrace();}
		dispose(); 		
	}
}
