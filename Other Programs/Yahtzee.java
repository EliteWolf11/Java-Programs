import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random r = new Random();
      int hold = 0;//number of dice being held
      int rroll = 2;//number of rerolls allowed
      int i = 0;
      int[] diceRoll = new int[5];

      
      //generate the initial dice roll - save it in an int[5]
      for(i = 0; i < 5; ++i)
      {
         diceRoll[i] = r.nextInt(6) + 1;  
      }
      
      System.out.println("The dice fall:");
      //print(print_dice(dice))
      System.out.println(print_dice(diceRoll));
      
      System.out.print("How many dice would you like to hold? ");
      hold = scnr.nextInt();
      
      //keep asking until giving an input that is within range
      while(hold > 5 || hold < 0)
      {
         System.out.print("Please enter a valid number. How many dice would you like to hold? ");
         hold = scnr.nextInt();  
      }
         
      
      while(hold<5&&rroll>0){
         System.out.println("You chose to reroll "+(5-hold)+" dice.");
			for(i=0;i<(5-hold);i++){
			   System.out.print("Which die would you like to reroll? ");
            int temp = scnr.nextInt();
            System.out.println();//newline
            
            //validate dice reroll number
            while(temp > 5 || temp < 0)
            {
               System.out.println("Please choose a valid dice.");
               temp = scnr.nextInt();
            }
           
            //reroll selected die
            diceRoll[temp - 1] = r.nextInt(6) + 1;
                        
         }//end re-roll die selection
         
         rroll -= 1;
      
      if(rroll>0){//only ask if there are rerolls left
         System.out.println("The dice fall:");
		   //print_dice(dice)
		   System.out.println(print_dice(diceRoll));
   		System.out.print("How many dice would you like to hold? ");
   		hold = scnr.nextInt();
         System.out.println();//newline
         }
         
         
      }//end re-roll loop
      
      //final dice display
      System.out.println("The final dice are:");
      //print(print_dice(dice))
      System.out.println(print_dice(diceRoll));
  
      //Display score
      System.out.println("Score:");
      //print(print_score(dice))
      System.out.println(print_score(diceRoll));
      
      scnr.close();
      
   }//end main method


//String print_dice(int[] dice)
   public static String print_dice(int[] diceRoll)
   {
   /*This methos creates a string representation of the dice array seperated by " "
   ie. rep = "1 2 3...", full credit will be given with or without a trailing " "
   */
      String diceString = (diceRoll[0] + " " + diceRoll[1] + " " + diceRoll[2] + " " + diceRoll[3] + " " + diceRoll[4]);
      
      return diceString;
   }
   
//int[] kinds(int[] dice) method
   public static int[] kinds(int[] diceRoll)
   {
   int[] diceKinds = new int[6];
   int j = 0;
   int i = 0;
   /*this method counts the number of unique values and stores them in an int array
   ie 1 3 3 4 6 yields [1,0,2,1,0,1]*/
   
      for(i = 0; i < 5; ++i)
      {
         for(j = 1; j < 7; ++j)
         {
            if(diceRoll[i] == j)
            {
               diceKinds[j - 1] += 1;
            }
         }
      }
   
      return diceKinds;
   
   }
   
//String print_score(int[]dice) method
   public static String print_score(int[] dice)
   {
      int i = 0;
      int j = 0;
      
      String score = "";
      int[] diceKinds = new int[6];
      diceKinds = kinds(dice);
   /*this methiod returns a string representation of the different winning values. The test for this method is worth 7 points.
   possible return values
	      rep = "Yahtzee"; all dice the same value
	      rep = "Large Straight"; all dice in sequential order
	      rep = "Small Straight"; 4 dice in sequential order
	      rep = "4 of a Kind"; 4 dice with the same value
	      rep = "Full House"; 3 dice with the same value and another 2 dice with the same value
	      rep = "3 of a Kind"; 3 dice with the same value
	      rep = "You did not score anything noteworthy."; anything else*/
         
         //Yahtzee
      score = "You did not score anything noteworthy.";
      
      if(diceKinds[0] == 1 && diceKinds[1] == 1 && diceKinds[2] == 1 && diceKinds[3] == 1)
      {
         score = ("Small Straight");  
      }

      if(diceKinds[1] == 1 && diceKinds[2] == 1 && diceKinds[3] == 1 && diceKinds[4] == 1)
      {
         score = ("Small Straight");  
      }
      
      if(diceKinds[2] == 1 && diceKinds[3] == 1 && diceKinds[4] == 1 && diceKinds[5] == 1)
      {
         score = ("Small Straight");  
      }
      
      if(diceKinds[0] == 1 && diceKinds[1] == 1 && diceKinds[2] == 1 && diceKinds[3] == 1 && diceKinds[4] == 1)
      {
         score = ("Large Straight");  
      }
      
      if(diceKinds[1] == 1 && diceKinds[2] == 1 && diceKinds[3] == 1 && diceKinds[4] == 1 && diceKinds[5] == 1)
      {
         score = ("Large Straight");  
      }
         
      
      
      
      
      
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 5)
         {
            score = "Yahtzee";
         }
         ++i;
      }
      
      
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 4)
         {
            score = "4 of a Kind";
         }
         ++i; 
      }
      
      
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 3)
         {
            score = "3 of a Kind";
         }
         ++i;
      }
      
      
      i = 0;
      while(i < 6)
      {
         if((diceKinds[i] == 2))
         {
            j = 0;
            for(j = 0; j < 6; ++j)
            {
               if(diceKinds[j] == 3)
               {
                  score = "Full House";
                 
               }
               
               
            }
            
            
         }
         ++i;
      }
      
     
      

      
      return score;
   }
      
}//end class Main