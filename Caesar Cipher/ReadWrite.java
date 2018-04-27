import java.io.*;
import java.util.Scanner;

public class ReadWrite{
	public static String read(Scanner file){
      //create a string to hold the message
      String message = "";
      //get the first line from the file
      message = file.nextLine();
      //while the file has a next line
      while(file.hasNextLine()){
         /*message string += carriage return escape sequence*/
         message += "\r";
         /*message string += newline escape sequence*/
         message += "\n";
         /*message string += next line from the file*/
         message += file.nextLine();
         //that could all be done in one line but takes longer to write out
      }
      file.close();
		return message;
	}//end read
	
	public static Scanner open_file(String	file_name, Scanner input) {
      //try
      try{
         //create a File object based on file_name
         FileInputStream fileByteStream = null;
         fileByteStream = new FileInputStream(file_name);
         //change the Scanner input to read from the File object
         input = new Scanner(fileByteStream);
      }
      //catch if the file isn't found
      catch(Exception e){
         //Display appropriate error message
         System.out.println("We've run into a problem :(");
			System.out.println("Can't open file " + file_name + " for reading.");
      }
         
		return input;
	}//end open_file
   
   public static void write(String file_name, String message){
      //try
      try{
         //create a PrintWriter object based on file_name
         PrintWriter toFile = null;
         try{
            toFile = new PrintWriter(file_name);
         }
         catch(FileNotFoundException ee) {
            System.out.println("Can't open file"+file_name+" for saving.");
			   System.out.println(ee);
         }
         //print the message to the PrintWriter object
         toFile.println(message);
         //close the PrintWriter object
         toFile.close();
         
      } 
      //catch if the file is not found - eventhough java is making a file, so it doesn't need to be there first --stupid java
      catch(Exception e){
        //display appropriate error message
        System.out.println("File was not found.");
      }
   }//end write method
}// end class File