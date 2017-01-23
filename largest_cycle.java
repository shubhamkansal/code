import java.io.*;
import java.util.*;
class Graph{
    private LinkedList<Integer> adj[];
    private int V;
    private int E;
    private boolean[] visited;
    private int[] edge_from;
    public Graph(int v){
        this.V = v;
        this.adj = new LinkedList[this.V];
        this.visited = new boolean[this.V];
        this.edge_from = new int[this.V];
        for(int i = 0; i < this.V; i++)
            this.adj[i] = new LinkedList();
        this.E = 0;
    }
    public void add_edge(int x, int y){
        adj[x].add(y);
    }
    public Iterable<Integer> adj(int i){
        return this.adj[i];
    }
    public int largest_cycle_count(){
        boolean []current_path = new boolean[this.V];
        int max = -1;
        for(int i = 0; i < this.V; i++){
            edge_from[i] = -1;
        }
        for(int i = 0; i < this.V; i++){
            if(!visited[i]){
                int temp = 0;
                temp = dfs(current_path, i);
                if(max < temp)
                    max = temp;
            }
        }
        return max;
    }
    public int dfs(boolean []current_path, int s){
        int count = 0;
        visited[s] = true;
        current_path[s] = true;
        for(Integer v : adj(s)){
            edge_from[v] = s;
            if(!visited[v]){
               count = dfs(current_path, v);   
            }
            else{
                if(current_path[v]){
                    count = 1;
                    for(int i = s; i != v; i = edge_from[i]){
                         count++;
                    }
                }          
            }
                  
        }
        current_path[s] = false;
        return count;
    }
}
    
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Graph g = new Graph(n);
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] >= 0)
                g.add_edge(i, arr[i]);
        }
        System.out.println(g.largest_cycle_count());
    }
}
