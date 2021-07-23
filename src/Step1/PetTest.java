package Step1;

public class PetTest {

    public static void main (String[] args){

        // Variables
        String userSelection;
        String searchTerm;
        Tree petSupplies = new Tree();

        do {
            // ### User Menu ###
            System.out.println("--------------------");
            System.out.println("[1] Add Pet");
            System.out.println("[2] Find if the company provides products for a particular pet type");
            System.out.println("[3] Display a specific pet type");
            System.out.println("[4] Remove a specific pet type");
            System.out.println("[5] Display list of all the pet types the company provides products for in alphabetical order");
            System.out.println("[0] Exit");
            System.out.println("\n");
            userSelection = Input.getString("What would you like to do? >>");
            System.out.println("--------------------");

            // Logic for User selection
            switch (userSelection) {

                // Quit the program
                case "0" -> System.out.println("Goodbye!");

                // Add a new Pet to the System
                case "1" -> {
                    int repeatOption;

                    do {
                    String petName = Input.getString("What is the name of the pet type? >>");
                    Pet newPetObject = new Pet(petName, null);
                    petSupplies.insertNode(newPetObject.getName(), newPetObject);

                   repeatOption = Input.getInteger("Would you like to add another Pet to the system? 1=Yes 0=No >> ");
                    } while (repeatOption == 1);
                }

                // Search for a Pet Type
                case "2" -> {
                    searchTerm = Input.getString("What pet would you like to search for? >> ");
                    if (!petSupplies.findNode(searchTerm)){
                        System.out.println("We do not stock products for that type of Pet.");
                    }
                    else {
                        System.out.printf("We do stock products for %s's", searchTerm + "\n");
                    }
                }

                // Display Information for a Pet Type
                case "3" -> {
                    searchTerm = Input.getString("What is the Pet type you would like to display information for? ");
                    petSupplies.search(searchTerm);
                }

                // Delete a node from the system
                case "4" -> {
                    System.out.println("Pet Types in System: " + petSupplies.inOrder());
                    searchTerm = Input.getString("What pet type would you like to delete? >>");
                    petSupplies.deleteNode(searchTerm);
                }

                case "5" -> System.out.println(petSupplies.inOrder());

                default -> System.out.println("Invalid Selection - Please Try Again");
            }
        } while (!userSelection.equals("0"));

    }
}
