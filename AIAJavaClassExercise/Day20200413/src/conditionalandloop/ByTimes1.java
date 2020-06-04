package conditionalandloop;

public class ByTimes1 {

	public static void main(String[] args) {
		// 구구단
		
		System.out.println("[for]----");
		
		for (int i = 2; i < 10; i++) {
			
			System.out.println("[for]----"+i+"단");
			System.out.println("===========");
			for (int j = 1; j < 10; j++) {
				System.out.println(i+ " x " + j + " = " + i*j);				
			}
			System.out.println("===========");
			
		}
		
		int i=2,j=1;
		
		System.out.println("[While]----");
		
		while (i<10) {
			
			System.out.println("[While]----"+i+"단");
			System.out.println("===========");
			j = 1;			
			while (j<10) {
				
				System.out.println(i+ " x " + j + " = " + i*j);
				j++;
				
			}
			i++;
			System.out.println("===========");
			
		}
		
		
		

	}

}
