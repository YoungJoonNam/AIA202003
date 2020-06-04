package collectionframework;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparablePerson {

	public static void main(String[] args) {
		TreeSet<Person> sTree = new TreeSet<Person>();
		sTree.add(new Person("Lee", 24));
		sTree.add(new Person("Hong", 29));
		sTree.add(new Person("Choi", 21));
	
// 오류발생		
//		TreeSet<PersonA> sTreeA = new TreeSet<PersonA>();		
//		sTreeA.add(new PersonA("ddChoi", 11));
		
		Iterator<Person> itr = sTree.iterator();
		while (itr.hasNext())
			itr.next().showData();

	}

}

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showData() {
		System.out.printf("%s %d \n", name, age);
	}

	public int compareTo(Person p) {
		if (age > p.age)
			return 1;
		else if (age < p.age)
			return -1;
		else
			return 0;
		
		// result = this.age-p.age;
		// result = (this.age-p.age)*-1; //순서의 역전;
		// return result;
		
	}
}


class PersonA  {
	String name;
	int age;

	public PersonA(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void showData() {
		System.out.printf("%s %d \n", name, age);
	}

	
}