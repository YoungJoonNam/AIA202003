package exception;

import java.util.Scanner;

public class ProgrammerDefineException {

	public static void main(String[] args) {
		System.out.print("나이를 입력하세요: "); 
		
		try { 
			int age=readAge(); // throws에 의해 이동된 예외처리 포인트 
			System.out.println("당신은 "+age+"세입니다."); }
		catch(AgeInputException e)	{
			System.out.println(e.getMessage());
		}
	}
	public static int readAge() throws AgeInputException {
		// AgeInputException 예외는 던져 버린다.
		
		Scanner keyboard=new Scanner(System.in);
		int age=keyboard.nextInt();
		if(age<0){
			AgeInputException excpt=new AgeInputException();
			throw excpt; //예외상황을 알리는 문장!!!
			// 예외처리 메커니즘 작동!!!
		}
		return age;
	}
}


class AgeInputException extends Exception {
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}