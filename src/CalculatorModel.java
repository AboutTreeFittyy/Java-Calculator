/*
 * File name: CalculatorModel.java
 * Author: Mathew Boland, 040800005
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 1 part 2
 * Date 03/10/2016
 * Professor: Svillen Ranev
 * Purpose: Holds the operands set by the controller
 * and performs specified calculation when told.
 * Also keeps track of the current mode (int float 
 * and precision)
 */
import java.math.BigDecimal;

/** Purpose: To perform the given operation on two 
 * operands that are set.
 * @author Mathew Boland
 * @version 1
 * @see java.swing, java.awt
 * @since 1.8_65
 */
public class CalculatorModel {

	//Class private data members
	private String operation ="+"; /**operation for calculation*/
	private String mode = "float"; /**Data type for calculation (float or int)*/
	private String floatPrecision = ".00"; /**floating point precision*/
	private String operand1 = "0"; /**First operand of calculation*/
	private String operand2 = "0"; /**second operand of calculation*/
	private boolean error; /**error flag*/
	private int intResult = 0; /**result of calculation in integer form*/
	private float floatResult = 0; /**result of calculation in floating point form*/
	
	/**
	 * Purpose: Sets the first operand for the calculation
	 * @param operand1 The first operand in a string
	 * @return 
	 */
	public void setFirstOperand(String operand1)
	{
		this.operand1 = operand1;
	}
	/**
	 * Purpose: Sets the second operand for the calculation
	 * @param operand2 The second operand in the calculation
	 * @return 
	 */
	public void setSecondOperand(String operand2)
	{
		this.operand2 = operand2;
	}
	
	/**
	 * Purpose: Set the operation mode for the calculation
	 * @param operation The operation to perform
	 * @return 
	 */
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	
	/**
	 * Purpose: Sets the current data type mode (float or int)
	 * @param mode String containing the mode name
	 * @return 
	 */
	public void setMode(String mode)
	{
		this.mode = mode;
	}
	
	/**
	 * Purpose: Lets the Controller know what mode it's currently in
	 * @param
	 * @return String Contains the current mode
	 */
	public String getMode()
	{
		return mode;
	}
	
	/**
	 * Purpose: Sets the precision type for when the float mode is enabled
	 * @param floatPrecision The precision type to be used
	 * @return 
	 */
	public void setFloatPrecision(String floatPrecision)
	{
		this.floatPrecision = floatPrecision;
	}
	
	/**
	 * Purpose: Returns the answer from a calculation in the proper format
	 * @param
	 * @return String The answer
	 */
	public String getAnswer()
	{		
		String answer;
		//format the string
		if(mode == "int")
		{
			answer = formatNum(Integer.toString(intResult));
		}
		else
		{
			answer = formatNum(Float.toString(floatResult));
		}
		return answer;
	}
	
	/**
	 * Purpose: Formats a given number to the indicated type
	 * @param num String containg number to format
	 * @return String The number formatted
	 */
	public String formatNum(String num)
	{
		//check mode to see how it should be formatted
		if(mode == "int")
		{
			//using BigDecimal to make sure rounding will go down on 
			//half or less
			BigDecimal round = new BigDecimal(num);
			
			
			return round.setScale(0, BigDecimal.ROUND_HALF_DOWN).toString();
		}
		else if(floatPrecision == ".0")
		{
			return String.format("%.1f", Float.valueOf(num));
		}
		else if(floatPrecision == "Sci")
		{
			return String.format("%.6e", Float.valueOf(num));
		}
		else
		{
			return String.format("%.2f", Float.valueOf(num));
		}
	}
	
	
	/**
	 * Purpose: Sets the error flag
	 * @param error Boolean indicating if error or not
	 * @return 
	 */
	public void setError(boolean error)
	{
		this.error = error;
	}
	
	/**
	 * Purpose: Return the current error state
	 * @param
	 * @return boolean Contains error state
	 */
	public boolean getError()
	{		
		return error;
	}
	
	/**
	 * Purpose: performs a calculation when called using all set variables
	 * @param
	 * @return 
	 */
	public void performCalculations()
	{
		//check mode to see what type is to be calculated
		if(mode == "int")
		{
			intResult = 0;
			int op1 = Integer.valueOf(operand1), op2 = Integer.valueOf(operand2);
			//Switch on the operation to be performed then calculate
			switch(operation)
			{
			case "+": intResult = op1 + op2;
				break;
			case "-": intResult = op1 - op2;
				break;
			case "*": intResult = op1 * op2;
				break;
			case "/": 
				//check for divide by zero
				if(op2 == 0)
				{
					setError(true);
				}
				else
				{
					intResult = op1 / op2;
				}				
				break;
			default: setError(true);
			}	
			op1 = intResult;
		}
		else if(mode == "float")
		{
			floatResult = 0;

			float op1 = Float.valueOf(operand1), op2 = Float.valueOf(operand2);
			//Switch on the operation to be performed then calculate
			switch(operation)
			{
			case "+": floatResult = op1 + op2;
				break;
			case "-": floatResult = op1 - op2;
				break;
			case "*": floatResult = op1 * op2;
				break;
			case "/": 
				//check for divide by zero
				if(Float.compare(op2, 0) == 0)
				{
					setError(true);
				}
				else
				{
					floatResult = op1 / op2;
				}				
				break;
			default: setError(true);
			}
			op1 = floatResult;
		}
		else
		{
			setError(true);
		}
	}	
}












