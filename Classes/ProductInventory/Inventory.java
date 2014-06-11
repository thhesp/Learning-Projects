package ProductInventory;

import java.util.Hashtable;
import java.util.Map.Entry;

public class Inventory {
	
	private Hashtable<Integer, Product> inventory;
	
	public Inventory(){
		inventory = new Hashtable<Integer, Product>();
	}
	
	public void addItemToInventory(int id, String name, float price){
		Product item = new Product(id, name, price, 0);
		inventory.put(id, item);
	}
	
	public void changeItemQuantity(int id, int quantity){
		Product item = inventory.get(id);
		item.setQuantity(quantity);
	}
	
	public Product getItem(int id){
		return inventory.get(id);
	}
	
	public float inventoryValue(){
		float sum = 0;
		for(Entry<Integer, Product> entry : inventory.entrySet()){
			Product item = entry.getValue();
			sum += item.getPrice()*item.getQuantity();
		}
		return sum;
	}
	
	public static void main(String[] argv){
		Inventory inv = new Inventory();
		
		inv.addItemToInventory(0, "Laptop X", 400.00f);
		inv.addItemToInventory(1, "Laptop Y", 299.00f);
		
		inv.changeItemQuantity(0,5);
		inv.changeItemQuantity(1,2);
		
		System.out.println("Value: " + inv.inventoryValue());
	}

}
