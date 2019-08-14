import java.util.*;

public class InternDP{
	public static int gen(int[] arr,int sum,int[][] res,int n){
		int i=0,j=0,MAX=100000;
		for(i=0;i<=sum;i++) res[0][i] = MAX;
		for(i=0;i<=n;i++) res[i][0] = 0;
		for(i=1;i<=n;i++){
			for(j=1;j<=sum;j++){
				if(j<arr[i-1]) res[i][j] = res[i-1][j];
				else res[i][j] = min(res[i-1][j-arr[i-1]]+1,res[i-1][j]);
			}
		}
		return res[n][sum];
	}
	public static int min(int a,int b){
		return a > b ? b : a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		int[][] res = new int[n+1][sum+1];
		System.out.println(gen(arr,sum,res,n));
	}
}