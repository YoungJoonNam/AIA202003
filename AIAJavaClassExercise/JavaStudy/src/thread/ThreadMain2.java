package thread;

public class ThreadMain2 {

	public static void main(String[] args) {

		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		
		tr1.start();
		tr2.start();
		
		try {
			tr1.join();
			tr2.join();
		} // join() 해당 쓰레드가 종료될 때까지 실행을 멈출 때
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100까지의 합: " + (at1.getNum() + at2.getNum()));

	}

}
