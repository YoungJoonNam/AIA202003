package inheritance;

public class BaseEnSpeaker extends Speaker {

	private int baseRate;
	
	@Override
	void showCurrentState() {
		super.showCurrentState();
		System.out.println("베이스 크기: "+baseRate);
	}
	
	void setBaseRate(int base) {
		baseRate=base;
	}
	
	@Override
	public String toString() {
		
		return super.toString();		
	}
}
