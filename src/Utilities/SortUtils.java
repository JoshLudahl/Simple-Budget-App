package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Expenses;

public class SortUtils {

	public ArrayList<Expenses> sortByCategory(ArrayList<Expenses> ex) {

		ex.sort((a,b) -> a.getCategory().toUpperCase().compareTo(b.getCategory().toUpperCase()));
		return ex;
	}

	// sort by 'expense'
	public ArrayList<Expenses> sortByName(ArrayList<Expenses> ex) {
		ex.sort((a,b) -> a.getName().toUpperCase().compareTo(b.getName().toUpperCase()));
		return ex;
	}


	// sort by expense highest to lowest (STREAM)
	public ArrayList<Expenses> sortByExpenseHigh(ArrayList<Expenses> ex) {
		ex.sort((a, b) -> (int) (b.getAmount()-a.getAmount())); 
		return ex;
	}
	
	//sort by expense lowest to highest
	public ArrayList<Expenses> sortByExpenseLow(ArrayList<Expenses> ex) {
		ex.sort((a, b) -> (int) (a.getAmount() - b.getAmount()));
		return ex;
	}
	
	public ArrayList<Expenses> showCategory(ArrayList<Expenses> ex, String category) {
		List<Expenses> ex2 = ex.stream().filter(s -> s.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		return (ArrayList<Expenses>) ex2;
	}
	
	
}
