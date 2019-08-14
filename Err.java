import java.util.*;

public class Err{
	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("/../","/");
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
	}
}