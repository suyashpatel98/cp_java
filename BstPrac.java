import java.util.*;


public class BstPrac{
	private Node root;
	public BstPrac(){
		this.root = null;
	}
	public class Node{
		int data;
		Node right;
		Node left;
		public Node(int data){
			this.data = data;
			right = null;
			left = null;
		}
	}

	public Node insert(int data, Node root){
		Node n = new Node(data);
		if(root == null) root = n;
		else if(data < root.data) root.left = insert(data,root.left);
		else root.right = insert(data,root.right);
		return root;
	}

	public Node find(int data, Node root){
		Node curr = root;
		while(curr!=null){
			if(data!=curr.data){
				if(data < curr.data) curr = curr.left;
				else curr = curr.right;
			}
			else break;
		}
		return curr;
	}

	public Node findRecursive(int data,Node root,ArrayList<Integer> al){
		if(root == null) return null;
		if(root.data == data){
			al.add(root.data);
			return root;
		} 
		al.add(root.data);
		if(root.data < data) return findRecursive(data,root.right,al);
		else return findRecursive(data,root.left,al);
	}

	public void findBinaryRecursive(Node root, int data, ArrayList<Integer> al){
		if(root == null){
			al = new ArrayList<Integer>();
			return;
		} 
		if(root.data == data){
			al.add(root.data);
			return;
		} 
		al.add(root.data);
		findBinaryRecursive(root.right,data,al);
		findBinaryRecursive(root.left,data,al);
	}

	public void levelOrderTraversal(Node root){
		System.out.println();
		Queue q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = (Node)q.poll();
			System.out.print(temp.data + " ");
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
		}
	}

	public void dfsIterative(Node root){
		Stack s = new Stack();
		s.push(root);
		while(!s.isEmpty()){
			Node temp = (Node) s.pop();
			System.out.print(temp.data + " ");
			if(temp.left!=null) s.push(temp.left);
			if(temp.right!=null) s.push(temp.right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, value;
		BstPrac t = new BstPrac();
		while(true){
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			if(choice == 1){
				value = sc.nextInt();
				t.root = t.insert(value,t.root);
			}
			else if(choice == 2){
				value = sc.nextInt();
				Node temp = t.find(value, t.root);
				if(temp == null) System.out.println("Doesn't exist");
				else System.out.println("exists");
			}
			else if(choice == 3){
				value = sc.nextInt();
				ArrayList<Integer> al = new ArrayList<Integer>();
				Node temp = t.findRecursive(value, t.root,al);
				if(temp == null) System.out.println("Doesn't exist");
				else System.out.println("exists");
				for(int i=0;i<al.size();i++){
					System.out.println(al.get(i) + " ");
				}
			}
			else if(choice == 4){
				value = sc.nextInt();
				ArrayList<Integer> al = new ArrayList<Integer>();
				t.findBinaryRecursive(t.root,value,al);
				if(al.isEmpty()) System.out.println("Doesn't exist");
				else System.out.println("exists");
				for(int i=0;i<al.size();i++){
					System.out.print(al.get(i) + " ");
				}
				System.out.println();
			}
		}
	}
}