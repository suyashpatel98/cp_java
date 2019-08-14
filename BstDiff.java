import java.util.*;

public class BstDiff{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bst t = new Bst();
		int choice,data;
		while(true){
			System.out.println("Enter choice : ");
			choice = sc.nextInt();
			if(choice == 0){
				data = sc.nextInt();
				t.root = t.insert(data,t.root);
			}
			else if(choice == 1){
				System.out.println();
				t.display(t.root);
				System.out.println();
			}
			else if(choice == 2){
				System.out.println();
				data =  sc.nextInt();
				Node found = t.find(data,t.root);
				if(found != null) System.out.println("Node found");
				else System.out.println("Node not found");
			}
			else if(choice == 3){
				System.out.println("height of the tree : " + t.height(t.root));
				System.out.println("sum of heights : " + t.dfs(t.root));
			}
		}
	}
}

class Bst{
	Node root;
	public static int max(int a,int b){
        return a >= b ? a : b;
    }
	public Node insert(int value,Node root){
        if(root == null) root = new Node(value);
        else if(value > root.data) root.right = insert(value,root.right);
        else root.left = insert(value,root.left);
        return root;
    }
    public int height(Node root){
    	if(root == null) return -1;
        else if(root.right == null && root.left == null) return 0;
        return 1 + max(height(root.right),height(root.left));
    }
    public int dfs(Node root){
        if(root.right == null && root.left == null) return height(root);
        else if(root.right == null) return height(root) + dfs(root.left);
        else if(root.left == null) return height(root) + dfs(root.right);
        return height(root) + dfs(root.right) + dfs(root.left);
    } 
	public void display(Node root){
		if(root!=null){
			System.out.print(root.data);
			display(root.left);
			display(root.right);
		}
	}
	public Node find(int data,Node root){
		if(root == null) return null;
		if(data == root.data) return root;
		else if(data  > root.data) return find(data,root.right);
		else return find(data,root.left);
	}
	public Bst(){
        this.root = null;
    }
}

class Node{
	int data;
	Node right;
	Node left;
	public Node(int data){
        this.data = data;
        right = left = null;
    }
}