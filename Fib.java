import java.util.*;

public class Fib{
	public static int fib(int n,HashMap<String,Integer> h){
		String key = new Integer(n).toString();
		if(n == 0 || n == 1){
			if(!h.containsKey(key)) h.put(key,1);
			return 1;
		} 
		if(!h.containsKey(key)){
			h.put(key,fib(n-1,h) + fib(n-2,h));
		}
		return h.get(key);
	}
	public static void main(String[] args) {
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		System.out.println(fib(3,h));
	}
}