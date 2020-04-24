package phonebook;

public class PhoneInfoUnivInfo extends PhoneInfoAdv {

	String major;
	String year;
	
	{
		major=null;
		year=null;
	}
	
	public PhoneInfoUnivInfo(String name,String PhoneNumber,String address, String email, String major, String year) {
		super(name,PhoneNumber,address,email);
		this.major=major;
		this.year=year;
				
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("전공 - "+this.major+" 학년 - "+this.year);	
	}	
	
	
	
	
}
