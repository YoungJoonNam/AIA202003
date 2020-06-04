package thread;

public class ThreadMain5 {

	public static void main(String[] args) {
		
		Sum sum = new Sum();
		
		AddThread at1 = new AddThread(sum, 1, 500000);
		AddThread at2 = new AddThread(sum, 500001, 1000000);
		
		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		System.out.println("1~100 까지의 합은 : "+sum.getNum());

	}

}
