import java.util.*;

public class Try{
	public static void main(String[] args) {
		Trie t = new Trie();
		int i;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(i=0;i<arr.length;i++){
			arr[i] = sc.next();
			t.insert(arr[i],t.root);
		} 
		System.out.println("longestCommonPrefix is : "+t.longestCommonPrefix(t.root));
	}
}

class Node{
	Node[] children = new Node[26];
	int size=0;
}

class Trie{
	Node root;
	public Trie(){
		root = new Node();
	}
	public Node insert(String s,Node root){
		int i;
		Node temp = root;
		for(i=0;i<s.length();i++){
			if(temp.children[s.charAt(i)-'a']==null){
				temp.children[s.charAt(i)-'a'] = new Node();
			}
			temp = temp.children[s.charAt(i)-'a'];
			temp.size++;
		}
		return root;
	}
	public int find(String s,Node root){
		int i,count=0;
		Node temp = root;
		for(i=0;i<s.length();i++){
			if(temp.children[s.charAt(i)-'a'] == null) return 0;
			temp = temp.children[s.charAt(i)-'a'];
		}
		return temp.size;
	}
	public String longestCommonPrefix(Node root){
		Node temp = root;
		String result = "";
		int count = 0,i,index=0;
		while(count<2){
			count = 0;
			for(i=0;i<26;i++){
				if(temp.children[i]!=null){
					count++;
					index = i;
				} 
			}
			if(count<2) result = result + (char)(index+97);
			temp = temp.children[index];
		}
		return result;
	}
}
