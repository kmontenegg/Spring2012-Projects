/*+----------------------------------------------------------------------
 ||  Class WordHelper
 ||
 ||         Author:  Kevin Montenegro
 ||
 ||        Purpose:  
 ||
 ||
 ||  Inherits From:  None.
 ||
 ||     Interfaces:  None.
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  None.
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  WordHelper (String)
 ||
 ||  Class Methods:  String   translateSyllable (String)
 ||
 ||  Inst. Methods:  String   getWord ()
 ||                  void     setWord (String)
 ||                  int      numberOfSyllables ()
 ||                  String   syllablize ()
 ||                  String   pronounce ()
 ||
 ++-----------------------------------------------------------------------*/
import java.lang.StringBuilder;           //
class WordHelper {

	         /* Instance Variables */
	
	private int numberOfSyllables;        //Number of syllables in the word
	private String word,                  //The word being phonetically pronounced
	               syllablizedWord;       //The word divided into syllables        
	
       /*---------------------------------------------------------------------
       |  Method WordHelper (constructors)
       |
       |  Purpose:  One way for WordHelper objects to be created. The 
       |            constructor takes the String parameter given and builds
       |            a Word out of it, ignoring all non-letter characters given
       |            and converting all to lower-case.
       |
       |  Pre-condition:  None.
       |
       |  Post-condition: Valid words are constructed.
       |
       |  Parameters: The String parameter is the string from which the word
       |              will be constructed.
       |
       |  Returns:  A new WordHelper object.
       *-------------------------------------------------------------------*/
	
	public WordHelper (String word)
	{
		this.word = word.replaceAll("[^\\p{L}]", "").toLowerCase();          //the 'this' keyword references the current object. This removes all non-alpha characters
	}
	
	
	
	
	   /*---------------------------------------------------------------------
       |  Methods:  getWord(), setWord()
       |
       |  Purpose:  Permits the programmer to access the word being syllabized
       |            or adjust the word to be syllabized.
       |
       |  Pre-condition:  None.
       |
       |  Post-condition: In the case of the getters, the component is
       |                  returned and is unchanged. For the setters, the
       |                  component is changed to match the value of the 
       |                  argument.
       |
       | Parameters:  None for getters; an appropriate String for the setter.
       |
       |  Returns:  The appropriate word from the getters; nothing from 
       |            setters.
       *-------------------------------------------------------------------*/
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String newWord)
	{
		word = newWord.replaceAll("[^\\p{L}]", "").toLowerCase();
	}
	
	
	   /*---------------------------------------------------------------------
       |  Method numberOfSyllables()
       |
       |  Purpose:  Returns an estimate of the number of syllables in the word.
       |
       |  Pre-condition:  There is a word and it has at least one vowel.
       |
       |  Post-condition: The estimate is returned and the word is unchanged.
       |
       |  Parameters: None.
       |
       |  Returns:  The estimate of the number of syllables in the word.
       *-------------------------------------------------------------------*/
	
	public int numberOfSyllables()
	{
		int result = 0;
		
		for (int i = 0; i < word.length(); i++)           //first run: count the vowels and add to the result for each one
		{
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y')
			{
				result++;
				//System.out.println("Found a vowel: " + word.charAt(i) + "\t Syllables so far: " + result);
			}
		}
		
		int j = 0;
		while (j < word.length()-1)                       //second run: count the pairs of vowels and subtract from the result for each
		{
			if (   word.charAt(j) == 'a' && word.charAt(j+1) == 'a' 
				|| word.charAt(j) == 'a' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'a' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'a' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'a' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'a' && word.charAt(j+1) == 'y'
				
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'a'
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'e' && word.charAt(j+1) == 'y'
				
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'a'
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'i' && word.charAt(j+1) == 'y'
				
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'a'
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'o' && word.charAt(j+1) == 'y'
				
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'a'
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'u' && word.charAt(j+1) == 'y'
				
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'a'
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'e'
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'i'
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'o'
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'u'
				|| word.charAt(j) == 'y' && word.charAt(j+1) == 'y')
			{
				result--;
				//System.out.println("Found a pair: " + word.charAt(j) + "" + word.charAt(j+1) + "\t Syllables so far: " + result);
			}
			j++;
		}
		
		//third run: subtract one from the result if the last letter in the word is a vowel
		if (word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'u' || word.charAt(word.length() - 1) == 'y')
		{
			result--;
			//System.out.println("Last letter is a vowel: " + word.charAt(word.length()-1) + "\t Syllables so far: " + result);
		}
		
		return result;
	}

	
	   /*---------------------------------------------------------------------
       |  Method syllablize()
       |
       |  Purpose: Examines the word, applies some very simple heuristics to
       |           try to identify the syllables within the word, and returns
       |           a String reference to a 'divided' version of the word.
       |
       |  Pre-condition:  There is a word and it has at least one syllable.
       |
       |  Post-condition: The divided version of the word is returned and
       |                  the word itself is left unchanged.
       |
       |  Parameters: None.
       |
       |  Returns:  The divided version of the word.
       *-------------------------------------------------------------------*/
	
	public String syllablize()
	{
		if (numberOfSyllables() > 1)
		{
			String newRep = "";              //represent the word in c's and v's
			for (int i = 0; i < word.length(); i++)
			{
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' || word.charAt(i) == 'y')
				{
					newRep += "v";
				}
				else
				{
					newRep += "c";
				}
			}
			//System.out.println("'" + word + "' is: " + newRep);
			
			StringBuilder divWordVCV = new StringBuilder(word);      //word divided with VCV pattern
			StringBuilder divWordVCCV = new StringBuilder(word);     //word divided with VCCV pattern
			StringBuilder divWord = new StringBuilder(word);         //word divided with both patterns combined
			for (int j = 0; j < word.length()-2; j++)                //look for vcv pattern first
			{
				if (newRep.charAt(j) == 'v' && newRep.charAt(j+1) == 'c' && newRep.charAt(j+2) == 'v')
				{
					divWordVCV.insert(j+1, '/');                     //insert '/' right before the consonant
				}
			}
			//System.out.println("'" + word + "' VCV pattern: " + divWordVCV.toString());
			for (int k = 0; k < word.length()-3; k++)                //look for vccv pattern
			{
				if (newRep.charAt(k) == 'v' && newRep.charAt(k+1) == 'c' && newRep.charAt(k+2) == 'c' && newRep.charAt(k+3) == 'v')
				{
					divWordVCCV.insert(k+2, '/');                    //insert '/' right in the middle
				}
			}
			//System.out.println("'" + word + "' VCCV pattern: " + divWordVCCV.toString());
			
			if (!divWordVCV.toString().contains("/"))
			{
				syllablizedWord = divWordVCCV.toString();
			}
			else if (!divWordVCCV.toString().contains("/"))
			{
				syllablizedWord = divWordVCV.toString();
			}
			else
			{
				for (int i = divWord.length()-1; i >= 0; i--)
				{
					if (divWordVCV.charAt(i) == '/' || divWordVCCV.charAt(i) == '/')
					{
						divWord.insert(divWord.length()-i-2, '/');
						//System.out.println(divWord.toString());
					}
				}
				syllablizedWord = divWord.toString();
			}

			return syllablizedWord;
		}
		else
		{
			return word;
		}
		
		
		
		
	}


	   /*---------------------------------------------------------------------
       |  Method pronounce()
       |
       |  Purpose: Examines the syllablized version of the word, one syllable
       |           at a time, and returns a string representing its phonetic
       |           equivalent. Slashes are replaced with hyphens.
       |
       |  Pre-condition:  There is a word and it has at least one syllable.
       |
       |  Post-condition: The phonetic version of the word is returned,
       |                  and the word is left unchanged.
       |
       |  Parameters: None.
       |
       |  Returns: The phonetic equivalent of the word.
       *-------------------------------------------------------------------*/
	
	
	public String pronounce()
	{
		String phoneticWord = "";
		int firstIndex = 0, nextSlash = 0;
		boolean endOfWord = false;
		
		if (syllablizedWord.contains("/"))
		{
			nextSlash = syllablizedWord.indexOf('/');
			while (nextSlash < syllablizedWord.length())
			{
				if (endOfWord)
				{
					phoneticWord += translateSyllable(syllablizedWord.substring(firstIndex, syllablizedWord.length()));
					break;
				}
				else
				{
					phoneticWord += translateSyllable(syllablizedWord.substring(firstIndex, nextSlash));
				}
				
				if (!endOfWord)
				{
					phoneticWord += "-";
				}
				firstIndex = nextSlash+1;
				nextSlash = syllablizedWord.indexOf('/', firstIndex);
				if (syllablizedWord.indexOf('/', firstIndex) == -1)
				{
					nextSlash = syllablizedWord.length()-1;
					endOfWord = true;
				}
			}
		}
		else
		{
			phoneticWord = translateSyllable(syllablizedWord);
		}
		
		return phoneticWord;
	}
	
	   /*---------------------------------------------------------------------
       |  Method translateSyllable()
       |
       |  Purpose: Given a syllable, the method determines and returns the
       |           phonetic version of that syllable
       |
       |  Pre-condition:  There is a syllable provided in the parameter.
       |
       |  Post-condition: The phonetic conversion of the given syllable is
       |                  returned and the word is left unchanged.
       |
       |  Parameters: An appropriate String for the syllable.
       |
       |  Returns:  The phonetic version of the syllable.
       *-------------------------------------------------------------------*/

	
	private String translateSyllable(String syllable)
	{
		StringBuilder phoneticSyllable = new StringBuilder(syllable);
		if (syllable.endsWith("o"))                       //Check the end of the syllable and apply conversions
		{
			phoneticSyllable.replace(phoneticSyllable.length()-1, phoneticSyllable.length(), "oh");
		}
		else if (syllable.endsWith("i"))
		{
			phoneticSyllable.replace(phoneticSyllable.length()-1, phoneticSyllable.length(), "ee");
		}
		else if (syllable.endsWith("a"))
		{
			phoneticSyllable.replace(phoneticSyllable.length()-1, phoneticSyllable.length(), "ay");
		}
		else if (syllable.endsWith("ce"))
		{
			phoneticSyllable.replace(phoneticSyllable.length()-2, phoneticSyllable.length(), "ss");
		}
		else if (syllable.endsWith("es"))
		{
			phoneticSyllable.replace(phoneticSyllable.length()-2, phoneticSyllable.length(), "ez");
		}
		else if (syllable.endsWith("vy"))
		{
			phoneticSyllable.replace(phoneticSyllable.length()-2, phoneticSyllable.length(), "vee");
		}
		
		//Check the remaining modified syllable and apply final conversions
		if (phoneticSyllable.toString().contains("cc"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("cc", "k"));
		}
		if (phoneticSyllable.toString().contains("ca"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("ca", "ka"));
		}
		if (phoneticSyllable.toString().contains("co"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("co", "ko"));
		}
		if (phoneticSyllable.toString().contains("au"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("au", "aw"));
		}
		if (phoneticSyllable.toString().contains("ea"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("ea", "ee"));
		}
		if (phoneticSyllable.toString().contains("qu"))
		{
			phoneticSyllable = new StringBuilder(phoneticSyllable.toString().replaceAll("qu", "kw"));
		}
		
		return phoneticSyllable.toString();
	}
}
