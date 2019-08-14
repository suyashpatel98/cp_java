import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Cra {
	static int i = 5;
	public static void change(){
		i++;
		return;
	}
    public static void main(String[] args) {
        change();
        System.out.println(i);
    }
}