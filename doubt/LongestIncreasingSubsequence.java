import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Crap{
    public static HashMap<Integer,Integer> h;
    public static int max(int a,int b){
        return a > b ? a : b;
    }
    public static int f(int[] arr,int i,int n,int prev){
        // System.out.println("i is "+i);
        if(i <= -1) return 0;
        if(!h.containsKey(i)){
            int include = 0;
            if(arr[i] < prev){
                include = 1 + f(arr,i-1,n,arr[i]);
            } 
            int exclude = f(arr,i-1,n,prev);
            h.put(i,max(include,exclude));
        }
        /* 
        System.out.println("-----");
        int j=0;
        for(Map.Entry e : h.entrySet()){
            System.out.println(arr[j] + " "+ e.getValue()+ " ");
            j++;
        }
        j=0;
        System.out.println("-----");
        //System.out.println("--------"+ (int)h.get(i));
        */
        return (int)h.get(i);
    }
	public static void main(String[] args) {
        int arr[] = { 0, 8,4,12};
        h = new HashMap<Integer,Integer>();
        System.out.println(f(arr,arr.length-1,arr.length,Integer.MAX_VALUE));
	}
}

