import java.util.*;

class Test{
	public static void main(String[] args) {
		B t = new B();
	}
}

class A{
	public int a = 10;
	A(){
		System.out.println("inside A");
	}
}

class B extends A{
	B(){
		System.out.println("B constructor exected");
	}
}