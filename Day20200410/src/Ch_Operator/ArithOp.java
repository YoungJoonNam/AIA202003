package Ch_Operator; //ASCII 문자에 포함되어 있는 소문자로 명명 - 차후 생성시 수정
							 //ch_operator 
public class ArithOp {

	public static void main(String[] args) {
		// 1. 정수 타입의 숫자 두 개를 입력 받는다. -> 변수 선언.
		int nNum1;
		int nNum2;
		
		nNum1 = 110;
		nNum2 = 27;
		
		// 2. 덧셈 연산 후 결과를 출력한다.
		int nResult = nNum1 + nNum2;
		System.out.println("nNum1 + nNum2 = " + nResult);
		
		// 3. 뺄셈 연산 후 결과를 출력한다.
		nResult = nNum1 - nNum2;
		System.out.println("nNum1 - nNum2 = " + nResult);
		
		// 4. 곱셈 연산 후 결과를 출력한다.
		nResult = nNum1 * nNum2;
		System.out.println("nNum1 * nNum2 = " + nResult);

		// 5. 나눗셈 연산 후 결과를 출력한다.
		nResult = nNum1 / nNum2;
		System.out.println("nNum1 / nNum2 = " + nResult);
		
		// 6. 나머지 연산 후 결과를 출력한다.		
		nResult = nNum1 % nNum2;
		System.out.println("nNum1 % nNum2 = " + nResult);
	}

}
