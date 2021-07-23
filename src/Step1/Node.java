package Step1;

public class Node {

    String name;
    Pet newPetObject;
    Node left, right;

    public Node(String petType, Pet petObject) {
        name = petType;
        newPetObject = petObject;
        left = right = null;
    }

    // Getters

    public String getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


    // Insert Method - Checks
    public Node insert(String key, Pet payload) {
        if (key.compareTo(name) < 0) {
            if (this.left == null) {
                this.left = new Node(key, payload);
            } else {
                this.left = this.left.insert(key, payload);
            }
        } else if (key.compareTo(name) > 0) {
            if (this.right == null) {
                this.right = new Node(key, payload);
            } else {
                this.right = this.right.insert(key, payload);
            }
        }
        return this;
    }

    // Display Products for Particular Pet based upon search term
    public void search(String query) {

        if (query.equals(this.name)){
            this.newPetObject.toString();
        }

        else if (query.compareTo(this.name) < 0) {
            if (left == null){
                System.out.println("Not Found");
            }
            else{
                left.search(query);
            }
        }

        else if (query.compareTo(this.name) > 0) {
            if (right == null) {
                System.out.println("Not found");
            }
            else{
                right.search(query);
            }
        }
    }

}

