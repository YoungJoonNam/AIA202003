package exception;

public class DivideByZero {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 2;
		
		try {
			int divide = num1/num2;
			System.out.println(divide);
			
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없어요");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		

	}

}
