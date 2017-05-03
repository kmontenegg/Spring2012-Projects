/*=============================================================================
 |   Assignment: Program #1(b): Body Mass Index
 |       Author: Kevin Montenegro
 | Sect. Leader: Wongoni Botha
 |
 |       Course: CSc 227
 |   Instructor: L. McCann
 |     Due Date: January 23, 2012, at 10:00 p.m.
 |
 |  Description: This program requests from the user their weight in pounds
 | and their height in feet and inches and calculates their Body Mass Index
 | and displays it in the terminal.
 |
 | Deficiencies: None; this program meets specifications.
 *===========================================================================*/
import java.util.*;    // Gives easy access to Java API’s "util" package

public class Prog1b 
{
	static double INCHES_TO_METERS = 0.0254;    // 1 in. = 0.0254 meters
	static double POUNDS_TO_KG = 0.4536;        // 1 lb. ~= 0.4536 kilograms
	
	public static void main(String[] args)
	{ 
		double   weight,   //input weight
		         height,   //input height
		         BMI;      //Body Mass Index
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("\nThis program will calculate Body Mass Index "
						 + "based on weight and height.");
		
		System.out.print("\nEnter weight in pounds: ");
		weight = keyboard.nextDouble()*POUNDS_TO_KG;
		
		System.out.print("Enter height"
				       + "\nFeet: ");
		height = keyboard.nextDouble()*12*INCHES_TO_METERS;
		
		System.out.print("Inches: ");
		height += keyboard.nextDouble()*INCHES_TO_METERS;
		
		BMI = weight/(height * height);
		
		System.out.println("\nThe Body Mass Index for a person "
				         + "weighing " + weight + " kilograms \n"
				         + "with a height of " + height
				         + " meters is " + BMI + ".");
	} //main
} //class Prog1b
