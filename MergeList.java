import java.util.*;

class MergeList{
	public static void merge(List<List<Integer>> l){
		PriorityQueue<Node> heap = new PriorityQueue<>();
		for(int i=0;i<l.size();i++){
			heap.add(new Node(l.get(i).get(0),0,i));
		}
		while(!heap.isEmpty()){
			Node min = (Node)heap.poll();
			System.out.print(min.value + " ");
			if((min.i +  1) < l.get(min.row).size()){
				min.value = l.get(min.row).get(min.i +1);
				min.i = min.i + 1;
				heap.add(min);
			}
		}
	}
	public static void main(String[] args) {
		List<List<Integer>> l = Arrays.asList(
                                    Arrays.asList(10, 20, 30, 40),
                                    Arrays.asList(15, 25, 35),
                                    Arrays.asList(27, 29, 37, 48, 93),
                                    Arrays.asList(32, 33)
                                ); 
		merge(l);
	}
}

class Node implements Comparable<Node>{
	public int value;
	public int i,row;
	public Node(int val,int i,int row){
		value = val;
		this.i = i;
		this.row = row;
	}
	public int compareTo(Node o){
		Node temp = (Node)o;
		return this.value - temp.value;
	}
}