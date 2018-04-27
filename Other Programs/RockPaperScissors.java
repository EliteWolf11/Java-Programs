//import libraries
import java.util.Scanner;
import java.util.Random;

//RockPaperScissors
public class RockPaperScissors
{

   //getUserChoice(Scanner in)
   Scanner in = new Scanner(System.in);
   
   public String getUserChoice(Scanner in)
   {
      String userChoice = "";
      //get user choice of rock, paper, or scissors
      System.out.println("What is your choice? ");
      userChoice = in.next();
      //while choice is invalid
      while(!(userChoice.equalsIgnoreCase("Rock") || userChoice.equalsIgnoreCase("Paper") || userChoice.equalsIgnoreCase("Scissors")))
      {
         System.out.print("That's not a valid input. Try again: ");
         in.nextLine();
         userChoice = in.next();
      }
      //return choice
      return userChoice;
   }
   
   //getCPUChoice(int seed)
   public String getCPUChoice(int seed)
   {
      int tempNumber = 0;
      String cpuChoice = "";
      
      Random rand = new Random();
      rand.setSeed(seed);
      
      tempNumber = rand.nextInt(3);
      
      if(tempNumber == 0)
      {
         cpuChoice = "Rock";
      }
      
      else if(tempNumber == 1)
      {
         cpuChoice = "Paper";
      }
      
      else if(tempNumber == 2)
      {
         cpuChoice = "Scissors";
      }
      
      return cpuChoice;
   }
   
   //pickWinner(String userChoice, String CPUChoice)
   public String pickWinner(String userChoice, String cpuChoice)
   {
      String returnString = "";
      
      if(userChoice.equalsIgnoreCase("Rock") && cpuChoice.equalsIgnoreCase("Scissors"))
      {
         returnString = "User";
      }
      
      else if(userChoice.equalsIgnoreCase("Paper") && cpuChoice.equalsIgnoreCase("Rock"))
      {
         returnString = "User";
      }
      
      else if(userChoice.equalsIgnoreCase("Scissors") && cpuChoice.equalsIgnoreCase("Paper"))
      {
         returnString = "User";
      }
      
      else if(userChoice.equalsIgnoreCase("Rock") && cpuChoice.equalsIgnoreCase("Paper"))
      {
         returnString = "Computer";
      }
      
      else if(userChoice.equalsIgnoreCase("Paper") && cpuChoice.equalsIgnoreCase("Scissors"))
      {
         returnString = "Computer";
      }
      
      else if(userChoice.equalsIgnoreCase("Scissors") && cpuChoice.equalsIgnoreCase("Rock"))
      {
         returnString = "Computer";
      }
      
      else if(userChoice.equalsIgnoreCase(cpuChoice))
      {
         returnString = "Tie";
      }
      
      return returnString;
   }

}