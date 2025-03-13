import java.util.Scanner;

public class investmentEarnings{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the buying price ($): ");
        double buyingPrice = in.nextDouble();
        
        double closingPrice;
        double totalProfit = 0.0;
        double totalLoss = 0.0;
        int days = 1;  // Keep track of the days

        while (true) {
            System.out.print("Enter the closing price for day " + days + " (Enter a negative value to exit): ");
            closingPrice = in.nextDouble();

            if (closingPrice < 0.0) {
                break;
            }

            double earnings = closingPrice - buyingPrice;

            if (earnings > 0) {
                System.out.println("You have made a profit of $" + earnings);
                totalProfit += earnings;
            } else if (earnings < 0) {
                System.out.println("You have a loss of $" + Math.abs(earnings));
                totalLoss += Math.abs(earnings);
            } else {
                System.out.println("No profit, no loss.");
            }

            days++;
        }

        System.out.println("\nTotal Profit: $" + totalProfit);
        System.out.println("Total Loss: $" + totalLoss);

        in.close();
    }
}
