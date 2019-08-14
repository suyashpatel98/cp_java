/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        House[] arr = new House[n];
        String fType = s.next();
        String sType = s.next();
        int sleepType;
        char foodType;
        for(int i=0;i<arr.length;i++){
            sleepType = (int)sType.charAt(i);
            foodType = (char) fType.charAt(i);
            arr[i] = new House(sleepType,foodType);
        }
        int q,l,r,result;
        int count;
        Double d;
        q = s.nextInt();
        for(int k =0;k<q;k++){
            count = 0;
            l = s.nextInt();
            l--;
            r = s.nextInt();
            r--;
            for(int i=l;i<=r;i++){
                for(int j=i+1;j<=r;j++){
                    if(arr[i].sleepType == arr[j].sleepType || arr[i].foodType == arr[j].foodType)  count++;
                }
                d = new Double(count%(Math.pow(10,9)+7));
                count = d.intValue();
            }
            System.out.println(count);
        }
        
    }
}

class House{
    int sleepType;
    char foodType;
    public House(int sleepType,char foodType){
        this.sleepType=sleepType;
        this.foodType=foodType;
    }
}