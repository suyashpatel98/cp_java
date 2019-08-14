import java.util.*;


class ReverseSort{

	public static void swap(char[] arr,int i,int j){
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	public static void perm(char[] arr, ArrayList<String> al,int start,int end){
		if(start == end){
			String temp = "";
			for(int i=0;i<arr.length;i++){
				temp += arr[i];
			}
			al.add(temp);
			return;
		}
		else{
			for(int i = start;i<=end;i++){
				swap(arr,start,i);
				perm(arr,al,start+1,end);
				swap(arr,start,i);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		String s = "suyah";
		char[] arr = s.toCharArray();
		perm(arr,al,0,arr.length-1);
		Collections.sort(al);
		for(String a : al){
			System.out.println(a);
		}
	}
}