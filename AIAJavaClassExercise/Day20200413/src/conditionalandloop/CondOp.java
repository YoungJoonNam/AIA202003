package conditionalandloop;

public class CondOp {

	public static void main(String[] args) {
		//숫자 두 개를 받는다.
		int num1=100, num2=50;
		
		//큰 수 , 차이 값을 저장하는 변수 선언
		int bigNum, diffNum;
		
		//큰 수 구하기
		bigNum = (num1>num2)? num1:num2;
		// big = num1, big = num2
		
		System.out.println(bigNum);
		
		// 두 수의 차이
		diffNum = (num1>num2)? num1-num2: num2-num1;
		
		System.out.println(diffNum);

	}

}
