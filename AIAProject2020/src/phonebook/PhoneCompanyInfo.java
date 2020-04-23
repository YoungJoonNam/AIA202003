package phonebook;

public class PhoneCompanyInfo extends PhoneInfoAdv {

	String company;
	
	
	{
		company=null;		
	}
	
	public PhoneCompanyInfo(String name,String PhoneNumber,String address, String email, String company) {
		super(name,PhoneNumber,address,email);
		this.company=company;
	}
	
	@Override
	void DoPrintPhoneInfo() {				
		super.DoPrintPhoneInfo();
		System.out.println("회사 - "+this.company);	
	}	
	
}
