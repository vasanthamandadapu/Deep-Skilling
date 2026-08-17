import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" FINANCIAL FORECASTING SYSTEM");
        System.out.println("====================================");

        // User Input
        System.out.print("Enter Current Investment Value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        // Convert percentage to decimal
        growthRate = growthRate / 100;

        // Recursive Forecast
        double futureValue =
                ForecastCalculator.predictFutureValue(
                        currentValue,
                        growthRate,
                        years);

        // Output
        System.out.println("\n====================================");
        System.out.println(" FORECAST RESULT");
        System.out.println("====================================");

        System.out.println("Current Value : ₹" + currentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.printf("Future Value  : ₹%.2f%n", futureValue);

        // Analysis
        System.out.println("\n====================================");
        System.out.println(" RECURSION ANALYSIS");
        System.out.println("====================================");

        System.out.println("Recursive Calls Made : "
                + ForecastCalculator.recursiveCalls);

        System.out.println("\nTime Complexity:");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(n)");
        System.out.println("Worst Case   : O(n)");

        System.out.println("\nSpace Complexity:");
        System.out.println("O(n)");

        System.out.println("\nOptimization:");
        System.out.println(
                "Using iteration can reduce space complexity "
                + "from O(n) to O(1).");

        sc.close();
    }
}