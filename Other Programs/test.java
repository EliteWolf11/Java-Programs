public class test{
   public static void main(String[] args){
   int[] dice = {2,2,2,2,5};
   System.out.println(print_score(dice));
   }
   public static String print_score(int[] dice)
   {
      int i = 0;
      int j = 0;
      System.out.println("Line 10");
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
      
      if(dice[0] < dice[1])
      {
         if(dice[1] < dice[2])
         {
            if(dice[2] < dice[3])
            {
               
                    
                  score = "Small Straight";
               
            }
         }
      }
      //System.out.println("Line 113");
      if(dice[1] < dice[2])
      {
         if(dice[2] < dice[3])
         {
            if(dice[3] < dice[4])
            {
               
                    
                  score = "Small Straight";
               
            }
         }
      }
      
      if(dice[0] < dice[1])
      {
         if(dice[1] < dice[2])
         {
            if(dice[2] < dice[3])
            {
               if(dice[3] < dice[4])
               {
                  
                  
                     score = "Large Straight";
                  
               }
            }
         }
      }
      //System.out.println("Line 98");
      
      
      //System.out.println("Line 127");
      
      
      
      System.out.println("Line 25");
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 5)
         {
            score = "Yahtzee";
         }
         ++i;
      }
      System.out.println("Line 35");
      
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 4)
         {
            score = "4 of a Kind";
         }
         ++i; 
      }
      System.out.println("Line 46");
      
      i = 0;
      while(i < 6)
      {
         if(diceKinds[i] == 3)
         {
            score = "3 of a Kind";
         }
         ++i;
      }
      System.out.println("Line 57");
      
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
      System.out.println("Line 80");
     
      

      
      return score;
   }
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
   }