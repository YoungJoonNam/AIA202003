package thread;

public class ThreadMain1 {

	public static void main(String[] args) {
		
		// 쓰레드 인스턴스 생성
		ShowThread st1 = new ShowThread("야옹 쓰레드");
		ShowThread st2 = new ShowThread("멍멍 쓰레드");

		
		// 쓰레드의 실행 : 새로운 프로그램 코드 실행의 흐름
		st1.start();
		st2.start();
	}

}
