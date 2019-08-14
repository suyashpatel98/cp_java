import java.util.*;

public class LastBst{
	public static Node root = NULL;
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

	public static Node insert(Node root,int val){
		if(root == null){
			root = new Node(val);
			return root;
		}
		else if(val > root.data) root.right = insert(root.right, val);
		else if(val < root.data) root.left = insert(root.left, val);
		return root;
	}

	public static Node find(Node root,int val){
		if(root == null || root.data = val) return root;
		else if(root.data < val) return find(root.right,val);
		else return find(root.left,val);
	}

	public static void main(String[] args) {
		
	}
}