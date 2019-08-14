import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class MergeSortedArrays{
	static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
    static int arr2[] = new int[]{2, 3, 8, 13};
    static void merge(int m, int n){
    	//arr1-m,j
    	int i,j;
    	for(i=arr2.length;i>=0;i--){
    		int last = arr1[arr1.length-1];
    		for(j=arr1.length-2;j>=0 && arr1[j]>arr2[i];j--){
    			arr1[j+1] = arr1[j];
    		}
    		if(j!=arr1.length-2 || last > arr2[i]){
    			//swap
    			arr1[j+1] = arr2[i];
    			arr2[i] = last;
    		}
    	}
    }
	public static void main(String[] args) {
		merge(arr1.length,arr2.length);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
	}
}