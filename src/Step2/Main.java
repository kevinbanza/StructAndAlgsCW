package Step2;

public class Main {

    public static void main(String[] args) {

        String userSelection, searchTerm;
        SimpleLinkedList products = new SimpleLinkedList();

        do {
            System.out.println("1. Add Products");
            System.out.println("2. Display Products");
            System.out.println("3. Find a Product");
            System.out.println("4. Delete a Product");


            userSelection = Input.getString("What would you like to do? >> ");


            switch (userSelection) {

                // Option 0 - Quits the program
                case "0" -> System.out.println("Goodbye!");

                // Option 1 - Add a new Product to the LinkedList
                case "1" -> {
                    int repeat;

                    do {

                        String productName = Input.getString("What is the product name? >> ");
                        String productCode = Input.getString("What is the product code? >> ");
                        int stockQuantity = Input.getInteger("What is the stock quantity? >> ");

                        // functionality to check if Pet Type exists, if it does, insert a new object to the list, if it doesn't, create a new PetType object
                        Product product = new Product(stockQuantity, productCode, productName);
                        products.addProducts(product);

                        repeat = Input.getInteger("Would you like to add another product?");

                    } while (repeat != 0);
                }

                // Option 2 - Display all products in the list
                case "2" -> products.displayProducts(products.getHead());

                // Option 3 - Search for a product and display all products containing specified search term
                case "3" -> {
                    searchTerm = Input.getString("Please Enter Product Name or ID >> ");
                    products.findProduct(searchTerm, products.getHead());
                }

                //Option 4 - Remove a product from the system
                case "4" -> {
                    searchTerm = Input.getString("Enter the Product Code of the Product to be deleted >> ");
                    products.deleteNode(searchTerm);

                }
            }
        } while (!userSelection.equals("0"));
    }
}




