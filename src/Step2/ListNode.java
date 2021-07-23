package Step2;

public class ListNode {

    public ListNode next;
    private final Product data;

    // Constructor
    public ListNode(Product data) {
        this.data = data;
        this.next = null;
    }

    // Method for adding products to the LinkedList
    public void add(Product o) {
        if (this.next == null) {
            this.next = new ListNode(o);
        } else {
            this.next.add(o);
        }
    }

    // Getters
    public String getInformation() {
        return data.getProductInformation();
    }

    public ListNode getNext() {
        return next;
    }

    public String getName() {
        return this.data.getName();
    }

    public String getCode() {
        return this.data.getCode();
    }

    public Product getData() {
        return data;
    }


}
