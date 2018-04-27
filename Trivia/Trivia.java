import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Trivia{
   
   public static void main(String[] args){
      //file names
      String trivia_file = "trivia.txt";
      String score_file = "highscores.txt";
      int score = 0;
      Scanner input = new Scanner(System.in);
      input = ReadWrite.open_file(trivia_file, input);
      
      /*TODO:                                           DONE
      first line of trivia file is the title
      use the welcome method from ReadWrite to display the title*/
      ReadWrite.welcome(ReadWrite.next_line(input));
      
      while (input.hasNextLine()) {
         score = ReadWrite.block(input, score);
      }
      
      System.out.println("That was the last question!");
      System.out.println("Your final score is " + score);
      
      boolean hs = false;
      
      /*TODO:                       DONE
         load high scores
         check to see if user score is >= lowest score
            change hs to true
         You'll need to convert the low score from string to int
      */
      
      String[][] high = new String[5][2];
      high = load_high_score(score_file, input);
      
      int tempInt = Integer.parseInt(high[4][0]);
      
      if(score >= tempInt)
      {
         hs = true;
      } 
      
      input = new Scanner(System.in);
      if(hs){
         System.out.println("You made it on the high score list!");
         //save initials
         String name = name3(input);
         /*TODO:                                                    DONE
            Send initals and score to sortNSave
         */
        
         high = sortNsave(high, name, score, score_file);
                      //doesn't make it to this point
      }
      else{
         System.out.println("You didn't make it on the high score list, better luck next time.");
      }
      System.out.println(hscores(high));
   }//end main

      /*TODO:                                             DONE
         create a String name3 method that has a scanner for the paramater
         prompt the user for their initials (3 characters)
         while length of user input != 3
            ask again
         return their initials in all caps
      */
   public static String name3(Scanner input)
   {
      System.out.println("What are your initials?");
      String userReply = input.next();
      while(userReply.length() != 3)
      {
         input.nextLine();
         System.out.println("What are your initials?");
         userReply = input.next();
      }
      
      userReply = userReply.toUpperCase();
      
      return userReply;
   }
         
      
      /*TODO:                                                        DONE
         craete a String hscore method
         iterate through the high score 2D array
            create a string representation that looks like the following when printed
            ABC: 5 points
            DEF: 4 points
         return the string representation
      */
   public static String hscores(String[][] high)
   {
      String highScores = "";
      int i = 0;
      
      for(i = 0; i < 5; ++i)
      {
         highScores += high[i][1];
         highScores += ": ";
         highScores += high[i][0];
         highScores += " points\n";
      }
      
      return highScores;
   }


   public static String[][] bubble(String[][] high){
      /*TODO:                                                   DONE
       write a bubble sort algorithm
       sort with decending values (highest first, lowest last)
       You'll need to parseInt in order to sort them correctly
      */
      
      int i = 0;
      int[] scores = new int[5];
      String[] values = new String[5];
      boolean inOrder = false;
      int tempValue = 0;
      String tempString = "";
      
      for(i = 0; i < 5; ++i)
      {
         scores[i] = Integer.parseInt(high[i][0]);
      }
      
      for(i = 0; i < 5; ++i)
      {
         values[i] = high[i][1];
      }
      
      
      
      while(!inOrder)
      {
         for(i = 0; i < 4; ++i)
         {
            if(scores[i] < scores[i + 1])
            {
               tempValue = scores[i];
               scores[i] = scores[i + 1];
               scores[i + 1] = tempValue;
               
               tempString = values[i];
               values[i] = values[i + 1];
               values[i + 1] = tempString;
                 
            }
         }
         
         
         
         if((scores[0] > scores[1]) && (scores[1] > scores[2]) && (scores[2] > scores[3]) && (scores[3] > scores[4]))
         {
            for(i = 0; i < 5; ++i)
            {
               high[i][0] = String.valueOf(scores[i]);
               
               high[i][1] = values[i];
            }
            
            inOrder = true;
         }
      }
     
      return high;
   }//end bubble
   
	public static String[][] load_high_score(String	file_name, Scanner input){
		/*TODO                                            DONE
         Finish this method that loads the highscores from a txt file to a 2D array called high
         you'll want to use open_file() and next_line()
      */
      input = ReadWrite.open_file(file_name, input);
      String[][] high = new String[5][2];
      
      high[0][0] = ReadWrite.next_line(input);
      high[0][1] = ReadWrite.next_line(input);
      high[1][0] = ReadWrite.next_line(input);
      high[1][1] = ReadWrite.next_line(input);
      high[2][0] = ReadWrite.next_line(input);
      high[2][1] = ReadWrite.next_line(input);
      high[3][0] = ReadWrite.next_line(input);
      high[3][1] = ReadWrite.next_line(input);
      high[4][0] = ReadWrite.next_line(input);
      high[4][1] = ReadWrite.next_line(input);
      
 		return high;
	}//end high_score
	public static String[][] sortNsave(String[][] high, String name, int	score, String score_file){
		/*TODO:                                                          DONE
      replace last	entry	since	we	already know we beat	it
		   score
         name*/
         
      high[4][0] = String.valueOf(score);
      high[4][1] = name;
      
     
         
		//sort the array
		high = bubble(high);
      
      
		//save new array back to file
		boolean open =	false;
		PrintWriter	toFile =	null;
		try{
			toFile =	new PrintWriter(score_file);
			open = true;
		}
		catch	(FileNotFoundException e) {
			System.out.println("We've run into a problem :(");
			System.out.println("Can't open file"+score_file+" for saving.");
			System.out.println(e);
		}
		if(open){
			for(int i=0;i<high.length;i++){
				for(int j=0;j<2;j++){
					//TODO: write a line of text using the created PrintWriter                                   DONE
               toFile.println(high[i][j]);
				}
			}
         //TODO: save the file                                             DONE
         toFile.close();
		}
      
     
		return high;
	}//end sortNSave
}//end Trivia class