import java.util.Scanner;
import java.util.Random;

public class ComputerNumberGuess
{
//global vars
//high = 100
static int high = 100;
//low = 1
static int low = 1;

   //main
   public static void main(String[] args)
   {
      //init vars
      Scanner scnr = new Scanner(System.in);
      
      int theNumber = 0;
      int guess = 0;
      int seed = 0;
      int tries = 6;
      String userResponse = "";
      
      while((theNumber < 1) || (theNumber > 100))
      {
         System.out.println("What is your number?");
         theNumber = scnr.nextInt();
      }
      
      //greet user
      System.out.println("Welcome to the Guess Your Number Game!");
      System.out.println("I have 6 tries to guess what number you're thinking of between 1 and 100.");
      System.out.println("After each guess, tell me if I'm HIGH or LOW.");
      System.out.println("If I guess your number, let me know by typing CORRECT.");
      
      guess = guessRange(low, high, seed);
      
      //guessing loop
      while(!userResponse.equals("correct") || tries > 0)
      {
         System.out.println("My guess is " + guess);
         //prompt for response
         System.out.println("Is my guess high, low, or correct?");
         //get response
         userResponse = scnr.nextLine();
         //call response(user response, computer guess)
         response(userResponse, guess);
         //increment tries
         tries -= 1;
         
         if(high==low){
            guess = high;//keep the program from breaking
         }
         else{
            //get a new guess from guessRange
            guess = guessRange(low, high, seed);
         }
      }
      //branching for displaying win or loose
      
   }
   
   //guessRange(low, high, seed)
   public static int guessRange(int lowest, int highest, int seed)
   {
      Random rand = new Random();
      rand.setSeed(seed);
      int theGuess = rand.nextInt(highest - lowest) + lowest;
      
      return theGuess;
   }
   
   //response(user response, computer guess)
   public static void response(String userResponse, int guess)
   {
      //branching to change global high and low variables based on user response
      if(userResponse.equalsIgnoreCase("high"))
      {
         high = guess - 1;   
      }
      
      else if(userResponse.equalsIgnoreCase("low"))
      {
         low = guess + 1;  
      }
   }
      
}