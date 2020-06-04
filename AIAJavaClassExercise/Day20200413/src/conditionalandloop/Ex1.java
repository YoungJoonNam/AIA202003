package conditionalandloop;

public class Ex1 {

	public static void main(String[] args) {
		// 1~10까지의 합
		// 반복 +1 씩
		
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println(i+" -> Sum = "+sum);			
		}

		
		int i=0;
		sum = 0;
		
		while(i<=10) {
			sum += i;
			i++;
		}
		
		System.out.println("======================= \n 1부터 10까지의 합 : "+sum);
	}

}
