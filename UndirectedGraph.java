import java.util.*;

class UndirectedGraph{
	static int[][] g;
	static boolean[] seen;

	public static boolean detectCycle(int start){
		
	}

	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		seen[start] = true;
		while(!q.isEmpty()){
			int temp = (int)q.poll();
			for(int i=0;i<g[temp].length;i++){
				if(g[temp][i] == 1 && !seen[i]){
					q.add(i);
					seen[i] = true;
				}
			}
		}
	}

	public static void dfs(int start){
		seen[start] = true;
		System.out.println(start);
		for(int i=0;i<g[start].length;i++){
			if(g[start][i] == 1 && !seen[i]) dfs(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(true){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1 == -1 && v2 == -1) break;
			g[v1][v2] = g[v2][v1] = 1;
		}
	}
}