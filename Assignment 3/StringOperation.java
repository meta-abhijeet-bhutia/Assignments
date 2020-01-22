import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringOperation {

	/**
	 * Comparing two strings
	 * @param first first string to be compared
	 * @param second second string to be compared
	 * @return 1 if strings match else 0
	 */
	public int Compare(String first,String second)
	{
		char[] firstStringArray=first.toCharArray();
		char[] secondStringArray=second.toCharArray();
		if(LengthString(firstStringArray)!=LengthString(secondStringArray))
			return 0;
		else
		{
			for(int i=0;i<LengthString(firstStringArray);i++)
			{
				if(firstStringArray[i]!=secondStringArray[i])
					return 0;
			}
		}
		return 1;
	}
	
	/**
	 * Calculating the length of a string
	 * @param first string whose length has to be calculated
	 * @return length of string
	 */
	public int LengthString(char[] first)
	{
		int j=0;
		for(char c:first)
		{
			j++;
		}
		return j;		
	}

	/**
	 * Calculating the reverse of a string
	 * @param first string whose reverse has to be calculated
	 * @return reverse of string
	 */
	public String Reverse(String first)
	{
		String rev="";
		char[] stringArray=first.toCharArray();
		int length=LengthString(stringArray);
		for(int i=length-1;i>=0;i--)
		{
			rev=rev+stringArray[i];
		}
		return rev;
	}
	
	/**
	 * Replacing upper case characters with lower case characters and vice versa
	 * @param first string whose characters have to be swapped with the corresponding lower or upper case characters
	 * @return string with characters having their cases swapped
	 */
	public String ReplaceCase(String first)
	{
		char[] firstStringArray=first.toCharArray();
		int length=LengthString(firstStringArray);
		for(int i=0;i<length;i++)
		{
			if(firstStringArray[i]>='A'&&firstStringArray[i]<='Z')
				firstStringArray[i]=(char)((int)(firstStringArray[i])+32);
			else if(firstStringArray[i]>='a'&&firstStringArray[i]<='z')
				firstStringArray[i]=(char)((int)(firstStringArray[i])-32);
		}
		String replaced="";
		for(char c:firstStringArray)
			replaced=replaced+c;
		return replaced;
	}
	
	/**
	 * Finding the longest word in a string,if multiple words have maximum length find the one which came at last 
	 * @param first string whose longest word have to be found
	 * @return longest word in a string,if multiple words have maximum length return the one which came at last 
	 */
	public String LongestWord(String first)
	{
		String firstWord=first+" ";
		String word="";
		char[] stringArray=firstWord.toCharArray();
		int maxlengthOfWord=0;
		int lengthOfWord;
		String maxWord="";
		for(char c:stringArray)
		{
			if(c!=' ')
				word=word+c;
			else
			{
				System.out.println(word);
				lengthOfWord=LengthString(word.toCharArray());
				if(maxlengthOfWord<=lengthOfWord)
				{
					maxWord=word;
					maxlengthOfWord=lengthOfWord;
				}
				word="";
			}
		}
		return maxWord;
	}

}

class Test
{
	public static void main(String args[])throws IOException
	{
		int choice;
		String first,second;
		StringOperation opt=new StringOperation();
		for(int i=1;i>0;i++)
		{
			System.out.println("Enter\n1. To compare two strings\n2. For reverse\n3. For interchanging the cases\n4. For largest word\n5. To stop");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:System.out.println("Enter first string");
					first=br.readLine();
					System.out.println("Enter second string");
					second=br.readLine();
					int result=opt.Compare(first,second);
					if(result==1)
						System.out.println("The two strings are equal");
					else
						System.out.println("The two strings are not equal");
					break;
					
				case 2:System.out.println("Enter first string");
					first=br.readLine();
					String reverse=opt.Reverse(first);
					System.out.println("The reverse is: "+reverse+"\n");
					break;
				
				case 3:System.out.println("Enter first string");
					first=br.readLine();
					String caseReverse=opt.ReplaceCase(first);
					System.out.println("The new string is: "+caseReverse+"\n");
					break;
				
				case 4:System.out.println("Enter first string");
					first=br.readLine();
					String largestWord=opt.LongestWord(first);
					System.out.println("The largest word is: "+largestWord+"\n");
					break;
				
				case 5:i=-1;
					break;
					
				default:System.out.println("INVALID");	
			}
		}
	}
}
