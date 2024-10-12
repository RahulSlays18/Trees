package Trees.BinaryTree;

import java.util.Scanner;

public class BinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
    //inserting root using populate function
    public void populate(Scanner scanner) {
        System.out.println("Enter the root value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    //overloading populate function to add other nodes also.
    public void populate(Scanner scanner, Node node) {
        String bool="";
        do {
            System.out.println("Do you want to add a left child of " + node.value + " (yes or no)/(y or n)?");
            bool = scanner.next().trim().toLowerCase();
        } while (!bool.equals("y") && !bool.equals("yes") && !bool.equals("n") && !bool.equals("no"));

        // If yes, add left child
        if (bool.equals("y") || bool.equals("yes")) {
            System.out.println("Enter value of left child of " + node.value);
            int left = scanner.nextInt();
            node.left = new Node(left);
            populate(scanner, node.left);
        }

        // Ask for right child
        bool = ""; // Reset the variable for the next prompt
        do {
            System.out.println("Do you want to add a right child of " + node.value + " (yes or no)/(y or n)?");
            bool = scanner.next().trim().toLowerCase();
        } while (!bool.equals("y") && !bool.equals("yes") && !bool.equals("n") && !bool.equals("no"));

        // If yes, add right child
        if (bool.equals("y") || bool.equals("yes")) {
            System.out.println("Enter value of right child of " + node.value);
            int right = scanner.nextInt();
            node.right = new Node(right);
            populate(scanner, node.right);
        }
    }
    // Method to get a node with a given value
    private Node getNode(Scanner scanner) {
        System.out.println("Enter the node value: ");
        int value = scanner.nextInt();
        return getNodeRecursive(root, value); // Start searching from the root
    }
    //return root
    public Node getRoot() {
        return root;
    }
    // Recursive helper method to search for the node
    private Node getNodeRecursive(Node node, int value) {
        if (node == null) {
            return null; // If the node is not found, return null
        }
        // If the node's value matches, return it
        if (node.value == value) {
            return node;
        }
        // Search in the left subtree
        Node leftResult = getNodeRecursive(node.left, value);
        if (leftResult != null) {
            return leftResult; // If found in the left subtree, return it
        }
        // Otherwise, search in the right subtree
        return getNodeRecursive(node.right, value);
    }
    // traversal of tree
    public void printBreadthOrder(Node root)// Function to print level/breadth order
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
            System.out.println();
        }
    }
    public void printDepthOrder(Node root)// Function to print level order
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }
    // Compute the "height" of a tree
    public int height(Node node) {
        if (node == null)
            return -1;
        else {
            int lheight = height(node.left);
            int rheight = height(node.right);
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
    // Print nodes at the current level
    private void printCurrentLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.value + " ");
        else if (level > 1) {
            printCurrentLevel(node.left, level - 1);
            printCurrentLevel(node.right, level - 1);
        }
    }
    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

}