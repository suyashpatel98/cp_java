//Sort the array of strings according to the number of a s they have in ascending order.
import java.util.*;
public class Exam{
	public static void main(String[] args) {
		List<Student> l = new ArrayList<Student>();
		Student s1 = new Student("Suyash");
		Student s2 = new Student("Suyaaaash");
		Student s3 = new Student("Suyaash");
		l.add(s1);l.add(s2);l.add(s3);
		Collections.sort(l,new NameComparator());
		for(Student s : l){
			System.out.println(s.name);
		}
	}
}

class Student {
	String name;
	public Student(String name){
		this.name = name;
	}
}

class NameComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2){
		int count1=0,count2=0;
		int i;
		for(i=0;i<s1.name.length();i++){
			if(s1.name.charAt(i)=='a') count1++;
		}
		for(i=0;i<s2.name.length();i++){
			if(s2.name.charAt(i)=='a') count2++;
		}
		if(count1 < count2) return -1;
		else if (count1 == count2) return 0;
		else return 1;
	}
}