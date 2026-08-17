public class SearchOperations {

    // Comparison Counters
    public static int linearComparisons = 0;
    public static int binaryComparisons = 0;

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {

        linearComparisons = 0;

        for (Product product : products) {

            linearComparisons++;

            if (product.productId == targetId) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId) {

        binaryComparisons = 0;

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            binaryComparisons++;

            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }

            if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}