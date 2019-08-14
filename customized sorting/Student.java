import java.util.*;

public class Student implements Comparable<Student>{
	String name;
	int age;
	public Student(int age,String name){
		this.age = age;
		this.name = name;
	}
	public int compareTo(Student other){
		int result;
		if(this.age > other.age) result = -1;
		else if(this.age < other.age) result = 1;
		else{
			return this.name.compareTo(other.name);
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> al = new ArrayList<Student>();
		int i=3;
		while(i>0){
			int age = sc.nextInt();
			String name = sc.next();
			Student s = new Student(age, name);
			al.add(s);
			i--;
		}
		Collections.sort(al);
		for(Student s : al){
			System.out.println(s.age + " " + s.name);
		}
	}
}