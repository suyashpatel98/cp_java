import java.util.*;

public class QuickSort{
	public void algorithm(int[] arr,int start,int end){
		if(start < end){
			int pIndex = partition(arr,start,end);
			algorithm(arr,start,pIndex-1);
			algorithm(arr,pIndex+1,end);
		}
	}
	public int partition(int[] arr,int start,int end){
		int pivot = arr[end];
		int i=start-1;
		int j,temp;
		for(j=start;j<=end-1;j++){
			if(arr[j] <= pivot){
				i++;
				//swap arr[j] and arr[i]
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		//swap arr[i+1] with arr[end]
		temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		return i+1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int i;
		for(i=0;i<arr.length;i++) arr[i] = sc.nextInt();
		QuickSort q = new QuickSort();
		q.algorithm(arr,0,arr.length-1);
		System.out.println();
		System.out.println();
		for(int k : arr) System.out.print(k + " ");
	}
}