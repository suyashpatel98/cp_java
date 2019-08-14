import java.util.*;

class Submit2{
	public static int min(int a,int b){
		return a < b ? a : b;
	}
	public static int max(int a,int b){
		return a > b ? a : b;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(true){
			a = sc.nextInt();
			b = sc.nextInt();
			if(a == -1 && b == -1) break;
			System.out.println((int)Math.ceil((float)max(a,b)/(min(a,b)+1)));
		}
	}
}