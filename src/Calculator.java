/*
 * File name: Calculator.java
 * Author: Mathew Boland, 040800005
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 1 part 2
 * Date 03/10/2016
 * Professor: Svillen Ranev
 * Purpose: Creates a splash screen for five seconds
 * then runs the calculator
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/** Purpose: To splash the screen and run the calculator
 * @author Mathew Boland
 * @version 1
 * @see java.swing, java.awt
 * @since 1.8_65
 */
public class Calculator {
		
		/**
		 * Purpose: runs program
		 * @param args Arguments
		 * @return 
		 */
		public static void main(String[] args)
		{
			
			CalculatorSplashScreen splash = new CalculatorSplashScreen(5000);
			splash.showSplashWindow();
			
			//Now call EventQueue.invokeLater() with a runnable instance
			EventQueue.invokeLater(new Runnable()
	         {
				/**
				 * Purpose: Runs the calculator
				 * @param
				 * @return 
				 */
	            public void run()
	            {
	               JFrame calculatorView = new JFrame("Calculator");
	               calculatorView.setMinimumSize(new Dimension(276, 460));
	               calculatorView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               calculatorView.setContentPane(new CalculatorView());
	               calculatorView.setVisible(true);	
	            }
	         });
		}
}
