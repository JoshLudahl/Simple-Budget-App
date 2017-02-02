package Models;

import Utilities.InterfaceAmount;

public class Income implements InterfaceAmount {
	private String owner;
	private double amount;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Income(String owner, double amount) {
		this.owner = owner;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Income [owner=" + owner + ", amount=$" + amount + "]";
	}

}
