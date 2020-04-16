package method;

import java.lang.Math;

public class Ex20200416_1 {
	
	
	static void doCalc(int nInput1, int nInput2) {
		
		System.out.println(nInput1 + " + " + nInput2 + " = " + (nInput1+nInput2));
		System.out.println(nInput1 + " - " + nInput2 + " = " + (nInput1-nInput2));
		System.out.println(nInput1 + " x " + nInput2 + " = " + (nInput1*nInput2));
		System.out.println(nInput1 + " / " + nInput2 + " = " + (nInput1/nInput2));
		System.out.println(" 나머지 값은 : "+(nInput1%nInput2));
				
		return;	
		
	}
	
	
	static void doAbs(int nInput1, int nInput2) {
		
		int nResult=0;
		if(nInput1>nInput2) {
			nResult = nInput1 - nInput2;			
		}
		else {
			nResult = nInput2 - nInput1;			
		}
		System.out.println(nInput1 + " , " + nInput2 + " 두 값의 절대값은 " + nResult);
	}
	
	static double doCircleArea(double r) {
		return Math.PI*r*r;
	}
	
	static double doCircleCircumference(double r) {
		return 2*Math.PI*r;
	}
	
	static boolean doCheckPrimeNumber(int nInput) {
		boolean bResult;
		
		bResult = true;
		
		for (int i = 2; i <nInput; i++) {
			
			if((nInput % i)==0) {
				bResult = false;
				break;
			}
		}
						
		return bResult;
	}
	
	public static void main(String[] args) {
		

//		문제1
//		두 개의 정수를 전달받아서, 두수의 사칙연산 결과를 출력하는 메서드와 
//		이 메서드를 호출하는 main메서드를 정의해보자.
//		단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.
//
		System.out.println("\n[문제1]-----------------\n");
		doCalc(55,3);
		doCalc(4,13);
		
//
//		문제2.
//		두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 
//		출력하는 메서드와 이 메서드를 호출하는 
//		main메서드를 정의해 보자. 단 메서드 호출 시 전달되는 값의 순서에 
//		상관없이 절대값이 계산되어서 출력되어야 한다.
//
		System.out.println("\n[문제2]-----------------\n");
		doAbs(293,221);
		doAbs(1,5);
//
//		문제3
//		원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 
//		메서드와 원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, 
//		이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)
		
		System.out.println("\n[문제3]-----------------\n");
		
		double dR;
		dR = 4L;
		System.out.println("반지름 "+ dR + "의 넓이는 : " + doCircleArea(dR) + " 의 둘레는" +doCircleCircumference(dR) );
		dR = 1L;
		System.out.println("반지름 "+ dR + "의 넓이는 : " + doCircleArea(dR) + " 의 둘레는" +doCircleCircumference(dR) );
				
//
//		문제4.
//		전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 
//		소수인경우 true를, 소수가 아닌 경우 false를 반환하는 
//		메서드를 정의하고, 이를 이용해서 1이상 100 이하의 소수를 
//		전부 출력할 수 있도록 main 메서드를 정의하자.

		System.out.println("\n[문제4]-----------------\n");
		for (int i = 1; i <= 100; i++) {			
			if(doCheckPrimeNumber(i)) {
				System.out.println("prim number is "+i);
			}			
		}
			
		
	}

}
