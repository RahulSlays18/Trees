package Trees.BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        bt.populate(sc);
        System.out.println("Breadth First Traversal");
        bt.printBreadthOrder(bt.getRoot());
        System.out.println("Depth First Traversal");
        bt.printDepthOrder(bt.getRoot());
        System.out.println();
        System.out.println("Pretty Horizontal Display");
        bt.prettyDisplay();
        sc.close();
    }
}
