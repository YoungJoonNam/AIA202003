package phonebook;

public class PhoneInfoAdv extends PhoneInfo {
	
	String address;
	String email;
	
	{
		address ="";
		email="";				
	}
	
	public PhoneInfoAdv(String name, String phoneNumber, String address, String email) {
		super(name,phoneNumber);
		this.address=address;
		this.email=email;		
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("주소 - "+this.address+" 이메일 - "+this.email);	
	}		

}
