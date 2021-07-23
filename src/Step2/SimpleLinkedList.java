package Step2;

import java.util.ArrayList;

public class SimpleLinkedList {

    private ListNode head;

    // Constructor
    public SimpleLinkedList() {
        this.head = null;
    }

    // Gets the first item in the list
    public ListNode getHead() {
        return head;
    }

    // Adds new product to LinkedList if it doesn't already exist in the system
    public void addProducts(Product o) {
        int counter = 0;

        if (head == null) {
            head = new ListNode(o);
        }

        ListNode current = head;

        // Iterates through current list, checks for products matching code of current input object and increments counter if match is found
        while (current != null) {
            if (current.getCode().equals(o.code)) {
                counter++;
            }
            current = current.next;
        }

        // If no products matching o.code are found, new product is added to the system
        if (counter == 0) {
            head.add(o);
        }
        // If duplicate product exists, message is displayed
        else {
            System.out.println("Product already in the system");
        }
    }

    // Display all elements within the list
    public void displayProducts(ListNode head) {
        if (head == null) {
            System.out.println("No products in the system");
            return;
        }
        ListNode current = head;

        while (current != null) {
            System.out.println(current.getInformation());
            current = current.getNext();
        }
    }

    // Find if a product exists within the system
    public void findProduct(String searchTerm, ListNode head) {

        ArrayList<Product> searchResults = new ArrayList<>(); // Holds all positive results from search

        // If the list contains no Items
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode current = head;

        // Logic for finding products from search term and adding them to an Array of positive results
        while (current != null) {
            if (current.getName().equals(searchTerm) || current.getCode().equals(searchTerm)) {
                searchResults.add(current.getData());
            }
            current = current.getNext();
        }

        // ### Output ###
        // If search returned no results
        if (searchResults.size() == 0) {
            System.out.println("No products found...");
        }
        // If search returned results, output all results that were stored in the Array
        else {
            for (Product searchResult : searchResults) {
                System.out.println(searchResult.getProductInformation());
            }
        }
    }

    // Delete a node from the LinkedList
    public void deleteNode(String code) {
        if (head == null) return;

        if (head.getCode().equals(code)) {
            head = head.getNext();
            return;
        }

        ListNode current = head;

        while (current != null) {
            if (current.getNext().getCode().equals(code)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}


