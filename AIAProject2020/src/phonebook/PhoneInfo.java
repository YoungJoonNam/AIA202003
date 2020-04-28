package phonebook;

public class PhoneInfo {

	protected String name;
	protected String phoneNumber;
	protected String email;
	
	{
		name = "";
		phoneNumber = "";		
		email="";
	}
	
	PhoneInfo(){
		
	}
	
	PhoneInfo(String name, String phoneNumber, String email){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
		
	void DoPrintPhoneInfo() {
				
		System.out.println("이름 - "+name+" 전화번호 - "+phoneNumber+" 이메일 - "+email);
				
	}		
	
	void SetInfo(String name, String phoneNumber, String email){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
}
