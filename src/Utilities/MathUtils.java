package Utilities;

import java.util.List;

public class MathUtils {
	
	private double amount;
	
	public <T extends InterfaceAmount> double getTotal(List<T> list) {
		amount = 0;
		list.forEach(item -> amount += item.getAmount());
		return amount;
		
	}
	
}
