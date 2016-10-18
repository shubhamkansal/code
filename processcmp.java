import java.util.*;

class priority{
    private int avgTime;
    private int medianTime;
    public priority(int a, int b){
        this.avgTime = a;
        this.medianTime = b;
    }
    public int getAvgTime(){
        return this.avgTime;
    }
    public int getMedianTime(){
        return this.medianTime;
    } 
}

class Byavg implements Comparator{
    public int compare(Object o1, Object o2){
        priority p1 = (priority)o1;
        priority p2 = (priority)o2;
        if(p1.getAvgTime() > p2.getAvgTime())
            return 1;
        if(p1.getAvgTime() < p2.getAvgTime())
            return -1;
        return 0;
    }
}

class Bymedian implements Comparator{
    public int compare(Object o1, Object o2){
        priority p1 = (priority)o1;
        priority p2 = (priority)o2;
        if(p1.getMedianTime() > p2.getMedianTime())
            return 1;
        if(p1.getMedianTime() < p2.getMedianTime())
            return -1;
        return 0;
    }
}

class process{
    private String pName;
    private int pId;
    public process(String a, int b){
        this.pName = a;
        this.pId = b;
    }
    public String getPName(){
        return this.pName;
    }
    public int getPId(){
        return this.pId;
    }   
    public String toString(){
        return this.pName;
    }
}

class tree{
    private Node root = null;
    class Node{
        priority key;
        process value;
        Node left;
        Node right;
        public Node(priority key, process value){
            this.key = key;
            this.value = value;
        }
    }
    public void insert(priority key, process value, Comparator c){
        root = insert(root, key, value, c);
    }
    private Node insert(Node n, priority key, process value, Comparator c){
        if(n == null) return new Node(key, value);
        else if(c.compare(key, n.key) < 0)
            n.left = insert(n.left, key, value, c);
        else if(c.compare(key, n.key) > 0)
            n.right = insert(n.right, key, value, c);
        else{
            n.key = key;
            n.value = value;
        }
        return n;
    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }
    private void inorder(Node n){
        if(n == null) return;
        inorder(n.left);
        System.out.println(n.value);
        inorder(n.right);
    }
}

class processcmp{
    public static void main(String args[]){
        process p1 = new process("process1", 1);
        process p2 = new process("process2", 2);
        process p3 = new process("process3", 3);
         
        priority pt1 = new priority(5, 6);
        priority pt2 = new priority(3, 4);
        priority pt3 = new priority(7, 3);
        
        System.out.println("--By Average Time--");
        Comparator c = new Byavg();

        tree t = new tree();
        t.insert(pt1, p1, c);
        t.insert(pt2, p2, c);
        t.insert(pt3, p3, c);

        t.inorder();

        System.out.println("--By Median Time--");
        c = new Bymedian();

        tree t1 = new tree();
        t1.insert(pt1, p1, c);
        t1.insert(pt2, p2, c);
        t1.insert(pt3, p3, c);

        t1.inorder();
    }
}
