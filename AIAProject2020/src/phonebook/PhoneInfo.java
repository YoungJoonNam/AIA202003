package phonebook;

public class PhoneInfo {

	protected String strPname;
	protected String strPphoneNumber;
	private String strPbirthday;

	{
		strPname = "";
		strPphoneNumber = "";
		strPbirthday = "";
	}
	
	PhoneInfo(){
		
	}
	
	PhoneInfo(String name, String number, String birthday){
		strPname = name;
		strPphoneNumber = number;
		strPbirthday = birthday;
	}
	
	PhoneInfo(String name, String number){
		strPname = name;
		strPphoneNumber = number;		
		strPbirthday = "[사용자미입력]";
		//this(name,number,"[사용자미입력]"); 2020.04.22 수업
	}
	
	
	
	void DoPrintPhoneInfo() {
				
		System.out.println("이름 - "+strPname+" 전화번호 - "+strPphoneNumber+" 생년월일 - "+strPbirthday);
				
	}		
}
