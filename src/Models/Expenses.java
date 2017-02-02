package Models;


import Utilities.InterfaceAmount;

public class Expenses implements InterfaceAmount {
	private String category;
	private String name;
	private double amount;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Expenses(String category, String name, double amount) {
		this.category = category;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expenses [" + category + ": " + name + " -  $" + String.format( "%.2f", amount ) + "]";
	}

}
