import java.util.*;
//Implemented a directed graph. See function addEdge. addEdge would be different for an undirected graph
//Weighted graph
class Edge{
	int dest;
	int weight;
	public Edge(int dest,int weight){
		this.dest = dest;
		this.weight = weight;
	}
}

public class GraphFinal{
	private int numVertices;
	private ArrayList<Edge> graph[];
	GraphFinal(int vertices){
		numVertices = vertices;
		graph = new ArrayList[vertices];
		for(int k =0;k<graph.length;k++) graph[k] = new ArrayList();
	}

	public void addEdge(int from,int to,int weight){
		//Time-Complexity : O(1)
		graph[from].add(new Edge(to,weight));
	}

	public void removeEdge(int from,int to,int weight){
		//Time-Complexity : O(deg(from)) 
		graph[from].remove(new Edge(to,weight));
	}

	public boolean hasEdge(int from,int to){
		//Time-Complexity : O(deg(from))
		for(Edge e : graph[from]){
			if(e.dest == to) return true;
		}
		return false;
	}

	public List outEdges(int from){
		//Time-Complexity : O(1)
		ArrayList<Integer> temp = new ArrayList();
		for(Edge e : graph[from]){
			temp.add(e.dest);
		}
		return temp;
	}

	public List inEdges(int to){
		//Time-Complexity : O(n+m) because add in arraylist takes amortized constant time 
		ArrayList<Integer> temp = new ArrayList();
		for(int i=0;i<graph.length;i++){
			for(Edge e : graph[i]){
				if(e.dest == to) temp.add(i);
			}
		}
		return temp;
	}

	public void bfsRecursive(Queue q,boolean[] seen){
		if(!q.isEmpty()){
			int res = (int)q.poll();
			System.out.print(" "+res);
			List temp = new ArrayList(this.outEdges(res));
			for(int k=0;k<temp.size();k++){
				if(!seen[(int)temp.get(k)]){
					q.add(temp.get(k));
					seen[(int) temp.get(k)] = true;
				} 
			}
			bfsRecursive(q,seen); 
		}
	}

	public void bfsIterative(int from){
		Queue q = new LinkedList<Integer>();
		boolean[] seen = new boolean[this.numVertices];
		int temp;
		List crap;
		q.add(from);
		seen[from] = true;
		while(!q.isEmpty()){
			temp = (int) q.poll();
			System.out.print(" "+ temp);
			crap = new ArrayList(this.outEdges(temp));
			for(int k=0;k<crap.size();k++){
				if(!seen[(int)crap.get(k)]){
					q.add(crap.get(k));
					seen[(int)crap.get(k)] = true;
				}
			} 
		}
	}

	public void dfsIterative(int from){
		System.out.println();
		Stack s = new Stack();
		boolean[] seen = new boolean[this.numVertices];
		s.push(from);
		seen[from] = true;
		int temp;
		List crap;
		while(!s.isEmpty()){
			temp = (int)s.pop();
			System.out.print(temp+" ");
			crap = new ArrayList<Integer>(this.outEdges(temp));
			for(int k=0;k<crap.size();k++){
				if(!seen[(int)crap.get(k)]){
					s.push(crap.get(k));
					seen[(int)crap.get(k)] = true;
				}
			} 
		}
	}

	public void dfsRecursive(int from,boolean seen[]){
		if(!seen[from]){
			System.out.print(from+" ");
			seen[from] = true;
		}
		for(int k=0; k < this.outEdges(from).size();k++){
			dfsRecursive((int)this.outEdges(from).get(k),seen);
		}
	}
	public static void main(String[] args) {
		int from,to,weight;
		Scanner sc = new Scanner(System.in);
		System.out.println(" No. of vertices : ");
		int vertices = sc.nextInt();
		GraphFinal g = new GraphFinal(vertices);
		int choice;
		while(true){
			System.out.print("\nChoice : ");
			choice = sc.nextInt();
			if(choice==1){
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();
				if(from<0 || from>=g.graph.length || to<0 || to>=g.graph.length){
					System.out.println("Wrong vertices entered !!");
					continue;
				}
				g.addEdge(from,to,weight);
			}
			else if(choice==2){
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();
				if(from<0 || from>=g.graph.length || to<0 || to>=g.graph.length){
					System.out.println("Wrong vertices entered !!");
					continue;
				}
				g.removeEdge(from,to,weight);
			}
			else if(choice==3){
				from = sc.nextInt();
				to = sc.nextInt();
				if(from<0 || from>=g.graph.length || to<0 || to>=g.graph.length){
					System.out.println("Wrong vertices entered !!");
					continue;
				}
				boolean has = g.hasEdge(from,to);
				System.out.println("The graph has edge from "+from+" to "+to+" : "+has);
			}
			else if(choice==4){
				from = sc.nextInt();
				List<Integer> temp;
				temp = new ArrayList(g.outEdges(from));
				System.out.println("Out edges are : ");
				for(int k=0;k<temp.size();k++) System.out.print(temp.get(k)+ " ");
			}
			else if(choice == 5){
				to = sc.nextInt();
				List<Integer> temp;
				temp = new ArrayList(g.inEdges(to));
				System.out.println("In edges are : ");
				for(int k=0;k<temp.size();k++) System.out.print(temp.get(k));
			}
			else if(choice == 6){
				from = sc.nextInt();
				g.bfsIterative(from);
			}
			else if(choice == 7){
				from = sc.nextInt();
				g.dfsIterative(from);
			}
			else if(choice == 8){
				from = sc.nextInt();
				boolean[] seen = new boolean[g.numVertices];
				g.dfsRecursive(from,seen);
			}
			else if(choice == 9){
				from = sc.nextInt();
				Queue q = new LinkedList();
				q.add(from);
				boolean[] seen = new boolean[g.numVertices];
				seen[from] = true;
				g.bfsRecursive(q,seen);
			}
			else if(choice==-1) break;
		}
		sc.close();
	}
}