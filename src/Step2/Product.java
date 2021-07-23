package Step2;

public class Product {

    int stockQuantity;
    String code;
    String name;

    // Constructor for Product Objects
    public Product(int stockQuantity, String code, String name) {
        this.stockQuantity = stockQuantity;
        this.code = code;
        this.name = name;
    }

    public String getProductInformation() {
        return "Code: " + this.code + " Name: " + this.name + " Qty: " + this.stockQuantity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
