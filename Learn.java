import java.util.*;

public class Learn{
	
	public static void main(String[] args) {
		String s = "?suyash .patel";
		String n = s.replace("?","").replace(".","");
		String[] arr = n.split("\\s+");
		for(String i:arr) System.out.println(i);
	}
}