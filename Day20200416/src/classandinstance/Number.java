package classandinstance;

public class Number {

	int num;
	
	// 생성자
	Number(int n){
		System.out.println("생성자 호출");
		num = n;
	}
		
	
	public static void main(String[] args) {

		
		Number n1 = new Number(12);
		System.out.println(n1.num);
		
	}

}
