package thread;

public class ShowThread extends Thread {
	
	String threadName;
	
	public ShowThread(String threadname) {
		this.threadName=threadname;
	}

	@Override
	public void run() {
		for(int i=0; i<100;i++) {
			System.out.println("Hi~." + threadName + " 입니다");
		}
	}
	
	

}
