package Step3;

public class ListNode {

    ListNode next;
    Products products;

    // Constructor
    public ListNode(Products products) {
       this.products = products;
       this.next = null;
    }

    // Getters
    public ListNode getNext() {
        return next;
    }

    public Products getProducts() {
        return products;
    }

    // Methods
    // Add - For adding products to the LinkedList
    public void add(Products o) {
        if (this.next == null) {
            this.next = new ListNode(o);
        } else {
            this.next.add(o);
        }
    }
}
