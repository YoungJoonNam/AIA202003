
public class Example_Variable {

	public static void main(String[] args) {

		// 1. 정수형 타입의 변수 num1변수를 선언하자
		// 2. 변수 num1에 숫자 데이터 10을 저장하자.
		// 3. 정수형 타입의 변수 num2변수를 선언하고
		// 숫자 20을 대입하자.
		// 4. 정수형 타입의 변수 num3을 선언하고
		// 변수 num1과 num2를 합하는 연산한 결과를
		// 변수 num3에 대입한다.
		// 5. 연산의 결과를 출력하자.

				
		int num1;
		num1 = 0;
		int num2 = 20;
		int num3;
		num3 = num1 + num2;
		System.out.println("The Result is "+num3);
		

	}

}


/* 교재 해답
class UseVariable {
	public static void main(String[] args) {
		int num1;
		num1=10;
		int num2=20;
		int num3=num1+num2;
		System.out.println(num1+"+"+num2+"="+num3);
	}
}
*/