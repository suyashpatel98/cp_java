import java.util.*;

public class Student1 implements Comparable<Student1>{
	int age;
	String name;
	public Student1(int age,String name){
		this.age = age;
		this.name = name;
	}
	public int compareTo(Student1 other){
		int result; 
		if(this.name.compareTo(other.name) != 0) return this.name.compareTo(other.name);
		else if(this.age > other.age) result = -1;
		else result = 1;
		return result;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Student1> al = new ArrayList<Student1>();
		int i = 2;
		while(i>0){
			int age = sc.nextInt();
			String name = sc.next();
			Student1 s = new Student1(age, name);
			al.add(s);
			i--;
		}
		Collections.sort(al);
		for(Student1 s : al){
			System.out.println(s.age + " " + s.name);
		}
	}
}