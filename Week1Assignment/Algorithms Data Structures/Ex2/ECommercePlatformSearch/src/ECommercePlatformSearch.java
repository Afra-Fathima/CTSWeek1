import java.util.Arrays;

// Product Class
class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

// Search Functions
class Search {
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

// Main Class
public class ECommercePlatformSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Smartwatch", "Electronics"),
            new Product("P005", "Camera", "Photography")
        };

        // Linear Search
        Product foundProduct = Search.linearSearch(products, "P003");
        if (foundProduct != null) {
            System.out.println("Linear Search Found: " + foundProduct);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Sorting products for Binary Search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Binary Search
        foundProduct = Search.binarySearch(products, "P003");
        if (foundProduct != null) {
            System.out.println("Binary Search Found: " + foundProduct);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}
