import java.util.HashMap;
import java.util.Map;

// Product Class
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

// Inventory Management System
class InventoryManagementSystemEx {
    private Map<String, Product> inventory;

    public InventoryManagementSystemEx() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

// Main Class
public class InventoryManagementSystem{
    public static void main(String[] args) {
        InventoryManagementSystemEx ims = new InventoryManagementSystemEx();

        Product product1 = new Product("P001", "Laptop", 10, 1200.50);
        Product product2 = new Product("P002", "Smartphone", 25, 300.99);
        Product product3 = new Product("P003", "Tablet", 15, 450.75);

        ims.addProduct(product1);
        ims.addProduct(product2);
        ims.addProduct(product3);

        ims.displayInventory();

        ims.updateProduct("P001", 8, 1150.00);
        ims.deleteProduct("P002");

        ims.displayInventory();
    }
}
