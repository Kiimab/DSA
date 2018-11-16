package shoppingList;

public class Item 
{
	String name;
	String brand;
	double amount;
	double estPrice;

	public Item(String name, String brand, double amount, double estPrice) 
	{
		this.name = name;
		this.brand = brand;
		this.amount = amount;
		this.estPrice = estPrice;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String b)
	{
		brand = b;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(int a)
	{
		amount = a;
	}
	public double getEstPrice()
	{
		return estPrice;
	}
	public void setEstPrice(double d)
	{
		estPrice = d;
	}
	public String toString() {
		return new String("Name: " + name + "\tBrand: " + brand + "\tAmount: " + amount + "\tEstimated Price: " + estPrice);
	}
}