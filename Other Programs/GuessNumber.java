// main
import java.util.Scanner;
import java.util.Random;

public class GuessNumber
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
   
      int lowNumber = 0;
      int highNumber = 0;
      int seed = 0;
      int theNumber = 0;
      int userGuess = 0;
      String answer = "";
      int i = 0;
   //low number first
      System.out.println("What is the low number? ");
      lowNumber = input.nextInt();
   //high number second
      System.out.println("What is the high number? ");
      highNumber = input.nextInt();
      //get the seed
   
      theNumber = genRandNum(lowNumber, highNumber, seed);
   
      for(i = 6; i > 0; --i)
      {
         System.out.println("What is your guess? ");
         userGuess = input.nextInt();
         answer = hiLow(theNumber, userGuess);
         System.out.println(answer);
         if(answer.equals("That's my number!"))
         {
            System.out.println("You won!");
            break;  
         }
         System.out.println("You have " + i + " tries left");
      }
      System.out.println("You are out of guesses.");
      System.out.println("The number was " + theNumber);
   }
// genRandNum(start, end, seed)
   public static int genRandNum(int lowNumber, int highNumber, int seed)
   {
      Random rand = new Random();
      rand.setSeed(seed);
      int theNumber = rand.nextInt(highNumber - lowNumber) + lowNumber;
   
      return theNumber;
   }
// hiLow(correct number, user guess)
   public static String hiLow(int theNumber, int userGuess)
   {
      String answer = "";
      //if correct
      if(userGuess == theNumber)
      {
         answer = "That's my number!";
      }
      //if guess is low
      else if(userGuess < theNumber)
      {
         answer = "Higher...";
      }
      //if guess is high
      else if(userGuess > theNumber)
      {
         answer = "Lower...";
      }
      return answer;
   }
}