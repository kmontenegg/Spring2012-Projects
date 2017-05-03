/*=============================================================================
 |   Assignment: Program #2(b): Calendar
 |       Author: Kevin Montenegro
 | Sect. Leader: Wongoni Botha
 |
 |       Course: CSc 227
 |   Instructor: L. McCann
 |     Due Date: January 30, 2012, at 10:00 p.m.
 |
 |  Description: This program will display the calendar for a month specified
 | by the user. The user will input the month and year and that month's 
 | calendar will be displayed in the terminal.
 |
 | Deficiencies: None; this program meets specifications.
 *===========================================================================*/
import java.util.*;     //Gives easy access to Java API's 'util' package

public class Prog2b {
	
	public static void main (String[] args)
	{
		/*Variables for Babwani's Congruence*/
		int d = 1,                //day of the month (initialized at one because that's the day every month starts at)
		    m,                    //number of the month
		    c,                    //century of the year
		    y,                    //year of the century
		    monthCode = 0,        //month code for the Babwani calculation
		    year,                 //user input year, used to derive c and y
		    days = 0,             //variable used to keep track of the days in the user selected month
	        w;                    //day of the week
		boolean isLeap = false;   //variable used to determine whether the year is a leap year or not
		String month = "";        //name of the month to display on the calendar
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("This program will display a calendar specified by a month and year.\n"
				          + "\nEnter the month (1-12): ");
		m = keyboard.nextInt();
		
		System.out.print("Enter the year: ");
		year = keyboard.nextInt();
		
		while (m < 1 || m > 12 || year <= 0)     //check if the date and year are valid and within range
		{
			System.out.print("\nInvalid input! Make sure that the month is within the range of 1-12 and the year is positive.\n"
			          		  + "\nEnter the month (1-12): ");
			m = keyboard.nextInt();
	
			System.out.print("Enter the year: ");
			year = keyboard.nextInt();
		}
		
		c = year / 100;
		y = year % 100;
		
		if (y == 0)               //Check whether the year is a leap year or not 
		{
			if (year >= 400)
			{
				if (year % 400 == 0 && year % 100 == 0 && year % 4 == 0)
				{
					isLeap = true;
				}
			}
		}
		else if (year % 4 == 0)
		{
			isLeap = true;
		}
		
		if (isLeap)               //Figure out month code (Only Jan. and Feb. change month codes) and set number of days for that month
		{
			if (m == 1)
			{
				monthCode = 6;
				days = 31;
				month = "January";
			}
			else if (m == 2)
			{
				monthCode = 2;
				days = 29;
				month = "February";
			}
		}
		else
		{
			if (m == 1)
			{
				monthCode = 0;
				days = 31;
				month = "January";
			}
			else if (m == 2)
			{
				monthCode = 3;
				days = 28;
				month = "February";
			}
		}
		
		if (m == 3)
		{
			monthCode = 3;
			days = 31;
			month = "March";
		}
		else if (m == 4)
		{
			monthCode = 6;
			days = 30;
			month = "April";
		}
		else if (m == 5)
		{
			monthCode = 1;
			days = 31;
			month = "May";
		}
		else if (m == 6)
		{
			monthCode = 4;
			days = 30;
			month = "June";
		}
		else if (m == 7)
		{
			monthCode = 6;
			days = 31;
			month = "July";
		}
		else if (m == 8)
		{
			monthCode = 2;
			days = 31;
			month = "August";
		}
		else if (m == 9)
		{
			monthCode = 5;
			days = 30;
			month = "September";
		}
		else if (m == 10)
		{
			monthCode = 0;
			days = 31;
			month = "October";
		}
		else if (m == 11)
		{
			monthCode = 3;
			days = 30;
			month = "November";
		}
		else if (m == 12)
		{
			monthCode = 5;
			days = 31;
			month = "December";
		}
		
		w = (int) ((Math.floor(5 * y) / 4 + monthCode + d - 2 * (c % 4) + 7) % 7);          //Figure out what day of the week the first day of the specified month lands on
		
		System.out.println("\n\n" + month + " " + year);
		System.out.println("\nSu Mo Tu We Th Fr Sa");
		String printMonth = "";                              //start the first line of the calendar to align the whole month with the correct days
		int i = 1;                                           //counter for while loops
		while (i < w)
		{
			printMonth += "   ";
			i++;
			if (i == 6)
			{
				i = 0;
			}
		}
		
		w++;                                                 //add one to the day of the week for the next day
		printMonth += " 1";
		d++;                                                 //add one to the day since we have printed it already 
		
		while (d <= days)
		{
				if (d < 10)
				{
					if (w != 0)
					{
						printMonth += "  " + d;
					}
					else
					{
						printMonth += " " + d;
					}
				}
				else
				{
					if (w != 0)
					{
						printMonth += " " + d;
					}
					else
					{
						printMonth += d;
					}
					
				}
				d++;
				i++;
				w++;
				if (i == 7)
				{
					i = 0;
					w = 0;
					printMonth += "\n";
				}
		}
		
		System.out.print(printMonth + "\n");
		
		
	}//main
	
}//class Prog2b
