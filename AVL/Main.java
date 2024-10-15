package Trees.AVL;

public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();
        for(int i=0;i<10;i++)
            tree.insert(i*2);
        tree.Display();
        System.out.println("Height of the tree: "+tree.height());
    }
}
