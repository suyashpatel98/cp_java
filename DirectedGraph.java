import java.util.*;

class DirectedGraph{
	static int[][] g;
	static boolean[] seen;

	public static int dfsUtil(int time,int start,int[] dept){
		seen[start] = true;
		for(int i=0;i<g.length;i++){
			if(g[start][i] == 1 && !seen[i]) time = dfsUtil(time,i,dept);
		}
		dept[start] = time++;
		return time;
	}

	public static boolean detectCycle(int start){
		int time = 0;
		int[] dept = new int[g.length];

		for(int i=0;i<g.length;i++){
			if(!seen[i]) time = dfsUtil(time,i,dept);
		}

		for(int i=0;i<g.length;i++){
			for(int j=0;j<g[0].length;j++){
				if(g[i][j] == 1 && dept[i]<=dept[j]) return true;
			}
		}
		return false;
	}

	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		seen[start] = true;
		while(!q.isEmpty()){
			int temp = (int)q.poll();
			System.out.println(temp);
			for(int i=0;i<g.length;i++){
				if(g[temp][i] == 1 && !seen[temp]){
					seen[i] = true;
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		g = new int[n][n];
		while(true){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1 == -1 && v2 == -1) break;
			g[v1][v2] = 1;
		}
		int choice = 0;
		while(true){
			choice = sc.nextInt();
			if(choice == -1) break;
			if(choice == 2){
				int start = sc.nextInt();
				seen = new boolean[n];
				if(detectCycle(start)) System.out.println("Graph has a cyccle");
				else System.out.println("No cycle");
			}
		}
	}
}

/*
Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		while(k > 0){
		    k--;
		}
*/