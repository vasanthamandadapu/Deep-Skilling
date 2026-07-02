import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" E-COMMERCE PRODUCT SEARCH SYSTEM");
        System.out.println("====================================");

        System.out.print("Enter Number of Products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        // Input Products
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Product " + (i + 1));

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter Product ID to Search: ");
        int searchId = sc.nextInt();

        // Linear Search
        Product linearResult =
                SearchOperations.linearSearch(products, searchId);

        System.out.println("\n========== LINEAR SEARCH ==========");

        if (linearResult != null) {

            System.out.println("Product Found!");
            linearResult.displayProduct();

        } else {

            System.out.println("Product Not Found!");
        }

        // Binary Search
        Product binaryResult =
                SearchOperations.binarySearch(products, searchId);

        System.out.println("\n========== BINARY SEARCH ==========");

        if (binaryResult != null) {

            System.out.println("Product Found!");
            binaryResult.displayProduct();

        } else {

            System.out.println("Product Not Found!");
        }

        // Comparison Count
        System.out.println("\n====================================");
        System.out.println(" SEARCH COMPARISON RESULTS");
        System.out.println("====================================");

        System.out.println("Linear Search Comparisons : "
                + SearchOperations.linearComparisons);

        System.out.println("Binary Search Comparisons : "
                + SearchOperations.binaryComparisons);

        // Time Complexity Analysis
        System.out.println("\n====================================");
        System.out.println(" TIME COMPLEXITY ANALYSIS");
        System.out.println("====================================");

        System.out.println("\nLinear Search:");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(n)");
        System.out.println("Worst Case   : O(n)");

        System.out.println("\nBinary Search:");
        System.out.println("Best Case    : O(1)");
        System.out.println("Average Case : O(log n)");
        System.out.println("Worst Case   : O(log n)");

        System.out.println("\n====================================");
        System.out.println(" CONCLUSION");
        System.out.println("====================================");

        System.out.println(
                "Binary Search is more efficient for large datasets "
                        + "because it reduces the search space by half "
                        + "during each iteration."
        );

        sc.close();
    }
}