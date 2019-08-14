public class K{
	public static int max(int a,int b){
		return a > b ? a : b;
	}
	public static int knapSack(int[] v,int[] w,int W){
		int[][] T = new int[v.length+1][W+1];
		for(int i=1;i<v.length+1;i++){
			for(int j=0;j<W+1;j++){
				if(w[i-1] > j){
					T[i][j] = T[i-1][j];
				}
				else T[i][j] = max(T[i-1][j],v[i-1] + T[i-1][j-w[i-1]]);
			}
		}
		return T[v.length][W];
	}

	public static void main(String[] args) {
		int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };

        // Knapsack capacity
        int W = 10;

        System.out.println("Knapsack value is "
                + knapSack(v, w, W));
	}
}