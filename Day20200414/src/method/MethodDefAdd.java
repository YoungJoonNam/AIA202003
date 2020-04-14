package method;

public class MethodDefAdd {

	public static void main(String[] args) {
		
		MyMath math = new MyMath();		
		long result = math.add(10,100);		
		System.out.println(result);		
		System.out.println(math.add(1100000000l, 3393939393l));

		System.out.println("프로그램 시작");
		
		
		hiEveryone(20,180.2);
		hiEveryone(17,162.4);
		hiEveryone(29,200);
		hiEveryone(22,172.3);
		hiEveryone(19,165.3);
		
		
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 20세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 17세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 29세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 22세 입니다.");
//		System.out.println("좋은 아침입니다.");
//		System.out.println("제 나이는 19세 입니다.");
				
		System.out.println("프로그램 종료");
		
	}
	

	// 인사말 출력, 나이 값을 받아서 나이를 출력하는 메서드
	static void hiEveryone(int age, double height) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 "+age+"세 입니다.");
		System.out.println("저의 키는 "+height+"cm 입니다.");
	}
	
	
	
	void add() {
		return;
	}

}
