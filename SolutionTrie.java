import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionTrie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie t = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")){
                t.root = t.add(contact);
            }
            else System.out.println(t.findPartial(contact));
        }
    }
}

class Node{
        int number_of_characters = 26;
        Node[] children = new Node[number_of_characters];
        int size=0;
}
class Trie{
    Node root = new Node();
    public Node add(String s){
        int i=0;
        Node temp = this.root;
        while(i<s.length()){
            if(temp.children[s.charAt(i)-'a']==null){
                temp.children[s.charAt(i)-'a'] = new Node();
                temp.size++;
                temp = temp.children[s.charAt(i)-'a'];
            }
            else {
                temp.size++;
                temp = temp.children[s.charAt(i)-'a'];
            }
                
            i++;
        }
        return this.root;
    }
    public int findPartial(String s){
        int i=0;
        Node temp = root;
        while(i<s.length()){
            if(temp.children[s.charAt(i)-'a']==null) break;
            temp = temp.children[s.charAt(i)-'a'];
            i++;
        }
        if(i<s.length()) return 0;
        else return temp.size;
    }
}
