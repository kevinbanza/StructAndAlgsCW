package Step3;

public class Products {


    String name, code;
    int stockQuantity;

    // Constructor
    public Products(String name, String code, int stockQuantity) {
        this.name = name;
        this.code = code;
        this.stockQuantity = stockQuantity;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
