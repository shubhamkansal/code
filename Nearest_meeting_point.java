import java.io.*;
import java.util.*;
class Graph{
    private LinkedList<Integer> adj[];
    private int V;
    private int E;
    private boolean[] visited;
    public Graph(int v){
        this.V = v;
        this.adj = new LinkedList[this.V];
        this.visited = new boolean[this.V];
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
    public int nearest_meeting_cell(int x, int y ){
        if(x == y) return x;
        int count = 0;
        int x_arr[] = new int[this.V];
        int y_arr[] = new int[this.V];
        int result[] = new int[this.V];
        dfs(x_arr, x, count);
        System.out.println();
        visited = new boolean[this.V];
        dfs(y_arr, y, count);
        System.out.println();
        for(int i = 0; i < this.V; i++){
            if(x_arr[i] > y_arr[i])
                result[i] = x_arr[i];
            else 
                result[i] = y_arr[i];
            if((x_arr[i] == 0 || y_arr[i] == 0) && (i != x && i !=y))
                result[i] = 0;
        }
        int min = Integer.MAX_VALUE;
        int meeting_point = -1;
        for(int i = 0; i < this.V; i++){
            System.out.print(x_arr[i] + " ");   
        }    
        System.out.println();
        for(int i = 0; i < this.V; i++){
            System.out.print(y_arr[i] + " ");   
        }    
        System.out.println();
        for(int i = 0; i < this.V; i++){
            System.out.print(result[i] + " ");   
        }    
        System.out.println();
        for(int i = 0; i < this.V; i++){
            if(result[i] < min && result[i] != 0){
                min = result[i];
                meeting_point = i;
            }
        }
        return meeting_point;
    }
    public void dfs(int[] arr, int v, int count){
        visited[v] = true;
        arr[v] = count++;
        System.out.print(arr[v] + " ");
        for(Integer i : adj(v)){
            if(!visited[i]){
                dfs(arr, i, count);
            }
            else{
                return;
            }
        }
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
            g.add_edge(i, arr[i]);
        }
        System.out.println(g.nearest_meeting_cell(sc.nextInt(), sc.nextInt()));
    }
}
