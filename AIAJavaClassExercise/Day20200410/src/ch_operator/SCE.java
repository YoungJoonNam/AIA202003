package ch_operator;

public class SCE {

	public static void main(String[] args) {
		//Short Circuit Evaluation 테스트
		
		int nNum1=0, nNum2=0;
		boolean bResult;
		
		bResult = (nNum1+=10)<0 && (nNum2+=10)>0;
		System.out.println("bResult = " + bResult);
		System.out.println("nNum1="+nNum1+", num2="+nNum2); 
		
		
		bResult = (nNum1+=10)>0 || (nNum2+=10)>0; 
		
		System.out.println("bResult="+bResult); 
		System.out.println("num1="+nNum1+", num2="+nNum2);

	}

}
