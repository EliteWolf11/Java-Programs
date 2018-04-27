/**************************
*Connor Blood
*Counts from given numbers
*Last Edited: 1/26/18
***************************/

import java.util.Scanner;

public class Counter
{
   public static void main(String[] args)
      {
      //make scanner
      Scanner input = new Scanner(System.in);
      //init vars
      int start_val = 0;
      int end_val = 0;
      int step_val = 0;
      //greet the user
      System.out.println("Welcome to the Counter Program!");
      //prompt for input x3
      //save input x3
      System.out.print("What is the starting value? ");
      start_val = input.nextInt();
      System.out.println();
      System.out.print("What is the ending value? ");
      end_val = input.nextInt();
      System.out.println();
      System.out.print("What is the counting increment? ");
      step_val = input.nextInt();
      System.out.println();
      //call counter method
      counter(start_val, end_val, step_val);
      }//end main
   //counter
   public static void counter(int start_val, int end_val, int step_val)
   {
      //for
      for(int i = start_val;i <= end_val;i += step_val)
      {
         //show count
         System.out.print(i + " ");
      }//end for loop
   }//end counter method
}//end class