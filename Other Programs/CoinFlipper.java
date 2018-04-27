/***********************
*Connor Blood
*Flips coin with random outcome
*Last Edited: 1/24/18
************************/

import java.util.Scanner;
import java.util.Random;

public class CoinFlipper
{
   public static void main(String[] args)
   {
      //make scanner
      Scanner input = new Scanner(System.in);
      //init vars
      int nFlips = 0;
      int seed = 0;
      int heads = 0;
      int tails = 0;
      //greet user
      System.out.println("Welcome to the Coin Flipper Program!");
      //prompt for number of flips
      System.out.print("How many flips would you like to do? ");
      //save nFlips
      nFlips = input.nextInt();
      //new line
      System.out.println();
      //get heads from flipper, seed = 0
      heads = flipper(nFlips, seed);
      //get the number of tails
      tails = nFlips-heads;
      //display total heads and tails
      System.out.println("You got "+heads+" heads.");
      System.out.println("You got "+tails+" tails.");
   }//end main
   
   public static int flipper(int nFlips, int seed)
   {
      Random rand = new Random();
      //init vars
      int heads = 0;
      int count = 0;
      int coin = 0;
      rand.setSeed(seed);
      //generate a random number
      coin = rand.nextInt(2);
      //while 
      while (count < nFlips)
      {
         //increment counter
         count ++;
         //if
         if (coin == 0)
         {
            //increment heads
            heads++;
         }//end if
         //flip coin again
         coin = rand.nextInt(2);
      }//end while
      //return number of heads
      return heads;
   }//end flipper
}//end class