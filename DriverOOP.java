public class DriverOOP {
	public static void main(String[] ars){
//		new C().show();
		A obj = new C();
		System.out.println(obj.x);
		obj.display();
		B obj1 = (B) obj;
		System.out.println(obj1.x);
	}
}

class A{
	public int x = 1;
	public void display(){
		System.out.println("one");
	}
}
class B extends A{
	public int x = 10;
	public void display(){
		System.out.println("two");
	}
}
class C extends B{
	public int x = 20;
	public void display(){
		System.out.println("three");
	}
	public void show(){
		int x = 0;
		System.out.println(x);
		C c = new C();
		System.out.println(c.x);
		System.out.println(super.x);
		A a = (A) this;
		System.out.println(a.x);
	}
}