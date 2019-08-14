import java.util.*;
import java.io.*;

class SubmitTest{
	static HashMap<Long,Long> h;
	public static long fib(long n,HashMap<Long,Long> h,long m){
		if(n == 0){
			h.put((long)0,(long)0);
		}
		if(n == 1){
			h.put((long)1,1%m);
		}   
		if(!h.containsKey(n)) h.put(n,(fib(n-1,h,m))%m + (fib(n-2,h,m))%m);
		return (long) h.get(n)%m;
	}
	public static long fib2(long n,HashMap<Long,Long> h,long m){
		if(n == 0){
			h.put((long)0,(long)1%m);
		}
		if(n == 1){
			h.put((long)1,(long)0);
		}
		if(!h.containsKey(n)) h.put(n,(fib(n-1,h,m))%m + (fib(n-2,h,m))%m);
		return (long) h.get(n)%m;
	}
	public static void main(String[] args) throws IOException{
		try{
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			long[] arr = new long[t];
			int i = 0;
			long a,m,b;
			while(i<t){
				h = new HashMap<>();
				a = sc.nextLong();
				b = sc.nextLong();
				m = sc.nextLong();
				if(a < b) arr[i] = 0;
				if(b == 0) arr[i] = fib2(a,h,m) % m;
				else arr[i] = fib(a-b+1,h,m) % m;
				i++;
			}
			for(i=0;i<arr.length;i++){
				System.out.println(arr[i]);
			}
		}
		catch(Exception e){
			return;
		}
	}
}