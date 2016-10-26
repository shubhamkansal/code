import java.util.*;

class BFS{
    private int s;
    private boolean[] marked;
    private int[] edgeTo;
    public BFS(graph g, int s){
        this.s = s;
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        for(int i = 0; i < g.V(); i++){
            this.edgeTo[i] = -1;   
        }
        bfs(g, s);
    } 
    private void bfs(graph g, int v){
        marked[v] = true;
        Queue<Integer> q = new LinkedList();
        q.add(v);
        while(!q.isEmpty()){
            int w = q.poll();
            for(Integer x : g.adj(w)){
                if(!marked[x]){
                    marked[x] = true;
                    edgeTo[x] = w;
                    q.add(x);
                }
            }
        }
    }
    public boolean hasPathTo(int w){
        return marked[w];
    }
    public void printpath(int w){
        if(marked[w]){
            System.out.println("Path from " + this.s + " to " + w + " is : ");
            Stack<Integer> s = new Stack();
            s.push(w);
            while(edgeTo[w] != -1){
                s.push(edgeTo[w]);
                w = edgeTo[w];   
            }
            while(true){
                System.out.print(s.peek());
                s.pop();
                if(s.empty())
                    break;
                System.out.print("->");
            }
            System.out.println();
        }
        else
            System.out.println("path doesn't exist");
    }
}

public class breadth_first_search{
    public static void main(String args[]){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter no of vertices :");
        int v = s1.nextInt();
        graph g = new graph(v);
        System.out.println("Enter vertices to connect :");
        while(true){
            g.addedge(s1.nextInt(), s1.nextInt());
            System.out.println("Enter 1 to continue :");
            if(s1.nextInt() != 1)
                break;
        }
        System.out.println("Enter source edge :");
        int s = s1.nextInt();
        BFS b = new BFS(g, s);
        System.out.println("Enter destination edge :");
        int des = s1.nextInt();
        if(b.hasPathTo(des))
            System.out.println("Connected");
        else
            System.out.println("Not Connected");
        b.printpath(des);
    }
}

