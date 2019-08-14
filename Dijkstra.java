import java.util.*;

class Dijkstra{
	static int[][] g;
	static boolean[] seen;
	static int[] dist,prev;

	public static void shortestPath(int source){
		PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
			public int compare(Node n1,Node n2){
				return n1.wt-n2.wt;
			}
		});
		q.add(new Node(source,0));
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[source] = 0;
		seen[source] = true;
		prev[source] = -1;
		int u = 0;
		while(!q.isEmpty()){
			Node node = (Node)q.poll();
			u = node.v;
			for(int i=0;i<g[u].length;i++){
				if(g[u][i] > 0){
					int v = i;
					int wt = g[u][v];
					if(!seen[v] && (wt + dist[u] < dist[v])){
						dist[v] = wt + dist[u];
						prev[v] = u;
						q.add(new Node(v,dist[v]));
					}
				}
			}
			seen[u] = true;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		g = new int[n][n];
		seen = new boolean[n];
		dist = new int[n];
		prev = new int[n];
		while(true){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			if(v1 == -1 && v2 == -1) break;
			g[v1][v2] = sc.nextInt();
		}
		int source = sc.nextInt();
		shortestPath(source);
		for(int i=0;i<dist.length;i++){
			System.out.println("Distance of " + i + " from "+ source + " is "+ dist[i]);
		}
		System.out.println(seen[2] + "");
	}
}

class Node{
	int v,wt;
	public Node(int v,int wt){
		this.v = v;
		this.wt = wt;
	}
}