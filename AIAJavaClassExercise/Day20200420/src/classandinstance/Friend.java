package classandinstance;

public class Friend {
	
	String myName;
	
	public Friend(String name) {
		myName = name;
	}
	
	//오버라이딩
	@Override
	public String toString() {
		return "제 이름은 " + myName + " 입니다.";
	}
}
