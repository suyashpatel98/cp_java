import java.util.*;

class PnC{

	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void perm(int[] arr, int l,int r){
		if(l == r){
			System.out.println();
			for(int i=0;i<arr.length;i++){
				System.out.print(" " + arr[i]);
			}
		}
		else{
			for(int i=l;i<=r;i++){
				swap(arr,l,i);
				perm(arr,l+1,r);
				swap(arr,l,i);
			}
		}
	}
	static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end ; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
 
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];
 
        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

	public static void main(String[] args) {
		//int[] arr = {1,2,3,4};
		//perm(arr,0,arr.length-1);
		int arr[] = {1, 2, 3, 4, 5};
        int r = 4;
        int n = arr.length;
        printCombination(arr, n, r);
		
	}
}