import java.util.*;

public class MergeSort{
	public void algorithm(int[] arr){
		if(arr.length >=2){
			int mid = arr.length/2,i,k=0;
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for(i=0;i<left.length;i++) left[i] = arr[i];
			for(i=0;i<right.length;i++) right[i] = arr[mid+i]; 
			algorithm(left);
			algorithm(right);
			merge(left,right,arr);
		}
	}
	public void merge(int[] left,int[] right,int[] arr){
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length){
			if(left[i] < right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<left.length){
			arr[k] = left[i];
			i++;k++;
		}
		while(j<right.length){
			arr[k] = right[j];
			j++;k++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		MergeSort m = new MergeSort();
		m.algorithm(arr);
		for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
	}
}