/*=============================================================================
 |   Assignment: Program #2(a): Hailstones
 |       Author: Kevin Montenegro
 | Sect. Leader: Wongoni Botha
 |
 |       Course: CSc 227
 |   Instructor: L. McCann
 |     Due Date: January 30, 2012, at 10:00 p.m.
 |
 |  Description: This program calculates a hailstone sequence, starting with
 |  an initial value given by the user using the following criteria:
 |               If the initial value is an even number, the next number in the
 |                  sequence is the first one divided by two.
 |               If the initial value is an odd number, the next number in the 
 |                  sequence is three times the first number, plus one.
 |  The program will then output the sequence and inform the user of the number
 |  of hailstones in the sequence and the size of the largest hailstone.
 |
 | Deficiencies: None; this program meets specifications.
 *===========================================================================*/

import java.util.*;          //Gives easy access to Java API's 'util' package
public class Prog2a 
{
	public static void main(String[] args)
	{
		int initValue,       //Initial hailstone in the sequence
		    currentValue,    //Current hailstone in the sequence
		    quantity = 0,    //Number of hailstones in the sequence
		    largest;         //Largest hailstone in the sequence
		
		boolean initValuePrinted = false;     //boolean to check if the initial value has been printed (for the FOR loop)
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the starting value for the hailstone sequence: ");
		initValue = keyboard.nextInt();
		
		while (initValue <= 0)                //Inform the user to give another input if they enter a number less than or equal to 0
		{
			System.out.println("\nInvalid Input! Please input a positive number greater than 0: ");
			initValue = keyboard.nextInt();
		}
		
		System.out.println("\nThe sequence of hailstones formed from " + initValue + " is: \n");
		
		/* FOR Loop - goes through and calculates the sequence until a 1 appears, printing 8 characters per line */
		currentValue = initValue;
		largest = currentValue;
		int count = 0;                          //variable to count the number of hailstones in each line
		while (count < 8)
		{
			if (!initValuePrinted)
			{
				System.out.print("\t" + initValue);
				initValuePrinted = true;
				quantity ++;                   //add to the amount of hailstones
				count ++;
			}
			else
			{
				if (currentValue != 1)         //go on until there is a one in the sequence
				{
					if (currentValue % 2 == 0)     //if it is an even number
					{
						currentValue = currentValue/2;
					}
					else                           //if it is an odd number
					{
						currentValue = (3 * currentValue) + 1;
					}
					if (currentValue > largest)    //check if this new hailstone is larger than the largest known hailstone, if it is, this is the new largest hailstone
					{
						largest = currentValue;
					}
					System.out.print("\t" + currentValue);
					quantity ++;                   //add to the amount of hailstones
					count ++;
					
					if (count >= 8)            //if there are eight hailstones on this line, go to the next
					{
						System.out.print("\n");
						count = 0;
					}
				}
				else
				{
					break;
				}
			}
		}
		
		System.out.println("\n\nThe hailstone sequence contains " + quantity + " hailstones, and the largest\n"
				           + "hailstone is " + largest + ".");
		
	} //main

} //class Prog2a
