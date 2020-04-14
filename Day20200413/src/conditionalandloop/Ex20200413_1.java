package conditionalandloop;

public class Ex20200413_1 {

	public static void main(String[] args) {
//		문제1.
//		아래 예제는 두 개의 if문을 사용하고 있다. 한 개의 if 문만 사용하는 방식으로 변경해보자.
//
//		class IfReit {
//		public static void main(String[] args) {
//		int num=120;
//		if(num>0) {
//			if((num%2)==0)
//				System.out.println("양수이면서 짝수");
//			}
//		}
		
		System.out.println("\n[문제1]-----------------\n");
		int num=120;
		if((num>0) &&((num%2)==0)) {			
				System.out.println("양수이면서 짝수");
		}		
//
//
//
//		문제2.
//		다음과 같이 출력이 이루어지도록 작성해보자.
//		num < 0 이라면 “0 미만” 출력
//		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
//		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
//		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
//		300 ≤ num 이라면 “300이상 “ 출력
//
		System.out.println("\n[문제2]-----------------\n");
		System.out.println("num = "+num);
		if(num >= 300) {
			System.out.println("300 이상");
		}
		else if(num >=200) {
			System.out.println("200 이상 300 미만");			
		}
		else if(num >=100) {
			System.out.println("100 이상 200 미만");			
		}
		else if(num >=0) {
			System.out.println("0 이상 100 미만");			
		}
		else {
			System.out.println("0 미만");			
		}
		
		
//
//		문제3.
//		CondOp.java를 조건연산자(3항 연산자)를 사용하지 않고,
//		if~else를 사용하는 형태로 변경해 보자.
//
//		class CondOp {
//		public static void main(String[] args) {
//		int num1=50, num2=100;
//		int big, diff;
//		big = (num1>num2)? num1:num2;
//		System.out.println(big);
//		diff = (num1>num2)? num1-num2: num2-num1;
//		System.out.println(diff);
//		}
//		}
//
		System.out.println("\n[문제3]-----------------\n");
		int num1=50, num2=100;
		int big, diff;
				
		if ((num1>num2)) {
			big = num1;
		}
		else {
			big = num2;			
		}
		System.out.println(big);
		diff = (num1>num2)? num1-num2: num2-num1;
		
		if ((num1>num2)) {
			diff = num1-num2;
		}
		else {
			diff = num2-num1;			
		}
		
		System.out.println(diff);
//
//
//
//		문제 4.
//		SwitchBreak.java를 switch문이 아닌, if~else를 사용하는 형태로 변경해 보자.
//
//		class SwitchBreak {
//		public static void main(String[] args) {
//		int n=3;
//		switch(n) {
//		case 1:
//		System.out.println("Simple Java");
//		break;
//		case 2:
//		System.out.println("Funny Java");
//		break;
//		case 3:
//		System.out.println("Fantastic Java");
//		break;
//		default:
//		System.out.println("The best programming language");
//		}
//		System.out.println("Do you like coffee?");
//		}
//		}
//
		System.out.println("\n[문제4]-----------------\n");
		
		int n=3;
		
		if (n==1) {
			System.out.println("Simple Java");
		}
		else if(n==2) {
			System.out.println("Funny Java");
		}
		else if(n==3) {
			System.out.println("Fantastic Java");
		}
		else {
			System.out.println("The best programming language");
		}
		
		System.out.println("Do you like coffee?");
//
//
//
//		문제 5.
//		문제 2의 답안 코드를 switch 문으로 변경하여 보자.
//		num < 0 이라면 “0 미만” 출력 부분은 if문을 사용하고 나머지 조건에 대해 변경하세요.
		//		문제2.
		//		다음과 같이 출력이 이루어지도록 작성해보자.
		//		num < 0 이라면 “0 미만” 출력
		//		0 ≤ num <100 이라면 “0이상 100 미만“ 출력
		//		100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
		//		200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
		//		300 ≤ num 이라면 “300이상 “ 출력
		System.out.println("\n[문제5]-----------------\n");
		
		int num5;
		int sol5=0;
		
		num5 = 22;
		System.out.println("num5 = "+num5);
		
		if(num5 <= 0) {
			System.out.println("0 미만");
		}
		else {
			switch (num5/100) {
			
			case 0:
				System.out.println("0 이상 100 미만");	
				break;
				
			case 1:
				System.out.println("100 이상 200 미만");		
				break;
				
			case 2:
				System.out.println("200 이상 300 미만");
				break;
				
			default:
				System.out.println("300 이상");						
			}
		}

//
//		문제 6.
//		while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성.
//
//
		System.out.println("\n[문제6]-----------------\n");
		
		int num6=1,sum6=0;
		
		while(num6 < 100) {
			sum6 += num6;
			num6++;
		}
		
		System.out.println("1부터 99까지의 합은 "+sum6);
//
//		문제 7.
//		1부터 100까지 출력한 후, 다시 거꾸로 100부터 1까지 출력하는 프로그램을 작성. 
//		while문과 do~while 문을 각각 한번씩 사용해서 작성
//
//
		System.out.println("\n[문제7]-----------------\n");
		
		int num7=0;
		
		while (num7<100) {
			num7++;
			System.out.println(num7);
						
		}
		
		do {
			System.out.println(num7);
			num7--;
			
		} while (num7>=1);
		
//
//		문제 8.
//		1000 이하의 자연수 중에서 2의 배수 이면서 7의 배수인 숫자를 출력하고, 
//		그 출력된 숫자들의 합을 구하는 프로그램을 while 문을 이용해서 작성
//
//
		System.out.println("\n[문제8]-----------------\n");
		
		int num8=0;
		int sum8=0;
		
		while (num8<=1000) {
			
			if(((num8%2)==0) &&((num8%7)==0)) {
				System.out.println(" 2의 배수 이면서 7의 배수인 숫자 : "+num8);
				sum8 += num8;
			}
			num8++;			
		}
		
		System.out.println(" Sum8 = "+sum8);
		
//
//
//		문제 9.
//		for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
//
//
		System.out.println("\n[문제9]-----------------\n");
		
		int sum9=1;
		for (int i = 1; i <= 10; i++) {
			sum9 *= i;	
			//System.out.println(" 1부터 10까지 곱한 값 = "+sum9);
		}
		System.out.println(" 1부터 10까지 곱한 값 = "+sum9);
		
		
//
//		문제 10.
//		for 문을 이용하여 구구단 중 5단을 출력하는 프로그램 작성
//
//
		System.out.println("\n[문제10]-----------------\n");
					
		for (int i = 1; i < 10; i++) {		
			System.out.println("구구단 5단 : 5 x "+i+" = "+5*i);
		}
//
//
//		문제 11.
//		ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성
//
//		class ContinueBasic {
//		public static void main(String[] args) {
//		int num=0;
//		int count=0;
//		while((num++)<100){
//		if(num%5!=0 || num%7!=0)
//		continue;
//		count++;
//		System.out.println(num);
//		}
//		System.out.println("count: " + count);
//		}
//		}
//
//
		System.out.println("\n[문제11]-----------------\n");
		
		int count=0;
				
		for(int num11=1;num11<100;num11++) {
			if(num11%5!=0 || num11%7!=0)
				continue;
			
			count++;	
			System.out.println(num11);						
		}
		System.out.println("count: " + count);
//
//
//		문제 12.
//		자연수 1부터 시작해서 모든 홀수와 3의 배수인 짝수를 더해 나간다. 
//		그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 
//		그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
//		프로그램 내부에 while문을 무한 루프로 구성하여 작성.
//
//
		System.out.println("\n[문제12]-----------------\n");
		
		int num12=1;
		int sum12=0;
		
		while (true) {
			
			if((num12%2!=0)||(num12%3==0)) {
				//System.out.println("합이 1000을 넘어선 값은 "+num12);
				sum12 += num12;
				System.out.println("모든 홀수와 3의 배수인 짝수 "+num12);
				System.out.println("합은 "+sum12);
				if(sum12 > 1000) {
					System.out.println("합이 1000을 넘어선 값은 "+num12);
					System.out.println("그때의 합은 "+sum12);
					break;
				}				
			}	
			num12++;
		}
//
//		문제 13.
//		구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
//		단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
//
//
		System.out.println("\n[문제13]-----------------\n");
		
		for (int i = 2; i <= 9; i++) {			
			for (int j = 1; j <= 9; j++) {				
				if((i%2 == 0)&&(j<=i)) {					
					System.out.println("구구단 "+ i + " x " + j + " = " + i*j);
				}			
			}
		}
				
//
//		문제 14.
//		다음 식을 만족하는 조합을 찾는 프로그램 작성. 
//		A B
//		B A
//		------
//		9 9
//
//		A + B = 9, B = 9-A
//
		System.out.println("\n[문제14]-----------------\n");
		int a14=0,b14=0;
		
		for (int i = 0; i <= 9; i++) {
			a14 = i*10 + (9-i);
			b14 = (9-i)*10 + i;
			System.out.println(a14+" , "+b14);
		}
						
//
//		문제15.
//		n=1 일 때  “현재 인원은 1명 입니다.”
//		n=2 일 때  “현재 인원은 2명 입니다.”
//		n=3 일 때  “현재 인원은 3명 입니다.”
//		n>3 일 때  “현재 많은 사람들이 있습니다.”
//		위의 내용이 출력 되는 프로그램을 작성. 각각 If 문과 switch 문 사용
//
//
		System.out.println("\n[문제15]-----------------\n");
		
		int num15;
		
		num15 = 47;
		
		if(num15>3) {
			System.out.println("현재 많은 사람들이 있습니다.");			
		}
		else if(num15==3) {
			System.out.println("현재 인원은 3명 입니다.");			
		}
		else if(num15==2) {
			System.out.println("현재 인원은 2명 입니다.");			
		}
		else if(num15==1) {
			System.out.println("현재 인원은 1명 입니다.");			
		}
	
		
		switch (num15) {
		case 1:
			System.out.println("현재 인원은 1명 입니다.");				
			break;
		case 2:
			System.out.println("현재 인원은 2명 입니다.");
			break;
		case 3:
			System.out.println("현재 인원은 3명 입니다.");
			break;
		default:
			System.out.println("현재 많은 사람들이 있습니다.");
			break;
		}

		
//
//		문제16.
//		1 부터 99까지의 합을 구하는 프로그램 작성
//		while문, for문, do while 문을 각각 사용

		System.out.println("\n[문제16]-----------------\n");
		
		int num16=1;
		int sum16=0;
		
		while(num16<=99) {
			sum16 += num16;
			num16++;
		}
		System.out.println("while:1부터 99까지의 합은 "+sum16);
				
		sum16=0;
		
		for(num16=1;num16<=99;num16++) {
			sum16 += num16;			
		}
		System.out.println("for:1부터 99까지의 합은 "+sum16);
		
		num16=1;
		sum16=0;
		
		do {
			sum16 += num16;
			num16++;
		}while(num16<=99);
		System.out.println("do while:1부터 99까지의 합은 "+sum16);
	
	}
}
