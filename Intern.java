import java.util.*;

public class Intern{
	public static int min(int a,int b){
		return a > b ? b : a;
	}
	public static int gen(int[] arr,int sum,int n){
		if(sum <= 0) return 0;
		if(n<=0 && sum > 0) return 100000;
		if(sum < arr[n-1]) return gen(arr,sum,n-1);
		return min(gen(arr,sum-arr[n-1],n-1)+1,gen(arr,sum,n-1));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		System.out.println(gen(arr,sum,n));
	}
}