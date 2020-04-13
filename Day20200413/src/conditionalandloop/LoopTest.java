package conditionalandloop;

public class LoopTest {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		System.out.println("-------------------------------");
		
		int i;
		for (i = 1; i < 6; i++) {
			System.out.println(i);
			
		}

		System.out.println("-------------------------------");
		
		i=1;
		while (i<6) {
			System.out.println(i++);
			//i++;
			
		}	
		
		System.out.println("-------------------------------");
		
		i=1;
		
		do {
			System.out.println(i++);
		} while (i<6);
		
		System.out.println("-------------------------------");
	}

}

