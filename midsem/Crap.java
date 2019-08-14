
public class Crap
{	
	public void print(){
		System.out.println("Suyash");
	}
	static class Inner{
		private static int a = 10;
		public void p(){
			System.out.println("Inner");
			Crap obj = new Crap();
			obj.print();
		}
	}
	public static void main(String args[]){
		Crap.Inner c = new Crap.Inner();
		c.p();
	}
}

