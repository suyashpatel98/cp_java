import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Crap{
	public static void main(String[] args) {
        int x = -123;
        String s = x + "";
        StringBuilder s1 = new StringBuilder(s);
        System.out.println(s1);
        StringBuilder s2 = s1.reverse();
        System.out.println(s);
        System.out.println(x);
        System.out.println(s1);
        System.out.println(s2.toString());
        System.out.println(s1.toString().equals(s2.toString()));
	}
}

