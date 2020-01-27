import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap; 
import java.util.Map; 

class ShoppingCart
	{
		public static HashMap<String, Integer> itemNameAndPrice = new HashMap<>(); //Item Name and their Price
		ShoppingCart()
		{
			itemNameAndPrice.put("Silk",100);
			itemNameAndPrice.put("Perk",50);
			itemNameAndPrice.put("KitKat", 30);
		}
		public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
		public static HashMap<String, Integer> cart = new HashMap<>(); // Item Name and Quantity
		public void Add_Item() throws IOException
		{
			String choice="Y";
			while(true)
			{ 
				if(choice.equalsIgnoreCase("Y"))
				{
					System.out.println("Item List:");
					System.out.println("Items\tPrice");
					for (Map.Entry<String,Integer> entry : itemNameAndPrice.entrySet())
					{ 
						if(entry.getValue()>0)
						{
							System.out.println(""+entry.getKey()+"\t"+entry.getValue());
						}
					}
					System.out.println("Enter the item name you wish to add");
					String Item_Name=br.readLine();
					if(itemNameAndPrice.containsKey(Item_Name))
					{
						System.out.println("Enter the quantity");
						int Item_Quantity=Integer.parseInt(br.readLine());
						cart.put(Item_Name,Item_Quantity);
					}
					else
					{
						System.out.println("We don`t have this item currently");
					}
					System.out.println("Do you wish to add more items(Y/N)");
					choice=br.readLine();
				}
				else if(choice.equalsIgnoreCase("N"))
				{
					break;
				}
				else
				{
					System.out.println("Wrong Choice");
				}
			}
	}
	public void Update_Item() throws IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String choice="Y";
			while(true)
			{
				System.out.println("Do you wish to update more items(Y/N)");
				choice=br.readLine(); 
				if(choice.equalsIgnoreCase("Y"))
				{
					System.out.println("Enter the item you want to update");
					String name=br.readLine();
					System.out.println("Enter the updated quantity");
					int temp=Integer.parseInt(br.readLine());
					if (cart.containsKey(name))
					{
						cart.put(name,temp);
					}
				}
				else if(choice.equalsIgnoreCase("N"))
				{
					break;
				}
				else
				{
					System.out.println("Wrong Choice");
				}
			}
	}
	public void Display_Item()
	{
		int amount=0;
		System.out.println("Items\tQuantity\tTotal Price");
			for (Map.Entry<String,Integer> entry : cart.entrySet())
			{ 
				if(entry.getValue()>0)
				{
					System.out.println(""+entry.getKey()+"\t"+entry.getValue()+"\t\t"+itemNameAndPrice.get(entry.getKey())*entry.getValue());
					amount+=itemNameAndPrice.get(entry.getKey())*entry.getValue();
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
