package Step3;

public class Main {

    public static void main(String[] args) {

        String userSelection, petName;
        Tree tree = new Tree();

        do {

            // ### User Menu ###
            System.out.println("--------------------");
            System.out.println("[1] Add a new Pet");
            System.out.println("[2] Add new product for specified pet type");
            System.out.println("[3] Search for a Pet Type");
            System.out.println("[4] Display all pets types");
            System.out.println("[5] Display all products for a specific pet type");
            System.out.println("[6] Display all product details for all pets");
            System.out.println("[7] Remove a particular product for a specified pet");
            System.out.println("[8] Remove a pet type from the system");
            System.out.println("[0] Exit");
            System.out.println("--------------------");
            System.out.println("\n");
            userSelection = Input.getString("What would you like to do? >>");

            switch (userSelection) {

                // Quit Program
                case "0" -> System.out.println("Goodbye!");

                // Add a new Pet Type
                case "1" -> {
                    petName = Input.getString("Please Enter Name of Pet Type >> ");

                    if (tree.insert(petName)) {
                        System.out.println("Pet Has Been Added to the System!");
                    } else {
                        System.out.println("Pet Type Already in the System.");
                    }
                }

                // Add products for a specific pet type
                case "2" -> {
                    petName = Input.getString("Please Enter Pet Type You Would Like to Add Products For >> ");

                    if (tree.find(petName)) {
                        String productName = Input.getString("Enter Product Name: ");
                        String productCode = Input.getString("Enter Product Code: ");
                        int stockQuantity = Input.getInteger("Enter Stock Quantity: ");

                        tree.getNode(petName, tree.root).getPetObject().getProducts().addProducts(productName, productCode, stockQuantity);
                    } else {
                        System.out.println("Pet Type Not Found");
                    }

                }

                // Find if the company stocks products for a particular pet type
                case "3" -> {
                    petName = Input.getString("Enter Pet Type You Would Like to Search For >> ");

                    if (tree.find(petName)) {
                        System.out.println("We DO stock products for " + petName + "'s");
                    } else {
                        System.out.println("We DON'T stock products for " + petName + "'s");
                    }
                }

                // Display all types of pets that the company provides products for
                case "4" -> tree.inorder();

                // Display all products stocked for a specific pet type
                case "5" -> {
                    petName = Input.getString("Enter Pet Type You Would Like to View Products For >> ");

                    if (tree.find(petName)){
                        tree.getNode(petName, tree.root).getPetObject().getProducts().displayProducts();
                    }
                    else {
                        System.out.println("Pet Does not Exist");
                    }
                }

                // Display all products for all pets
                case "6" -> tree.outputAllProducts();

                // Remove a particular product
                case "7" -> {
                    petName = Input.getString("Enter Pet Type of the Product >> ");
                    if (tree.find(petName)) {
                        String remove = Input.getString("Enter the Code of the Product to be Deleted >> ");
                        if (tree.getNode(petName, tree.root).getPetObject().getProducts().findProduct(remove)){
                            tree.getNode(petName, tree.root).getPetObject().getProducts().deleteProduct(remove);
                            System.out.println("Product Deleted");
                        }
                        else{
                            System.out.println("Product not found");
                        }

                    } else {
                        System.out.println("Pet Type Not Found");
                    }
                }

                // Remove a pet type from the system
                case "8" -> {
                    petName = Input.getString("Enter Pet Type to be Deleted >> ");

                    if (tree.find(petName)){
                        tree.deleteNode(petName);
                        System.out.println("Pet Removed");
                    }
                    else {
                        System.out.println("Pet Type Not Found in the System");
                    }
                }
            }
        } while (!userSelection.equals("0"));
    }
}
