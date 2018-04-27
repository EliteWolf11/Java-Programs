import java.util.Scanner;
//class
public class WordGuess
{
   //main
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      //init vars
      String theWord = "programming";
      char userGuess;
      String finalGuess = "";
      int i = 0;
      boolean guess = true;
      boolean final_guess = true;
      //greet user
      System.out.println("Welcome to the guessing game! Guess until you run out of tries!");
      //guessing loop
      for(i = 5; i>0; --i)
      {
         //user input
         System.out.println("What is your guess? ");
         userGuess = input.next().charAt(0);
         //call charCheck
         guess = charCheck(theWord, userGuess);
         //display if char is in string or not
         if(guess == true)
         {
            System.out.println("" + "'"+userGuess+"'" + " is in the word");  
         }
         
         else
         {
            System.out.println("" + "'"+userGuess + "'" + " is not in the word");  
         }
         
      }   
      //out of guesses - guess word
      System.out.println("You are out of guesses, what is the word? ");
      finalGuess = input.next();
      //display win or lose
      final_guess = wordCheck(theWord, finalGuess);
   }
   //charCheck(word, guess)
   public static boolean charCheck(String theWord, char userGuess)
   {
      boolean guess = true;
      //if char in string
      if(theWord.indexOf(userGuess) > -1)
      {
         //return true
         guess = true;
      }
      //else
      else
      {
         //return false
         guess = false;
      }
      return guess;
   }     
   //wordCheck(word, guess)
   public static boolean wordCheck(String theWord, String finalGuess)
   {
      boolean guess = true;
      //if guess is word
      if(finalGuess.equals(theWord))
      {
         //win
         guess = true;
         System.out.println("You Win!");
      }
      //else
      else
      {
         //lose
         guess = false;
         System.out.println("You lose.");
      }
      return guess;
   }
         
}