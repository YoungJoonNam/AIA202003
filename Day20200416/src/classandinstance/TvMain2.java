package classandinstance;

public class TvMain2 {

	public static void main(String[] args) {

		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
	
		System.out.println("======================");
		System.out.println("t1의 channel : " + tv1.channel);
		System.out.println("t2의 channel : " + tv2.channel);
		tv1.channel = 7; // channel 값 7
		System.out.println("----------------------------------");
		System.out.println("t1의 channel값을 7로 변경");
		System.out.println("======================");
		System.out.println("t1의 channel : " + tv1.channel);
		System.out.println("t2의 channel : " + tv2.channel);		

	}

}
