
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import java.text.MessageFormat;
public class Deliverable1 {

	public static void main(String[] args) {
		int sodaStock = 100;
		int sodaRestock = 40;
		int chipsStock = 40;
		int chipsRestock = 20;
		int candyStock = 60;
		int candyRestock = 40;
		List<String> needsRestocking = new ArrayList<>();
		Integer amountEntered;
		String amountLeftMessage = "";
		String needsRestockingMessage = "Nothing needs to be restocked";
		boolean isValidNumber = false;
		String inValidNumberMessage = "Valid number not entered.";
		String amountTooLargeMessage = "That value is too high. Stock not adjusted";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the restocking tool.");
		// Soda Loop
		do {
			System.out.print(String.format("How many Sodas have been sold today? %d are in stock: ", sodaStock));
			isValidNumber = scanner.hasNextInt();
			if (!isValidNumber) {
				System.out.println(inValidNumberMessage);
				scanner.nextLine();
				continue;
			}
			amountEntered = scanner.nextInt();
			scanner.nextLine();
			if (amountEntered > sodaStock) {
				System.out.println(amountTooLargeMessage);
				break;
			}
			
			sodaStock -= amountEntered;
			if (sodaStock < sodaRestock) {
				needsRestocking.add("Soda");
			}
			amountLeftMessage = MessageFormat.format("There are {0} Sodas left",sodaStock);
			System.out.println(amountLeftMessage);
		} while (!isValidNumber);

		// Chips Loop
		do {
			System.out.print(String.format("How many Chips have been sold today? %d are in stock: ", chipsStock));
			isValidNumber = scanner.hasNextInt();
			if (!isValidNumber) {
				System.out.println(inValidNumberMessage);
				scanner.nextLine();
				continue;
			}
			amountEntered = scanner.nextInt();
			scanner.nextLine();
			if (amountEntered > chipsStock) {
				System.out.println(amountTooLargeMessage);
				break;
			}
			
			chipsStock -= amountEntered;
			if (chipsStock < chipsRestock) {
				needsRestocking.add("Chips");
			}
			amountLeftMessage = MessageFormat.format("There are {0} Chips left",chipsStock);
			System.out.println(amountLeftMessage);
		} while (!isValidNumber);
		
		// Candy Loop
		do {
			System.out.print(String.format("How many Candies have been sold today? %d are in stock: ", candyStock));
			isValidNumber = scanner.hasNextInt();
			if (!isValidNumber) {
				System.out.println(inValidNumberMessage);
				scanner.nextLine();
				continue;
			}
			amountEntered = scanner.nextInt();
			scanner.nextLine();
			if (amountEntered > candyStock) {
				System.out.println(amountTooLargeMessage);
				break;
			}
			
			candyStock -= amountEntered;
			if (candyStock < candyRestock) {
				needsRestocking.add("Candy");
			}
			amountLeftMessage = MessageFormat.format("There are {0} Candies left",candyStock);
			System.out.println(amountLeftMessage);
		} while (!isValidNumber);
		
		scanner.close();
		
		System.out.println("Thank you for filling out the values. Here’s what needs to be restocked.");
		if (needsRestocking.size() > 0) {
			needsRestockingMessage = "";
			for (int i = 0; i < needsRestocking.size(); i++) {
				if (i != needsRestocking.size() - 1) needsRestockingMessage += needsRestocking.get(i) + ", ";
				else needsRestockingMessage += needsRestocking.get(i);
			}
			
			needsRestockingMessage += " needs to be restocked";
		}
		
		System.out.println(needsRestockingMessage);
		System.out.println("Goodbye!");
	}
}
