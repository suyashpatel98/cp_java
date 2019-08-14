import java.util.*;

public class Try{
	public int countWays(int steps,int count){
		if(steps<=0) return count;
		else if(steps==1) return count+1;
		else if(steps==2) return count+2;
		else if(steps==3) return count+4;
		else return countWays(steps-3,count+4)+countWays(steps-2,count+2)+countWays(steps-1,count+1);
	}
	public int countWays2(int steps,int count){
		if(steps<=0) return count;
		else if(steps==1) return count+1;
		else if(steps==2) return count+2;
		else if(steps==3) return count+4;
		else return countWays2(steps-3,count)+countWays2(steps-2,count)+countWays2(steps-1,count);
	}
	public static void main(String[] args) {
		Try t = new Try();
		System.out.println(t.countWays2(7,0));
	}
}

