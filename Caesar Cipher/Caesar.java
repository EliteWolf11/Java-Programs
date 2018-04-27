import java.util.Scanner;

public class Caesar{
   public static String decrypt(String message, int cipher) {
		return encrypt(message, -cipher);
	}//end decrypt
	
	public static String encrypt(String message, int cipher) {
      //create an empty string for the encrypted message
      String encrypt = "";
      int i = 0;
      int tempVal = 0;
      char tempChar;
		
      //if cipher < 0
      if(cipher < 0)
      {
         //cipher += 26
         cipher += 26;
      }
      //for each character in the message
      for(i = 0; i < message.length() ; ++i)
      {
         //create an integer representation of the char at the current position
         tempVal = message.charAt(i);
         //if the int represents a capital letter (check ascii chart)
         if(tempVal > 64 && tempVal < 91)
         {
            //add the cipher to the int
            tempVal += (cipher);
            //if the new number is out the range of capital letters, wrap it back, ie. Z+1=A, Z+2=B
            if(tempVal > 90)
            {
               tempVal -= 26;
            }
         }
         //else if the int represents a lower letter (check ascii chart)
         if(tempVal > 96 && tempVal < 123)
         {
            //add the cipher to the int
            tempVal += (cipher);
				//if the new number is out the range of capital letters, wrap it back, ie. z+1=a, z+2=b
            if(tempVal > 122)
            {
               tempVal -= 26;
            }
			}
         //add the char represented by the int to the encrypted message string
         tempChar = (char)tempVal;
         encrypt += tempChar;
      }
      
		return encrypt;
	}//end encrypt method
   
   public static int[] letterDistr(String message) {
		//initialize an int array to hold the number of each letter
		int[] distr = new int[26];
      int i = 0;
      int tempVal = 0;
      char tempChar;
      //for each character in the message
      for(i = 0; i < message.length(); ++i)
      {
         //convert the current char to lowercase then to an int
         tempChar = message.charAt(i);
         if((tempChar > 64) && (tempChar < 91))
         {
            tempChar += 32;
         }
         tempVal = (int)tempChar;
         //if the int represents a lowercase letter (check the ascii chart)
         if((tempVal > 96) && (tempVal < 123))
         {
            //subtract 97 from the int
            tempVal -= 97;
            //add 1 to the int array at that index
            
            distr[tempVal] += 1;
         }
         //return the int array
         
	   }
      return distr;
   }//end letter distribution method
   
	public static void printDistr(int[] distr) {
      //for each element in the array
      int i = 0;
      int j = 0;
      char tempChar = 'a';
      for(i = 0; i < 26; ++i)
      {
         //create a char from the current position (ie. 0=a,1=b,...)
         tempChar = 'a';
         tempChar = (char)(tempChar + i);
			System.out.print(tempChar + ": " + distr[i] + "|");
         //for the number in the array at the current position
         for(j = 0; j < distr[i]; ++j)
         {
            //print an * on the same line
            System.out.print("*");
			}
         //move to the next line
         System.out.println("");
      }
	}//end printDistr
   
}//end class Caersar