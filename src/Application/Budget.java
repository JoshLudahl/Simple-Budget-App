package Application;

import Models.Expenses;
import Models.Income;
import Utilities.*;
import db.MongoDb;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Budget extends Application {
	ArrayList<Expenses> expense;
	
	
	   public void start(Stage primaryStage) {
		   
	        Button btn = new Button();
	        btn.setText("Show Expenses");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            }
	        });
	        
	        StackPane root = new StackPane();
	        root.getChildren().add(btn);

	        Scene scene = new Scene(root, 300, 250);

	        primaryStage.setTitle("Hello World!");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	public static void main(String[] args) {

		
		double totalIncome = 0;
		double totalExpenses = 0;
		
		MongoDb db = new MongoDb();
		ArrayList<Income> income = new ArrayList<>();
		// enter format of owner, amount
		//income.add(new Income("Josh", 1700));
		income = (ArrayList<Income>) db.getIncomeList();
		
		ArrayList<Expenses> expense = new ArrayList<>();
		// enter format of category, name, amount
		//expense.add(new Expenses("Utilities", "Electric", 110));
		//New Upload
		expense = (ArrayList<Expenses>) db.getExpenseList();

		MathUtils mathy = new MathUtils();
		// totalExpenses = mathy.getExpenses(expense);
		totalExpenses = mathy.getTotal(expense);

		totalIncome = mathy.getTotal(income);

		System.out.println("");
		System.out.println("Income:");
		
		income.forEach(item -> System.out.println(item.toString()));

		System.out.println("");
		System.out.println("Expenses: ");
		

		SortUtils sorter = new SortUtils();
		//expense = sorter.showCategory(expense, "CaR");
		//expense = sorter.sortByName(expense);
		expense = sorter.sortByCategory(expense);
		//expense = sorter.sortByExpenseHigh(expense);
		//expense = sorter.sortByExpenseLow(expense);

		// total expenses
		
		expense.forEach(item -> System.out.println(item.toString()));

		System.out.println("");
		System.out.println("Total Income: $" + totalIncome);
		System.out.println("Total Expenses: $" + totalExpenses);
		System.out.println("____________");
		System.out.println("Income - Expenses: $" + (totalIncome - totalExpenses));
		
		//db.deleteItem("588c1ecb9a9dca2f10409b6e");
		
		GreetingService greetService1 = (a,b) -> System.out.println(a + b);
		greetService1.sayMessage(2,3);
		db.closeMongo();
		launch(args);
	}

	interface GreetingService {
		void sayMessage(int a, int b);
	}
}
