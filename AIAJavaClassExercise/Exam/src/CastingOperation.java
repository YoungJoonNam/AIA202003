
public class CastingOperation {

	public static void main(String[] args) {
		char ch1='A'; //문자타입의 변수 ch1 선언, 초기화, 'A' 저장
							
		char ch2='Z'; 
		int num1=ch1;
		int num2=(int)ch2;
		System.out.println("문자 A의 유니코드 값: "+num1);
		System.out.println("문자 Z의 유니코드 값: "+num2);
	}

}
