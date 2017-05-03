/*=============================================================================
 |   Assignment:  Program #5 : WordCount
 |       Author:  Kevin Montenegro
 | Sect. Leader:  Wongani Botha
 |
 |       Course:  CSc 227 -- Program Design and Development
 |   Instructor:  L. McCann
 |     Due Date:  February 26th, 2012
 |
 |  Description:  This program counts the number of lines, words, and bytes
 |                in a file or files that the user specifies. 
 |                
 | Deficiencies:  None
 *===========================================================================*/

import java.util.*;          //Gives easy access to Java API's 'util' package
import java.io.*;            //Gives easy access to Java API's 'io' package

public class Prog5 {
	public static void main (String[] args) throws IOException
	{
		String commandLineArgs = "";
		Scanner in = new Scanner(System.in);
		String[] fileNames = null;                          //Split the string wherever there are commas and put the file names into an array
		int numberFiles = 0;                                //How many files were given
		long fileByteSize = 0;                              //How many bytes in the file
		int fileWordCount = 0;                              //How many words in the file
		int fileLineCount = 0;                              //How many lines in the file
		File     fileRef;
        String   fileName = null;
		
		if (args.length > 0) 
		{
            for (int i=0; i<args.length; i++) 
            {
                commandLineArgs += args[i];                 //Put the command line arguments into one string
            }
            
            fileNames = commandLineArgs.split(",");         //Split the string wherever there are commas and put the file names into an array
    		numberFiles = fileNames.length;                 //How many files were given
        } 
		else 
        {
            System.out.println( "\n Usage: java WordCount <arguments>" +
                                "\n This program takes one or more files and counts" +
                                "\n the number of bytes, lines, and words in the specified file(s)." +
                                "\n If multiple files are given, the total number of bytes, lines, and" +
                                "\n words is also given." +
                                "\n\n Please enter one of more file names, comma-separated: ");
            commandLineArgs = in.nextLine();
            fileNames = commandLineArgs.split(",");         //Split the string wherever there are commas and put the file names into an array
    		numberFiles = fileNames.length;                 //How many files were given
    		for (int i = 0; i < fileNames.length; i++)
    		{
    			fileNames[i] = fileNames[i].trim();         //Trim the String to avoid incorrect file names with misplaced spaces
    		}
        }
		
		if (numberFiles == 1)
		{
			
	        
	        fileName = fileNames[0];            //Set file variables, like name and reference
	        fileRef = new File(fileName);
	        
	        if (fileRef.exists())               //Check if the file reference exists, if not, display an error message
	        {
	        	if (fileRef.isFile())           //Check if the file reference is a file, if not, display an error message
	        	{
	        		fileByteSize = countBytes(fileRef);
	        		fileLineCount = countLines(fileRef);
					fileWordCount = countWords(fileRef);	        	
				}
	        	else
	        	{
	        		System.out.println("\nThe file reference \"" + fileName + "\" is not a file.");
	        	}
	        }
	        else
	        {
	        	System.out.println("\nThe file \"" + fileName + "\" does not exist.");
	        }
			printResults(fileName, fileByteSize, fileWordCount, fileLineCount);
		}
		else
		{
			long[] filesByteSize = new long[fileNames.length];      //initialize variables for totals if more than one file
			int[] filesLineCount = new int[fileNames.length];
			int[] filesWordCount = new int[fileNames.length];
			
			for (int i = 0; i < fileNames.length; i++)              //go through each file and count lines, words, and bytes the same way as with a single file, shown above
			{
				fileName = fileNames[i];
				fileRef = new File(fileName);
				
				if (fileRef.exists())
				{
					if (fileRef.isFile())
					{
						filesByteSize[i] = countBytes(fileRef);
						filesLineCount[i] = countLines(fileRef);
						filesWordCount[i] = countWords(fileRef);
					}
					else
					{
						System.out.println("\nThe file reference \"" + fileName + "\" is not a file.");
					}
				}
				else
				{
		        	System.out.println("\nThe file \"" + fileName + "\" does not exist.");
				}
			}
			printResults(fileNames, filesByteSize, filesWordCount, filesLineCount);
		}
	}
	
	/*---------------------------------------------------------------------
    |  Methods:  printResults()
    |
    |  Purpose:  Prints the results of the Word Count program to the console
    |
    |  Pre-condition:  There are results to be displayed, and valid files were given.
    |
    |  Post-condition: Results from the program are displayed onto the console.
    |
    | Parameters:  A String or String array for the file name(s), a long or
    |              long array for the bytes in each file, int or int array
    |              for the number of words in each file, and an int or 
    |              array for the line count of each file.
    |
    |  Returns:  Nothing.
    *-------------------------------------------------------------------*/
	
	public static void printResults(String[] fileNames, long[] bytes, int[] words, int[] lines)
	{
		System.out.println();
		System.out.print("     Lines       Words       Bytes\n");
		System.out.print("----------  ----------  ----------\n");
		
		for (int i = 0; i < fileNames.length; i++)
		{
			System.out.printf("%10d", lines[i]);
		    System.out.print("  ");
		    System.out.printf("%10d", words[i]);
		    System.out.print("  ");
		    System.out.printf("%10d", bytes[i]);
		    
		    System.out.print("  " + fileNames[i] + "\n");
		}
		
	    System.out.println("------------------------------------------------");
	    System.out.printf("%10d", totalWordsOrLines(lines));
	    System.out.print("  ");
	    System.out.printf("%10d", totalWordsOrLines(words));
	    System.out.print("  ");
	    System.out.printf("%10d", totalBytes(bytes));
	    System.out.print("  Totals\n\n");
	}
	
	public static void printResults(String fileName, long bytes, int words, int lines)
	{
		System.out.println();
		System.out.print("     Lines       Words       Bytes\n");
		System.out.print("----------  ----------  ----------\n");
		
	    System.out.printf("%10d", lines);
	    System.out.print("  ");
	    System.out.printf("%10d", words);
	    System.out.print("  ");
	    System.out.printf("%10d", bytes);

	    System.out.print("  " + fileName + "\n\n");
	}

	/*---------------------------------------------------------------------
    |  Methods: countBytes(), countLines(), countWords()
    |
    |  Purpose: Goes through the given file and counts the bytes, lines, 
    |           or words in that file, depending on which method is called.
    |
    |  Pre-condition:  A valid file is given and it is not empty.
    |
    |  Post-condition: The total number of bytes, lines, or words is returned
    |                  and the file is left unchanged.
    |
    |  Parameters: A File reference to the file in question.
    |
    |  Returns:  Total number of bytes, lines, or words, respectively.
    *-------------------------------------------------------------------*/
	
	public static long countBytes(File file)
	{
		long result = file.length();
		return result;
	}
	
	public static int countLines(File file) throws IOException
	{
		LineNumberReader reader = new LineNumberReader(new FileReader(file));
		int result = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {}
		
		result = reader.getLineNumber();
		reader.close();
		return result;
	}
	
	public static int countWords(File file) throws IOException
	{
		int result = 0;
		int index = 0;
		FileReader fr = new FileReader(file);                   //Set up file readers to read the file line by line
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		for (int i = 0; i < countLines(file); i++)             //Go through each line in the file
		{
			boolean prevwhitespace = true;
			while (index < line.length())
			{
				char c = line.charAt(index);
				boolean currwhitespace = Character.isWhitespace(c);
				if (prevwhitespace && !currwhitespace)         //add to the word count if we are at a space where there is no whitespace but the preceding character was a whitespace (ie, the beginning of a word)
				{
					result++;
				}
				prevwhitespace = currwhitespace;
				index++;
			}
			line = br.readLine();
			index = 0;
		}
		
		return result;
	}

	/*---------------------------------------------------------------------
    |  Methods totalBytes(), totalWordsOrLines()
    |
    |  Purpose: Goes through the given array to add the total number of 
    |           bytes, lines, or words for all the files specified by the
    |           user at the beginning of the program.
    |
    |  Pre-condition:  There are multiple files specified and the proper
    |                  arrays with the byte, line, or word counts are given.
    |
    |  Post-condition: The total number of bytes, lines, or words is returned
    |                  and the array is left unchanged.
    |
    |  Parameters: An array of longs or ints, depending on whether bytes, lines
    |              or words are being totaled. Words and Lines use the same method
    |              because they are the same return type.
    |
    |  Returns:  The total number of bytes, words, or lines, respectively.
    *-------------------------------------------------------------------*/
	
	public static long totalBytes(long[] bytes)
	{
		long result = 0;
		
		for (int i = 0; i < bytes.length; i++)
		{
			result += bytes[i];
		}
		
		return result;
	}
	
	public static int totalWordsOrLines(int[] array)
	{
		int result = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			result += array[i];
		}
		
		return result;
	}
}
