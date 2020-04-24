package phonebook;

public class PhoneInfoCompanyInfo extends PhoneInfo {

	String company;
		
	{
		company=null;		
	}
	
	public PhoneInfoCompanyInfo(String name,String PhoneNumber, String email,String company) {
		super(name,PhoneNumber,email);
		this.company=company;
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("회사 - "+this.company);	
	}	
	
}
