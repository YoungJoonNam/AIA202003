package collectionframework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<String>();
		//HashSet<String> set = new HashSet<>();
		//Set<String> set = new HashSet<>();
		
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");
		
		System.out.println("저장된 데이터 수 : "+set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
		
		HashSet<SimpleNumber> set1 = new HashSet<SimpleNumber>();
		
		set1.add(new SimpleNumber(10));
		set1.add(new SimpleNumber(20));
		set1.add(new SimpleNumber(10));

		System.out.println("저장된 데이터 수 : "+set1.size());
		
		Iterator<SimpleNumber> itr1 = set1.iterator();
		
		while(itr1.hasNext())
			System.out.println(itr1.next());
		
	}

}

class SimpleNumber {
	int num;

	public SimpleNumber(int n) {
		this.num = n;
	}

	public String toString() {
		return String.valueOf(num);
		//static 메소드인 valueOf는 기본 자료형 데이터를 String 인스턴스로 변환
	}
	
	//
	
	
	@Override
	public int hashCode() {
		return this.num/2;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		// num 값을 비교
		if(obj instanceof SimpleNumber) {
			SimpleNumber sm = (SimpleNumber)obj;
			result = this.num == sm.num;
		}
		
		
		return result;		
	}
}

