import java.util.*;
//Implemented a directed graph. See function addEdge. addEdge would be different for an undirected graph
class BfsClass{
	int level;
	boolean color;
	public BfsClass(int level,boolean color){
		this.level = level;
		this.color = color;
	}
}
public class Graph{
	private int numVertices;
	private ArrayList<Integer> graph[];
	Graph(int vertices){
		numVertices = vertices;
		graph = new ArrayList[vertices];
		for(int k =0;k<graph.length;k++) graph[k] = new ArrayList();
	}

	public void addEdge(int from,int to){
		//Time-Complexity : O(1)
		graph[from].add(to);
		graph[to].add(from);
	}

	public void removeEdge(int from,int to){
		//Time-Complexity : O(deg(from)) 
		graph[from].remove(new Integer(to));
	}

	public boolean hasEdge(int from,int to){
		//Time-Complexity : O(deg(from))
		return graph[from].contains(to);
	}

	public List outEdges(int from){
		//Time-Complexity : O(1)
		return graph[from];
	}

	public List inEdges(int to){
		//Time-Complexity : O(n+m) because add in arraylist takes amortized constant time 
		ArrayList<Integer> temp = new ArrayList();
		for(int i=0;i<graph.length;i++){
			if(graph[i].contains(to)) temp.add(i);
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
	public boolean isBipartite(int from){
		boolean[] seen = new boolean[this.numVertices];
		BfsClass[] arr = new BfsClass[this.numVertices];
		Queue q = new LinkedList<Integer>();
		q.add(from);
		int index,level=0;
		boolean color = true;
		List temp;
		while(!q.isEmpty()){
			index = (int)q.poll();
			seen[index] = true;
			arr[index] = new BfsClass(level,color);
			color = !color;
			level++;
			temp = (ArrayList) this.outEdges(index);
			for(int i=0;i<temp.size();i++){
				if(!seen[(int)temp.get(i)]){
					seen[(int)temp.get(i)] = true;
					q.add(temp.get(i));
				}
			}
		}
		Arrays.sort(arr,new Comparator<BfsClass>(){
			public int compare(BfsClass one,BfsClass two){
				if(one.level > two.level) return one.level - two.level;
				else return two.level - one.level;
			}
		});
		int i = 0,flag =0;
		while(i < arr.length-1){
			if(arr[i].level != arr[i+1].level){
				if(arr[i].color == arr[i+1].color){
					flag = 1;
					break;
				}
			}
			i++;
		}
		if(flag == 1) return false;
		return true;
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
		int from,to;
		Scanner sc = new Scanner(System.in);
		System.out.println(" No. of vertices : ");
		int vertices = sc.nextInt();
		Graph g = new Graph(vertices);
		int choice;
		while(true){
			System.out.print("\nChoice : ");
			choice = sc.nextInt();
			if(choice==1){
				from = sc.nextInt();
				to = sc.nextInt();
				if(from<0 || from>=g.graph.length || to<0 || to>=g.graph.length){
					System.out.println("Wrong vertices entered !!");
					continue;
				}
				g.addEdge(from,to);
			}
			else if(choice==2){
				from = sc.nextInt();
				to = sc.nextInt();
				if(from<0 || from>=g.graph.length || to<0 || to>=g.graph.length){
					System.out.println("Wrong vertices entered !!");
					continue;
				}
				g.removeEdge(from,to);
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
			else if(choice == 10){
				if(g.isBipartite(1)) System.out.println(" isBipartite");
				else System.out.println(" is not Bipartite");
			}
			else if(choice==-1) break;
		}
		sc.close();
	}
}