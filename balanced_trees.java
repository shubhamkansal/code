//to find height of tree using balanced trees
import java.util.*;

class balanced_trees{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    class Node{
        private int key;
        private int value;
        private Node left;
        private Node right;
        private boolean color;
        public Node(int key, int value, boolean color){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private Node root = null;

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    private void flipcolors(Node x){
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    private Node rotateLeft(Node x){
        Node h = x.left;
        x.right = h.left;
        h.left = x;
        h.color = x.color;
        x.color = RED;
        return h;
    }

    private Node rotateRight(Node x){
        Node h = x.left;
        x.left = h.right;
        h.right = x;
        h.color = x.color;
        x.color = RED;
        return h;
    }

    public void insert(int key, int value){
        root = insert(root, key, value);
    }
    private Node insert(Node x, int key, int value){
        if(x == null) return new Node(key, value, RED);
        if(x.key > key) 
            x.left = insert(x.left, key, value);
        if(x.key < key)
            x.right = insert(x.right, key, value);
        if(isRed(x.right) && !isRed(x.left))
            x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left))
            x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right))
            flipcolors(x);
        else x.value = value;
        return x;
    }
    
    public int height(){
        return height(root);
    }
    private int height(Node n){
        if(n == null) return 0;
        return 1 + Math.max(height(n.left) , height(n.right));
    }
    
    public static void main(String args[]){
        balanced_trees bt = new balanced_trees();
        Scanner s1 = new Scanner(System.in);
        int n = s1.nextInt();
        for(int i = 0; i < n; i++){
            bt.insert(s1.nextInt(), s1.nextInt());
        }
        System.out.println("Height of tree is : " + bt.height());
    }
    
}
