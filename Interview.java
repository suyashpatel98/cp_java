abstract class Vehicle{
	String color;
	int speed;
	public void setSpeed(){
		this.speed = speed;
	}
	public abstract void setColor(String color);
}

public class Interview extends Vehicle{
	public void setColor(String color){
		this.color = color;
	}
	public static void main(String[] args) {
		Vehicle i = new Interview();
		i.setColor("white");
		System.out.println(i.color);
	}
}