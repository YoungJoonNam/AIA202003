package classandinstance;

public class Tv {

	// Tv의 속성(변수) -> 멤버 변수, 인스턴스 변수
	String color;			// Tv 색상 값 
	boolean power;		// Tv의 전원 상태
	int channel;			// Tv의 채널 값
	
	
	// Tv의 기능 -> 메서드, 클래스의 멤버
	// Tv의 전원을 키고 끄는 기능	
	void power() {
		power = !power;
	}
	
	void channelDown() {
		++channel;
	}
	
	void channelUp() {
		--channel;
	}
	
	void channelSel(int nChannel) {
		channel = nChannel;
	}
}
