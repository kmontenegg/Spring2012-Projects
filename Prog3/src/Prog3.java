/*=============================================================================
 |   Assignment:  Program #3 : WordHelper
 |       Author:  Kevin Montenegro
 | Sect. Leader:  Wongoni Botha
 |
 |       Course:  CSc 227 -- Program Design and Development
 |   Instructor:  L. McCann
 |     Due Date:  February 7th, 2012
 |
 |  Description:  This program takes a given word and divides it into its
 |                syllables then it applies very simple heuristics to determine
 |                the pronunciation of the word using the WordHelper class.
 |                
 | Deficiencies:  The syllablize() method of the WordHelper class does not
 |                always return the correct syllablized version of the word,
 |                due to character indices being off when '/' characters
 |                are applied. Not enough time was available to correct this.
 *===========================================================================*/

public class Prog3 
{
	public static void main (String[] args)
	{
		WordHelper word;
		
		
		
		
                  /* instantiating new WordHelper object with the
                   * String "A-p-o-l-l-o-n"
                   */

                  //Testing constructor
       System.out.println("Creating new WordHelper with String " +
                   "\"A-p-o-l-l-o-n\"");
       word = new WordHelper("A-p-o-l-l-o-n");
       
       /*testing syllable/pronouncation methods*/

       //Testing getWord()
       System.out.println("getWord() should return: apollon" +
                          "\ngot: " + word.getWord());
       //Testing numberOfSyllables()
       System.out.println("numberOfSyllables() should return: 3" +
                          "\ngot: " + word.numberOfSyllables());
       //Testing syllablize()
       System.out.println("syllablize() should return: a/pol/lon" +
                          "\ngot: " + word.syllablize());
       //Testing pronounce()
       System.out.println("pronounce() should return: ay-pol-lon" +
                          "\ngot: " + word.pronounce());
       
       System.out.println("\n");
       
       
       /* setting state variable to "instantiable" */
       //Testing setWord()
       System.out.println("Setting word to instantiable");
       word.setWord("instantiable");
       System.out.println("getWord() should return: instantiable" +
                          "\ngot: " + word.getWord());
       
               /*testing syllable/pronouncation methods*/

       //Testing numberOfSyllables()
       System.out.println("numberOfSyllables() should return: 3" +
                          "\ngot: " + word.numberOfSyllables());
       //Testing syllablize()
       System.out.println("syllablize() should return: instan/tiab/le" +
                          "\ngot: " + word.syllablize());
       //Testing pronounce()
       System.out.println("pronounce() should return: instan-tiab-le" +
                          "\ngot: " + word.pronounce());
       
       
       System.out.println("\n");
       
       /* setting state variable to "caves" */

       //Testing setWord()
       System.out.println("Setting word to caves");
       word.setWord("caves");
       System.out.println("getWord() should return: caves" +
                          "\ngot: " + word.getWord());

               /*testing syllable/pronouncation methods*/

       //Testing numberOfSyllables()
       System.out.println("numberOfSyllables() should return 2" +
                          "\ngot: " + word.numberOfSyllables());
       //Testing syllablize()
       System.out.println("syllablize() should return: ca/ves" +
                          "\ngot: " + word.syllablize());
       //Testing pronounce()
       System.out.println("pronounce() should return: kay-vez" +
                          "\ngot: " + word.pronounce());
	}

}
