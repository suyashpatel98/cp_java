import java.util.*;

public class PowerSet{
	static Set<ArrayList<Integer>>  cuml;
	public static void f(int[] arr,int n,ArrayList<Integer> s){
		if(n == 0){
			cuml.add(s);
			System.out.println("Adding");
			for(Integer i : s){
				System.out.print( i.intValue() + " ");
			}
			System.out.println();
			return;
		}
		s.add(arr[n-1]);
		f(arr,n-1,s);
		s.remove(s.size()-1);
		f(arr,n-1,s);
	}
	public static void main(String[] args) {
		cuml = new HashSet<ArrayList<Integer>>();
		int[] arr = {1,2,3};
		ArrayList<Integer> s = new ArrayList<Integer>();
		f(arr,arr.length,s);
		if(cuml.isEmpty()) System.out.println("is empty");
		for(ArrayList<Integer> z : cuml){
			System.out.println("New subset");
			for(Integer i : z){
				System.out.print( i.intValue() + " ");
			}
		}
	}
}