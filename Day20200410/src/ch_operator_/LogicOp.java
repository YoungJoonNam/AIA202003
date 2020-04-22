package ch_operator_;//ASCII 문자에 포함되어 있는 소문자로 명명 - 차후 생성시 수정
							//ch_operator 

public class LogicOp {

	public static void main(String[] args) {
		// 두 변수에 값을 입력 받는다.
		// &&, ||, ==, ! 등 사용, 테스트
		
		int nNum1=10, nNum2=20;
		
		boolean bResult1=(nNum1==10 && nNum2==20);
		boolean bResult2=(nNum1<=12 || nNum2>=30);
		
		System.out.println("-------------------------------------------");
		System.out.println(">> nNum1 : "+nNum1+"   nNum2 : "+nNum2);
		System.out.println("nNum1==10 그리고 nNum2==20: " + bResult1);
		System.out.println("nNum1<=12 또는 nNum2>=30: " + bResult2);
		
		if(!(nNum1==nNum2)) {
			System.out.println("nNum1과 nNum2는 같지 않다.");
		}
		else {
			System.out.println("nNum1과 nNum2는 같다.");
		}
				
		// 성인 여성중 기혼자에게만 메시지를 출력합니다.
		
		int nAge = 20;
		//char cGender = 'w';
		char cGender = 'm';
		boolean bMarriaged = true;
		boolean bResult = (nAge > 19) && (cGender == 'w') && bMarriaged;
		
		if(bResult) {
			System.out.println("\n\n메시지 전송!~");		
		}
		

	}

}
