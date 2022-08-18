import java.util.LinkedList;
import java.util.*;

public class ConnectedComponents {
    static List<Integer>[] adj;
    static boolean[] visited;
    public static void getAdjacancyList(int n, int[][] edges){
        adj=new LinkedList[n];
        for(int i=0; i<n; i++){
            adj[i]=new LinkedList<Integer>();
        }
        for(int i=0;i<edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
    }
    
    public static void dfs(int vertex){
        if(!visited[vertex]){
            visited[vertex]=true;
            for(int adj_ver:adj[vertex]){
                dfs(adj_ver);
            }
        }
    }
    public static void main(String[] args){
        int n=5;
        int count=0;
        int[][] edges = {{0,1},{1,2},{3,4}};
        getAdjacancyList(n,edges);
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
            dfs(i);
            count++;
        }
        }
        System.out.println(count);
    }
}
