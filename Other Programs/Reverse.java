import java.util.Scanner;

//class
public class Reverse
{
   //main
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String origString = "";
      String newString = "";
      //get message
      origString = input.nextLine();
      //call reverse
      newString = reverse(origString);
      //print reversed
      System.out.println(newString);
   }//end main
   // reversing method called 'reverse'
   public static String reverse(String origString)
   {
      //do the reversing
      int i = 0;
      String newString = "";
      for(i = origString.length(); i > 0; --i)
      {
         newString = newString.concat(origString.substring(i - 1, i));
      }
      return newString;
   }//end reverse
}//end class