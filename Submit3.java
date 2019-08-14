import java.util.*;

public class Submit3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t,k,m,resIndex,imp;
		String input,output;
		ArrayList<Character> arr[];
		ArrayList<String> p = new ArrayList<>();
		char[] result;
		while(true){
			t = sc.nextInt();
			if(t == 0) break;
			arr = new ArrayList[t];
			for(int i=0;i<arr.length;i++) arr[i] = new ArrayList<Character>();
			input = sc.next();
			imp = input.length()/t;
			for(int i=0;i<imp;i++){
				j = i;
				while(j<input.length()){
					j = j + imp;
				}
			}



			result = new char[input.length()];
			k =0;
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<imp;j++){

					arr[i].add(input.charAt(k));
					k++;
				}
			}
			m = 0;
			resIndex = 0;
			while(imp > 0){
				for(int i=0;i<arr.length;i++){
					result[resIndex] = arr[i].get(m).charValue();
					resIndex++;
				}
				imp--;m++;
			}
			output = new String(result);
			p.add(output);
		}
		for(int i=0;i<p.size();i++){
			System.out.println(p.get(i));
		}
	}
}