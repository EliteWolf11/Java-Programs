import java.util.Scanner;

public class ShoppingCartPrinter
{
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      
      String nameOfItem = "";
      int priceOfItem = 0;
      int quantityOfItem = 0;
      
      ItemToPurchase itemOne = new ItemToPurchase();
      ItemToPurchase itemTwo = new ItemToPurchase();
      
      System.out.println("Item 1");
      System.out.println("Enter the item name:");
      nameOfItem = scnr.nextLine();
      itemOne.setName(nameOfItem);
      System.out.println("Enter the item price:");
      priceOfItem = scnr.nextInt();
      itemOne.setPrice(priceOfItem);
      System.out.println("Enter the item quantity:");
      quantityOfItem = scnr.nextInt();
      itemOne.setQuantity(quantityOfItem);
      
      scnr.nextLine();
      
      System.out.println("");
      System.out.println("Item 2");
      System.out.println("Enter the item name:");
      nameOfItem = scnr.nextLine();
      itemTwo.setName(nameOfItem);
      System.out.println("Enter the item price:");
      priceOfItem = scnr.nextInt();
      itemTwo.setPrice(priceOfItem);
      System.out.println("Enter the item quantity:");
      quantityOfItem = scnr.nextInt();
      itemTwo.setQuantity(quantityOfItem);
      
      System.out.println("");
      
      System.out.println("TOTAL COST");
      int itemOneTotal = (itemOne.getQuantity() * itemOne.getPrice());
      int itemTwoTotal = (itemTwo.getQuantity() * itemTwo.getPrice());
      System.out.println("" + itemOne.getName() + " " + itemOne.getQuantity() + " @ $" + itemOne.getPrice() + " = $" + itemOneTotal);
      System.out.println("" + itemTwo.getName() + " " + itemTwo.getQuantity() + " @ $" + itemTwo.getPrice() + " = $" + itemTwoTotal);
      System.out.println("");
      
      System.out.println("Total: $" + (itemOneTotal + itemTwoTotal));
      
   }
}