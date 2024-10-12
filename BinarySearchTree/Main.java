package Trees.BinarySearchTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        int[] values = {1,2,3,4,5,6,7,8,9,10};

        // Populate the BST with values
        bst.populatesorted(values);

        // Display the tree using prettyDisplay
        System.out.println("Tree structure:");
        bst.Display();
    }
}
