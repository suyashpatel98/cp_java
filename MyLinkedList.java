import java.util.*;

public class MyLinkedList{
        private Node head;
        private int size;

        public class Node{
            Object data;
            Node next;
            public Node(Object data){
                this.data = data;
                this.next=null;
            }
            public Node(Object data, Node next){
                this.data = data;
                this.next = next;
            }
        }

        public MyLinkedList(){
            size=0;
        }
        public MyLinkedList(Node head){
            this.head = head;
            size = 1;
        }
        public MyLinkedList(Object data){
            head = new Node(data);
            size = 1;
        }
        public Node getHead(){
            return head;
        }
        public int getSize(){
            return size;
        }
        public void setHead(Node head){
            this.head = head;
        }
        /*
        public void add(Object data){
            Node n = new Node(data);
            n.next = head;
            head = n;
            size++;
        }
        public void addLast(Object data){
            if(head==null){
                add(data);
            }
            else{
                Node x = head;
                while(x.next!=null){
                    x=x.next;
                }
                x.next = new Node(data);
                x.next.next = null;
                size++;
            }
        }
        */
        public void add(int index,Object data){
            if(index<0 || index > size) return;
            if(size==0){
                head = new Node(data);
                size = 1;
            }
            else{
                Node n = new Node(data);
                Node x = head;
                for(int i=0;i<index;i++){
                    x=x.next;
                }
                n.next = x;
                head = n;
                size++;
            }
        }
        public void display(){
            Node x= head;
            while(x.next!=null){
                System.out.println(x.data);
                x=x.next;
            }
            System.out.println(x.data);
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice,value;
            MyLinkedList l = new MyLinkedList();
            while(true){
                System.out.println("Enter choice :");
                choice = sc.nextInt();
                if(choice==-1){
                    break;
                } 
                else if(choice==1){
                    value = sc.nextInt();
                    l.add(0,value);
                }
                else if(choice == 2) l.display();
                else if(choice==3) System.out.println("Size : "+l.getSize());
            }
            sc.close();
        }
}