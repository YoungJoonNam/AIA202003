package inheritance;

public class CaptionTv extends Tv {

	String text;
	void caption() {
		System.out.println(text);		
	}
	
	@Override
	void display() {
		System.out.println("CaptionTv Display");
	}
	
	void display_a() {
		System.out.println("CationTv Display_a");
	}
	
	
	
}
