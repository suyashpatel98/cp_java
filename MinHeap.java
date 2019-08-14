import java.util.*;

public class MinHeap{
	static int size = 0,capacity = 10;
	static int[] arr = new int[capacity];
	public static void ensureCapacity(){
		if(size == capacity){
			arr = Arrays.copyOf(arr, capacity*2);
			capacity *= 2;
		}
	}
	public static void swap(int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static int peek(){
		if(size == 0)	throw new IllegalStateException("Size is 0");
		return arr[0];
	}
	public static int poll(){
		if(size == 0)	throw new IllegalStateException("Size is 0");
		int item = arr[0];
		arr[0] = arr[size-1];
		size--;
		heapifyDown();
		return item;
	}
	public static boolean hasParent(int i){
		if((i-1)/2 >= 0) return true;
		return false;
	}
	public static boolean hasChildren(int i){
		if((2*i+1) < size) return true;
		return false;
	}
	public static void add(int item){
		ensureCapacity();
		arr[size] = item;
		size++;
		heapifyUp();
	}
	public static void heapifyUp(){
		int i = size-1;
		while(hasParent(i) && arr[i] > arr[(i-1)/2]){
			swap(i,(i-1)/2);
			i = (i-1)/2;
		}
	}
	public static void heapifyDown(){
		int i = 0;
		while(hasChildren(i)){
			int smaller = 2*i+1;
			if((2*i+2) < size && arr[2*i+2] < arr[2*i+1]){
				smaller = 2*i+2;
			}
			if(arr[i] < arr[smaller]) break;
			else{
				swap(i,smaller);
				i = smaller;
			}
		}
	}
	public static void main(String[] args) {
		
	}
}