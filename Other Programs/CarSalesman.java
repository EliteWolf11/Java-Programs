/**************************
*Connor Blood
*Get input from user, then do math
*Last Edited: 1/22/18
***************************/

import java.util.Scanner;

public class CarSalesman
{
   public static void main(String[] args)
   {
      //make scanner
      Scanner input = new Scanner(System.in);
      //init values
      int cost = 0;
      double tax = 0.15;
      double total = 0.0;
      double license = 0.10;
      int dealer_prep = 500;
      int dest_charge = 375;
      //greet user
      System.out.println("Welcome to the Car Salesman Program!");
      System.out.print("What is the cost of your chosen car? ");
      //get input
      cost = input.nextInt();
      //new line
      System.out.println();
      //math
      total += cost;
      total += dealer_prep;
      total += dest_charge;
      total += (cost * tax);
      total += (cost * license);
      //display totals
      System.out.println("Tax is 15%: $"+(cost * tax));
      System.out.println("License is 10%: $"+(cost * license));
      System.out.println("Dealer Preparation fee: $"+dealer_prep);
      System.out.println("Destination Charge: $"+dest_charge);
      //new line
      System.out.println();
      //final total
      System.out.println("Your total is: $"+total);
   }//end main method
}//end CarSalesman class