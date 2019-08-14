import java.util.*;

public class Bst{
    private Node root;
    static int diameter = 0;
    static Node LCA = null;
    public Bst(){
        this.root = null;
    }
    /*
    public boolean find(int data){
        // Iterative implementation
        Node current = root;
        while(current != null){
            if(current.data == data) return true;
            else if(current.data < data) current = current.right;
            else current = current.left;
        }
        return false;
    }
    */
    public Node find(int data,Node root){
        // Recursive implementation
        Node current = root;
        if(root == null){
            return null;
        }
        if(current.data == data) return current;
        else if(current.data < data) return find(data,root.right);
        else  return find(data,root.left);
    }
    public Node insert(int data, Node root){
        //Recursive implementation
        Node n = new Node(data);
        if(root == null){
            root = n;
        }
        else if(root.data < data) root.right = insert(data,root.right);
        else root.left = insert(data,root.left);
        return root;
    }

    public Node findMax(Node root){
        Node temp = root;
        while(temp.right!=null) temp = temp.right;
        return temp;
    }
    /*
    //Incorrect implementation 
    public Node predecessor(int data , Node root){
        Node temp =root;
        Node curr = find(data,root);
        if(curr.left!=null) return findMax(curr.left);
        else{
            while(true){
                if(temp.data < data && (temp.right).data >= data ) return temp;
                else if(temp.data < data) temp = temp.right;
                else temp = temp.left;
            }
        }
    }
    */
    public Node predecessor(int data,Node root){
        Node temp =root;
        Node curr = find(data,root);
        if(curr.left!=null) return findMax(curr.left);
        //An ancestor has to be the predecessor 
        Node pred = null;
        Node ans = root;
        while(ans != curr){
            if(curr.data > ans.data){
                pred = ans;
                ans = ans.right;
            }
            else ans = ans.left;
        }
        return pred;
    }
    public Node delete(int data, Node root){
        if(root.data == data){
            //4 cases 
            if(root.right == null && root.left == null){
                root = null;
            }
            else if(root.right == null){
                root.data = root.left.data;
                root.left = null;
            }
            else if(root.left == null){
                root.data = root.right.data;
                root.right = null;
            }
            else{
                root.data = root.left.data;
                root.left = null;
            }
        }
        else if(root.data < data) root.right=delete(data,root.right);
        else root.left = delete(data,root.left);
        return root;
    }
    
    public void display(Node root){
        if(root!=null){
            display(root.right);
            System.out.println(" "+ root.data);
            display(root.left);
        }
    }

    public void levelOrderTraversal(Node root){
        System.out.println();
        Queue q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = (Node)q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
    }

    public void bfsRecursive(Queue q){
        if(!q.isEmpty()){
            Node temp = (Node)q.poll();
            System.out.print(" "+temp.data);
            if(temp.left!=null) q.add(temp.left);
            if(temp.left!=null) q.add(temp.right);
            bfsRecursive(q);
        }
        else return;
    }

    public void dfsIterative(Node root){
        System.out.println();
        Stack s = new Stack();
        Node temp = root;
        s.push(root);
        while(!s.isEmpty()){
            temp = (Node)s.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
        }
    }
    public static int level(int val,int level,Node root){
        if(root == null) return -1;
        if(val == root.data) return level;
        return Math.max(level(val,level+1,root.right),level(val,level+1,root.left));
    }
    public static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static boolean isCompleteTree(Node root){
        Queue q = new LinkedList();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            Node temp = (Node)q.poll();
            if(temp.right!= null && temp.left == null) return false;
            if(temp.right != null || temp.left != null) flag = true;
            if(temp.right != null) q.add(temp.right);
            if(temp.left != null) q.add(temp.left);
            if(flag) break;
        }
        while(!q.isEmpty()){
            Node temp = (Node)q.poll();
            if(temp.right != null || temp.left != null) return false;
        }
        return true;
    }
    public static boolean pathSum(Node root,int sum){
        if(root == null) return false;
        int curr = root.data;
        if(root.right == null && root.left == null){
            if(curr == sum) return true;
            else return false;
        }
        return pathSum(root.right,sum-root.data) || pathSum(root.left,sum-root.data);
    }
    public static int diameter(Node root, int h){
        if(root == null) return 0;
        int left = diameter(root.left,h+1);
        int right = diameter(root.right,h+1);
        h = left + right + 1;
        diameter = Math.max(diameter,h);
        return Math.max(right,left) + 1;
    }
    public static boolean findLCA(Node root,Node n1,Node n2){
        if(root == null) return false;
        if(root == n1 || root == n2){
            LCA = root;
            return true;
        }
        boolean left = findLCA(root.left,n1,n2);
        boolean right = findLCA(root.right,n1,n2);
        if(right && left){
            LCA = root;
            return true;
        }
        return right || left;
    }
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            right = null;
            left = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice,value;
        Bst t = new Bst();
        while(true){
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            if(choice==-1) break;
            else if(choice == 1){
                value = sc.nextInt();
                t.root = t.insert(value,t.root);
            }
            else if(choice == 2){
                value = sc.nextInt();
                Node exists=t.find(value,t.root);
                if(exists!=null) System.out.println("The given element exists");
                else System.out.println("Got nothing ");
            }
            else if(choice == 3){
                t.display(t.root);
            }
            else if(choice == 4){
                value = sc.nextInt();
                t.root = t.delete(value,t.root);
            }
            else if(choice == 5){
                value = sc.nextInt();
                Node temp = t.predecessor(value,t.root);
                if(temp!=null) System.out.println("Pred is : "+temp.data);
                else System.out.println("NULL");
                System.out.println();
            }
            else if(choice == 6){
                t.levelOrderTraversal(t.root);
                System.out.println();
            }
            else if(choice == 7){
                t.dfsIterative(t.root);
                System.out.println();
            }
            else if(choice == 8){
                Queue q = new LinkedList();
                q.add(t.root);
                t.bfsRecursive(q);
            }
            else if(choice == 9){
                System.out.println("Height of the tree : " + height(t.root));
            }
            else if(choice == 10){
                int val = sc.nextInt();
                System.out.println("Level of node : " + level(val,1,t.root));
            }
            else if(choice == 11){
                System.out.println("isCompleteTree " + isCompleteTree(t.root));
            }
            else if(choice == 12){
                int sum = sc.nextInt();
                System.out.println("Path exists : " + pathSum(t.root,sum));
            }
            else if(choice == 13){
                //Find the diameter 
                /*
                diameter(t.root,0);
                System.out.println("Diameter of the tree is : " + diameter);
                */
                int res = height(t.root.right) + height(t.root.left) + 1;
                System.out.println("Diameter of the tree is : " + res);
            }
            else if(choice == 14){
                /*
                int val1 = sc.nextInt();
                Node n1 = find(val1,t.root);
                int val2 = sc.nextInt();
                Node n2 = find(val2,t.root);
                */
            }
        }
        sc.close();
    }
}