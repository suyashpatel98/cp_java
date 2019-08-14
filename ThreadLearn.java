public class ThreadLearn{
	public static void main(String[] args) {
		//Thread instantiation
		MyThread t = new MyThread();
		t.start();
	}
}

//Defining thread
class MyThread extends Thread{
	public void run(){
		System.out.println("Suyash");
	}
}