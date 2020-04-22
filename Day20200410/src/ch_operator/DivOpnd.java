package ch_operator; //ASCII 문자에 포함되어 있는 소문자로 명명 - 차후 생성시 수정
                             //ch_operator 
public class DivOpnd {
	//클래스 이름은 명사이어야 하며, 복합 단어일 경우, 
	// 각 단어의 첫 글자는 대문자이어야 한다.
	//클래스 이름은 간단하고 명시적으로 작성해야 한다.
	//완전한 단어를 사용하고 두 문자어와 약어는 피하도록 한다

	
	public static void main(String[] args) {
		
		int nNum1 = 7;
		int nNum2 = 3;
		
		// 정수의 나누기 연산
		System.out.println("nNum1 / nNum2 = "+nNum1/nNum2);

		// 실수의 나누기 연산
		System.out.println("nNum1 / nNum2 = "+7.0f/3.0f);
		System.out.println("nNum1 / nNum2 = "+(float)7/3);

	}

}
