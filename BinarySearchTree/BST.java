package Trees.BinarySearchTree;

import Trees.BinaryTree.BinaryTree;

class BST extends BinaryTree {

    // Node class to represent each node in the tree
    public static class Node {
        private int data;
        private Node left, right;
        private int height; // Track the height for balancing

        public Node(int data) {
            this.data = data;
            this.height = 0; // Initialize the height as 0 when created
        }

        public int getData() {
            return data;
        }
    }

    private Node root;

    public BST() {
        this.root = null; // Initialize root as null
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Public method to insert data into the BST
    public void insert(int data) {
        root = insert(data, root); // Insert starting at the root
    }

    // Private method to recursively insert data into the BST
    private Node insert(int data, Node node) {
        if (node == null) {
            return new Node(data); // Create a new node if we've reached a null position
        }

        // Traverse to the left if data is less than current node's data
        if (data < node.getData()) {
            node.left = insert(data, node.left);
        }
        // Traverse to the right if data is greater than current node's data
        else if (data > node.getData()) {
            node.right = insert(data, node.right);
        }

        // Update the height of the current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    // Helper function to get the height of a node
    public int height(Node node) {
        if (node == null) {
            return -1; // Base case, height of null node is -1
        }
        return node.height;
    }

    // Display the tree in a more readable format
    public void Display() {
        Display(root, "Root is: ");
    }

    public void Display(Node node, String msg) {
        if (node == null) {
            return;
        }
        System.out.println(msg + node.getData());
        Display(node.left, "Left child of " + node.getData() + ": ");
        Display(node.right, "Right child of " + node.getData() + ": ");
    }

    // Check if the tree is balanced
    public boolean balanced() {
        return balanced(root);
    }

    // Recursively check if the subtree rooted at `node` is balanced
    private boolean balanced(Node node) {
        if (node == null) {
            return true; // An empty tree is always balanced
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // A tree is balanced if:
        // 1. The difference in height between the left and right subtrees is <= 1
        // 2. Both the left and right subtrees are balanced
        return Math.abs(leftHeight - rightHeight) <= 1 && balanced(node.left) && balanced(node.right);
    }

    // Populate the BST with an array of integers
    public void populate(int[] nums) {
        for (int num : nums) {
            insert(num); // Insert each number into the BST
        }
    }
    public void populatesorted(int[] nums) {
        populatesorted(nums,0,nums.length-1);
    }
    //Populate the BST with
    private void populatesorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end)/2;
        this.insert(nums[mid]);
        populatesorted(nums, start, mid);
        populatesorted(nums, mid + 1, end);
    }
}
