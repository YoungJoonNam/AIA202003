package classandinstance;

public class TvMain {

	public static void main(String[] args) {

		// Tv 인스턴스 생성
		Tv tv = new Tv();
		
		System.out.println("--------------------------");
		System.out.println("Tv 의 속성값. 인스턴스 생성");
		System.out.println("Tv 의 color : "+tv.color);
		System.out.println("Tv 의 전원 : "+tv.power);
		System.out.println("Tv 의 채널 : "+tv.channel);
		
		tv.channel = 11;
		System.out.println("Tv 의 채널 : "+tv.channel);
		
		tv.channelUp();
		System.out.println("Tv 의 채널 : "+tv.channel);
				
		tv.channelSel(100);
		System.out.println("Tv 의 채널 : "+tv.channel);

		tv.channelDown();
		System.out.println("Tv 의 채널 : "+tv.channel);
	}

}