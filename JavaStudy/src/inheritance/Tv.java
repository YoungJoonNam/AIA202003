package inheritance;

public class Tv {

	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	void display() {
		System.out.println("Tv Display");
	}
}
