import java.util.*;

public class KnapSack{
	public static int max(int a,int b){
		return a > b ? a : b;
	}
	public static int knapSack(int v[], int w[], int n, int W,HashMap<String,Integer> h){
		if(W < 0) return Integer.MIN_VALUE;
		if(n<0 || W==0) return 0;
		String key = new Integer(n).toString() + "|" + new Integer(W).toString();
		if(!h.containsKey(key)){
			int include = v[n] + knapSack(v, w, n - 1, W - w[n],h);
			int exclude = knapSack(v, w, n - 1, W,h);
			h.put(key,max (include, exclude)) ;
		}
		return h.get(key);
	}
	public static void main(String[] args) {
		int v[] = { 20, 5, 10, 40, 15, 25 };
		int w[] = {  1, 2,  3,  8,  7, 4 };
		int W = 10;
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		System.out.println(knapSack(v,w,v.length-1,W,h));
	}
}