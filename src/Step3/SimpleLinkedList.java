package Step3;

public class SimpleLinkedList {


    private ListNode first;
    private ListNode current;
    private ListNode last;

    // Constructor
    public SimpleLinkedList() {
        this.first = null;
        this.current = null;
        this.last = null;
    }

    // Getters
    public ListNode getFirst() {
        return first;
    }

    // ### Methods ###

    // Add Products
    public void addProducts(String productName, String productCode, int stockQuantity) {
        //Creates a new product
        Products newProduct = new Products(productName, productCode, stockQuantity);

        int counter = 0;

        if (this.getFirst() == null) {
            this.first = new ListNode(newProduct);
        }
        ListNode current = this.first;

        // Iterates through current list, checks for products matching code of current input object and increments counter if match is found
        while (current != null) {
            if (current.getProducts().getCode().equals(newProduct.code)) {
                counter++;
            }
            current = current.next;
        }

        // If no products matching newProduct.code are found, new product is added to the system
        if (counter == 0) {
            assert this.first != null;
            this.first.add(newProduct);
        }
    }

    //Display Products
    public void displayProducts() {
        if (this.first == null) {
            System.out.println("No products in the system");
        }
        ListNode current = this.first;

        while (current != null) {
            System.out.println(current.getProducts().getName() + " " + current.getProducts().getCode() + " " + current.getProducts().getStockQuantity());
            current = current.getNext();
        }
    }

    // Delete a Product from linked list
    public void deleteProduct(String code) {
        if (first == null) return;

        if (first.getProducts().getCode().equals(code)) {
            first = first.getNext();
            return;
        }

        ListNode current = first;

        while (current != null) {
            if (current.getNext().getProducts().getCode().equals(code)) {
                current.next = current.next.next;

                return;
            }
            current = current.next;
        }
    }

    // Find if a product exists within the system
    public boolean findProduct(String searchTerm) {
        int counter = 0;
        // If the list contains no Items
        if (first == null) {
            counter = 0;
        }
        ListNode current = first;

        // Logic for finding products from search term and adding them to an Array of positive results
        while (current != null) {
            if (current.getProducts().getCode().equals(searchTerm)) {
                counter++;
            }
            current = current.getNext();
        }

        if (counter > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
