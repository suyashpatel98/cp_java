/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int min = Integer.MAX_VALUE;
    static int[][] visit;
    public static boolean isSafe(int i,int j,int n,int m){
        return (i< n && j<m && i>=0 && j>=0);
    }
    public static void f(int i,int j,int x,int y,int count){
        if(i == x && j == y){
            if(count < min){
                min = count;
            }
            return;
        }
        visit[i][j] = 1;
        if(isSafe(i+2,j+1,visit.length,visit[0].length) && visit[i+2][j+1] == 0){
            
            f(i+2,j+1,x,y,count+1);
        }
        if(isSafe(i+2,j-1,visit.length,visit[0].length) && visit[i+2][j-1] == 0){
            f(i+2,j-1,x,y,count+1);
        }
        if(isSafe(i+1,j+2,visit.length,visit[0].length) && visit[i+1][j+2] == 0){
            f(i+1,j+2,x,y,count+1);
        }
        if(isSafe(i+1,j-2,visit.length,visit[0].length) && visit[i+1][j-2] == 0){
            f(i+1,j-2,x,y,count+1);
        }
        if(isSafe(i-2,j+1,visit.length,visit[0].length) && visit[i-2][j+1] == 0){
            f(i-2,j+1,x,y,count+1);
        }
        if(isSafe(i-2,j-1,visit.length,visit[0].length) && visit[i-2][j-1] == 0){
            f(i-2,j-1,x,y,count+1);
        }
        if(isSafe(i-1,j+2,visit.length,visit[0].length) && visit[i-1][j+2] == 0){
            f(i-1,j+2,x,y,count+1);
        }
        if(isSafe(i-1,j-2,visit.length,visit[0].length) && visit[i-1][j-2] == 0){
            f(i-1,j-2,x,y,count+1);
        }
        visit[i][j] = 0;
        return;
    }
	public static void main (String[] args) throws IOException{
		//Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int k=0;k<t;k++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
		    int s1 = Integer.parseInt(st.nextToken());
		    int s2 = Integer.parseInt(st.nextToken());
		    int d1 = Integer.parseInt(st.nextToken());
		    int d2 = Integer.parseInt(st.nextToken());
		    visit = new int[n][m];
		    f(s1,s2,d1,d2,0);
		    System.out.println(min);
		    min = Integer.MAX_VALUE;
		}
	}
}