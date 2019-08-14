import java.util.*;

public class Dp{
	public int fib(int n,int[] mem){
		if(n<=0) return 0;
		else if(n==1) return 1;
		else if(mem[n]==0) mem[n] = fib(n-1,mem) + fib(n-2,mem);
		return mem[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] mem = new int[n+1];
		Dp o = new Dp();
		System.out.println(o.fib(n,mem));
	}
}