package collectionframework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// List<E> -> ArrayList<E>
		// List<E> : 저장 순서를 가진다. 데이터의 중복 저장 가능
		// 순서 -> 일괄처리(반복 적인 동일한 작업을 빠르게 처리할수있다)
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		//ArrayList<Integer> list = new ArrayList<>(); 
		//인스턴스 생성시에 자료형 생략가능 1.7 이후
		//List<Integer> list = new ArrayList<>();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		
		// List<E> 정의된 메서드 --> 
		//add(E) : 인스턴스의 저장
		//remove(index) : 해당 index의 요소를 삭제
		//size() : List 요소의 개수를 반환
		//get(index) : 해당 index 위치의 요소 반환

		list.add(new Integer(20));
		list.add(new Integer(10));
		list.add(new Integer(30));

		// 데이터의 참조
		System.out.println("1차 참조");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		
		// 데이터의 삭제
		list.remove(0);
		System.out.println("2차 참조");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

	}

}
