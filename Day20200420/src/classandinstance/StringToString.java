package classandinstance;

public class StringToString {
	

	public static void main(String[] args) {

		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");

		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		System.out.println(f1);
		System.out.println(f2);
		
		
	}

}
