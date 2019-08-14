import java.util.*;

public class GraphSRI{
	static int[][] g;
	static int visit[],q[];
	static int front=0, rear=0;
	static void bfs(int j){
		System.out.println("BFS : ");
		System.out.println(j);
		visit[j] = 1;
		q[rear++] = j;
		while(front < rear){
			int temp = q[front++];
			for(int i=0;i<g[temp].length;i++){
				if(g[temp][i] == 1 && visit[i] != 1){
					visit[i] = 1;
					System.out.println(i);
					q[rear++] = i;
				}
			}
		}
	}
	static void dfs(int j){
		System.out.println(j);
		visit[j] = 1;
		for(int i=0;i<g[j].length;i++){
			if(g[j][i] == 1 && visit[i] != 1){
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		g = new int[n][n];
		visit = new int[n];
		q = new int[n];
		while(true){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1 == -1 && v2 == -1) break;
			g[v1][v2] = g[v2][v1] = 1;
		}
		dfs(0);
		for(int i=0;i<visit.length;i++) visit[i] = 0;
		bfs(0);
	}
}