package Step1;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    // Function for finding the minimum value in the tree
    private String findMin(Node node) {
        return node.left == null ? node.getName() : findMin(node.left);

    }

    // Function for inserting data
    public void insertNode(String name, Pet petObject) {
        if (root == null) {
            root = new Node(name, petObject);
        } else {
            root = root.insert(name, petObject);
        }
    }

    // Inorder Traversal Methods & Output
    public String inOrder() {
        return inOrderHelper(root);
    }

    private String inOrderHelper(Node node) {
        if (node == null) {
            return "List is Empty";
        }
        inOrderHelper(node.getLeft());
        System.out.printf("%s ", node.getName());
        inOrderHelper(node.getRight());
        return "";
    }

    // Find if a node exists in the tree
    public boolean findNode(String name) {
        return findNodeHelper(root, name);
    }

    private boolean findNodeHelper(Node node, String name) {
        if (node == null) {
            return false;
        } else if (node.getName().equals(name)) {
            return true;
        } else {
            return findNodeHelper(node.left, name) || findNodeHelper(node.right, name);
        }
    }


    // Delete a node from the tree
    public void deleteNode(String name) {
        root = deleteNodeHelper(root, name);
    }

    private Node deleteNodeHelper(Node current, String name) {
        if (current == null) {
            return null;
        }

        if (name.compareTo(current.name) == 0) {

            // If both left and right child nodes of the current node are null
            if (current.left == null && current.right == null) {
                return null;
            }

            // If the current node has 1 child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // If the current node has 2 children
            current.name = findMin(current.right);
            current.right = deleteNodeHelper(current.right, current.name);
            return current;
        } else if (name.compareTo(current.name) < 0) {
            current.left = deleteNodeHelper(current.left, name);
            return current;
        }

        current.right = deleteNodeHelper(current.right, name);
        return current;
    }

    // Display Products for Particular Pet based upon search term
    public void search(String query) {
        if (root == null){
            System.out.println("No Pets in List");
        }
        else {
            root.search(query);
        }
    }
}









