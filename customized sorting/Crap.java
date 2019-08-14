import java.lang.*;
import java.util.*;

public class Crap{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[5];
		int i;
		for(i=0;i<arr.length;i++){
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		for(i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}