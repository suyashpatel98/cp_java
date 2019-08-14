import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionNow {

    static void separateNumbers(String s) {
        // Complete this function
        if(s.length() <= 1) {
            System.out.println("NO");
            return;
        }
        int len = 1,start=0,prev=-1,curr=-1,init=-1;
        while(start < s.length() && len <= s.length()/2 ){
            if(prev >= 0){
                curr = Integer.parseInt(s.substring(start,len+start));
                if(curr != prev + 1){
                    len++;
                    start = 0;
                    prev=-1;curr=-1;
                    continue;
                }
            } 
            if(s.substring(start,len+start).charAt(start) == '0'){
                    len++;
                    start = 0;
                    prev=-1;curr=-1;
                    continue;
            }
            prev = Integer.parseInt(s.substring(start,len+start));
            //System.out.println("Prev : " + prev);
            if(start == 0) init = prev;
            start = start + len;
            if((prev%10) == 9) len++;
        }
        if(!(start < s.length())) System.out.println("YES " + init);
        else System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }
}
