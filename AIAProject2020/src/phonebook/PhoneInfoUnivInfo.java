package phonebook;

public class PhoneInfoUnivInfo extends PhoneInfo {

	String address;
	String major;
	String year;
	
	{
		address=null;
		major=null;
		year=null;
	}
	
	public PhoneInfoUnivInfo(String name,String PhoneNumber,String email, String address, String major, String year) {
		super(name,PhoneNumber,email);
		this.address=address;
		this.major=major;
		this.year=year;				
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("주소 - "+this.address+"전공 - "+this.major+" 학년 - "+this.year);	
	}	
	
	void SetInfo(String name,String PhoneNumber,String email, String address, String major, String year) {
		super.SetInfo(name,PhoneNumber,email);
		this.address=address;
		this.major=major;
		this.year=year;				
	}
	
	
	
}
