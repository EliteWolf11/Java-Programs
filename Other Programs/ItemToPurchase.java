public class ItemToPurchase
{
   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   
   public ItemToPurchase()
   {
      itemName = "none";
      itemPrice = 0;
      itemQuantity = 0;
   }
   
   public void setName(String nameOfItem)
   {
      itemName = nameOfItem;
   }
   
   public void setPrice(int priceOfItem)
   {
      itemPrice = priceOfItem;
   }
   
   public void setQuantity(int quantityOfItem)
   {
      itemQuantity = quantityOfItem;
   }
   
   public String getName()
   {
      return itemName;
   }
   
   public int getPrice()
   {
      return itemPrice;
   }
   
   public int getQuantity()
   {
      return itemQuantity;
   }
}