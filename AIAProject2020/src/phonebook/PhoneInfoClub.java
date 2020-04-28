package phonebook;

public class PhoneInfoClub extends PhoneInfo {
	
	String club;
	String location;
	
	{
		club=null;	
		location=null;
	}
	
	public PhoneInfoClub(String name,String PhoneNumber, String email,String club,String location) {
		super(name,PhoneNumber,email);
		this.club=club;
		this.location=location;
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("클럽 - "+this.club+" 위치 - "+this.location);
	}	
		
	void SetInfo(String name,String PhoneNumber, String email,String club,String location) {
		super.SetInfo(name, PhoneNumber, email);
		this.club=club;
		this.location=location;		
	}
}
