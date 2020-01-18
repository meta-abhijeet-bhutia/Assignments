import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.Map; 

class Item
	{
		public static HashMap<String, Integer> map1 = new HashMap<>(); //Item Name and their Price
		Item()
		{
			map1.put("Vegetables",100);
			map1.put("Fruits",200);
			map1.put("Furniture", 500);
		}
	}
class ShoppingCart extends Item
	{
		ShoppingCart()
		{
			super();	//Base Class Constructor
		}
		public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
		public static HashMap<String, Integer> cart = new HashMap<>(); // Item Name and Quantity
		public void Add_Item() throws IOException
		{
			System.out.println(map1);
			System.out.println("Enter the item name you wish to add");
			String Item_Name=br.readLine();
			if(map1.containsKey(Item_Name))
			{
				System.out.println("Enter the quantity");
				int Item_Quantity=Integer.parseInt(br.readLine());
				cart.put(Item_Name,Item_Quantity);
			}
			else
			{
				System.out.println("We don`t have this item currently");
			}
			System.out.println("Do you wish to add more items");
			String choice=br.readLine(); 
			if(choice.equals("yes"))
			{
				Add_Item();
			}
	}
	public void Update_Item() throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the item you want to update");
		String name=br.readLine();
		System.out.println("Enter the updated quantity");
		int temp=Integer.parseInt(br.readLine());
		if (cart.containsKey(name))
		{
			cart.put(name,temp);
		}
		System.out.println("Do you wish to update more items");
		String choice=br.readLine();
		if(choice.equals("yes"))
		{
			Update_Item();
		}
	}
	public void Display_Item()
	{
		int amount=0;
		for (Map.Entry<String,Integer> entry : cart.entrySet())
		{ 
			if(entry.getValue()>0)
			{
				System.out.println("Item name = " + entry.getKey() + 
                             ", Item Quantity = " + entry.getValue() + 
                             ", Total Price = "+ map1.get(entry.getKey())*entry.getValue()); 
				amount+=map1.get(entry.getKey())*entry.getValue();
			}
		}
		System.out.println("Total Shopping Cart Amount = " +amount);
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		ShoppingCart c1=new ShoppingCart();
		c1.Add_Item();
		int x=1;
		while(x!=4)
		{
			System.out.println("What do you want?");
			System.out.println("1. Add Item\n2. Update Item\n3. Display Item\n4. Exit");
			x=Integer.parseInt(br.readLine());
			if(x==1)
			{
				c1.Add_Item();
			}
			else if(x==2)
			{
				c1.Update_Item();
			}
			else if(x==3)
			{
				c1.Display_Item();
			}
			else if(x==4)
			{
				System.exit(0);
			}
			else
			{
				System.out.println("Wrong choice");
			}
		}
	}
}