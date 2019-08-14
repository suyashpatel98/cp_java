import java.util.*;

public class TempSolution {
    static Set<ArrayList<Integer>> cuml ;
    public static void f(int[] arr, int n, ArrayList<Integer> temp){
        if(n==0){
            cuml.add(temp);
            return;
        }
        temp.add(arr[n-1]);
        f(arr,n-1,temp);
        temp.remove(temp.size()-1);
        f(arr,n-1,temp);
    }
    public static ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int res = 1;
        System.out.println("Size : " + cuml.size());
        for(ArrayList<Integer> z : cuml){
            System.out.println("in for");
            res = 1;
            if(z.isEmpty())System.out.println("suyash");
            for(Integer i:z){
                System.out.println("MUl" + i.intValue());
                res = res * i.intValue();
            }
            if(res != 1){
                ret.add(res);
                System.out.println("Adding");
            }
        }
        Collections.sort(ret);
        System.out.println("Size ret: " + ret.size());
        ArrayList<Integer> fret = new ArrayList<Integer>();
        /*
        for(int j=0;j<D;j++){
            fret.add(ret.get(j));
        }
        */
        return fret;
    }
    public static void main(String[] args) {
        ArrayList<Integer> fret;
        int[] arr = new int[3];
        arr[0] = 2;
        arr[1] = 5;
        arr[2] = 11;
        cuml = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        f(arr,arr.length,temp);
        fret = solve(2,5,11,3);
    }
}
