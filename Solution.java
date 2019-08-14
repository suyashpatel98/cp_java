import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//This would be an undirected graph 
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph g;
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            g = new Graph(n);
            //number of roads
            int m = in.nextInt();
            //library cost
            long x = in.nextLong();
            //road cost
            long y = in.nextLong();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                g.addEdge(city_2,city_1);
            }
            if(y > x) System.out.println(x*n);
            else{
                int connectedComponents =0;
                boolean[] visited = new boolean[n];
                for(int i=0;i<visited.length;i++){
                    if(visited[i]==false){
                        visited = g.bfs(i,visited);
                        connectedComponents++;
                    }
                }
                long ans = (connectedComponents*x)+(n-1-(connectedComponents-1))*y;
                System.out.println(ans);
            }
        }
    }
}

class Graph{
    int numVertices;
    ArrayList<Integer> graph[];
    public Graph(int numVertices){
        this.numVertices = numVertices;
        graph = new ArrayList[numVertices];
        for(int i=0;i<graph.length;i++) graph[i] = new ArrayList();
    }
    public void addEdge(int from,int to){
        graph[from].add(to);
        graph[to].add(from);
    }
    public ArrayList adjacentEdges(int from){
        return graph[from];
    }
    public boolean[] bfs(int from,boolean[] visited){
        Queue q = new LinkedList<Integer>();
        q.add(from);
        visited[from] = true;
        int crap,t;
        List temp;
        while(!q.isEmpty()){
            crap = (int) q.poll();
            temp = adjacentEdges(crap);
            for(int i=0;i<temp.size();i++){
                t = (int) temp.get(i);
                if(visited[t]==false){
                    visited[t] = true;
                    q.add(t);
                }
            }
        }
        return visited;
    }
}
