import java.util.*;

class Submit{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Set<String> a = new HashSet<String>();
		Set<String> b = new HashSet<String>();
		String[] result = new String[t];
		String input;
		int j =0;
		while(t>0){
			a.clear();
			b.clear();
			for(int i=0;i<4;i++){
				input = sc.next();
				a.add(input);
			}
			for(int i=0;i<4;i++){
				input = sc.next();
				b.add(input);
			}
			a.retainAll(b);
			if(a.size() >= 2) result[j] = "similar";
			else result[j] = "dissimilar";
			j++;
			t--;
		}
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}