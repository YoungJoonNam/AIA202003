package thread;

public class CountThread extends Thread {

	@Override
	public void run() {

		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			
			try {
				sleep(1000);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("10초 동안 입력이 없어 프로그램을 종료합니다.");
		System.exit(0);
	}

}
