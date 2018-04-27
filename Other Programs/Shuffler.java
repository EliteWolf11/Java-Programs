import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//class
public class Shuffler
{
   ArrayList<String> origList = new ArrayList<String>();
   ArrayList<String> newList = new ArrayList<String>();
   //main
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> origList = new ArrayList<String>();
      
      //init vars
      String userString = "";
      String answer = "";
      int seed = 0;
      int i = 0;
      //greet user
      System.out.println("What is your word?");
      //get first word
      userString = scnr.nextLine();
      origList.add(new String(userString));
      //while user wants another word
      System.out.println("Do you want another word?");
      answer = scnr.nextLine();
      while(answer.equalsIgnoreCase("yes"))
      {
         //get next word
         System.out.println("What is your word?");
         userString = scnr.nextLine();
         origList.add(new String(userString));
         //ask another?
         System.out.println("Do you want another word?");
         answer = scnr.nextLine();
      }
      //display list
      for(i = 0; i > origList.size(); ++i)
      {
         System.out.println(origList.get(i));  
      }
      //shuffle method call
      shuffleList(origList, seed);
      //display shuffled list
      System.out.println(origList);
      
   }
   //shuffleList
   public static ArrayList<String> shuffleList(ArrayList<String> origList, int seed)
   {
      //init vars
      String addElement = "";
      
      ArrayList<String> newList = new ArrayList<String>();
      
      int randNum = 0;
      Random rand = new Random();
      //shuffle loop
      while(!origList.isEmpty())
      {
         randNum = rand.nextInt(origList.size());
         addElement = origList.get(randNum);
         origList.remove(randNum);
         newList.add(addElement);
      }
      //return
      return newList;
   }
}