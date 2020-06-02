package phonebook202006;

public class PhoneBCtrl {

	final PhoneBDAO	pd;
	
	
	PhoneBCtrl() {
		pd = new PhoneBDAO();
		pd.Init();
		
	}
		
	int input(PhoneBook pb) {
		int r = 0;

		r = pd.input(pb);
		
		return r;
	}

	int modify(PhoneBook pb) {
		int r = 0;

		r = pd.modify(pb);
		
		//System.out.println(pb.getName()+"  "+pb.getPhoneNumber());
		return r;
	}

	int del(PhoneBook pb) {
		int r = 0;
		
		r = pd.del(pb);

		return r;
	}

	int list() {
		int r = 0;

		// Array 로 ResultSet 값을 받아서 View에 반환하기
		return r;
	}

	int search(String sname) {
		int r = 0;

		// Array 로 ResultSet 값을 받아서 View에 반환하기
		
		return r;
	}

}
