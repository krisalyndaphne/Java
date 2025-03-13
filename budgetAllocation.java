import java.util.Scanner;
import java.util.ArrayList;

public class budgetAllocation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your budget amount:");
        double total = scan.nextDouble();
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        double remainingBudget = total;

        while (remainingBudget > 0) {
            System.out.println("\nRemaining budget: $" + String.format("%.2f", remainingBudget));
            System.out.println("Enter item name (or 'quit' to exit):");
            scan.nextLine(); // Clear buffer
            String item = scan.nextLine();
            
            if (item.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Enter price for " + item + ":");
            double price;
            try {
                price = scan.nextDouble();
                if (price <= 0) {
                    System.out.println("Price must be greater than 0!");
                    continue;
                }
                if (price > remainingBudget) {
                    System.out.println("Price exceeds remaining budget! Cannot add this item.");
                    continue;
                }
                items.add(item);
                prices.add(price);
                remainingBudget -= price;
            } catch (Exception e) {
                System.out.println("Invalid price! Please enter a valid number.");
                scan.nextLine(); // Clear invalid input
                continue;
            }
        }

        // Print summary
        System.out.println("\n=== Budget Summary ===");
        System.out.println("Total Budget: $" + String.format("%.2f", total));
        System.out.println("Items purchased:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + ": $" + String.format("%.2f", prices.get(i)));
        }
        System.out.println("Remaining budget: $" + String.format("%.2f", remainingBudget));
        
        scan.close();
    }
}