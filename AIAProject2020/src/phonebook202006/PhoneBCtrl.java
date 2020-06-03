package phonebook202006;

import java.util.ArrayList;

public class PhoneBCtrl {

	final PhoneBDAO	pd;
	
	PhoneBook			pb;
	ArrayList<PhoneBook> arr;
	
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

		return r;
	}

	int del(PhoneBook pb) {
		int r = 0;
		
		r = pd.del(pb);

		return r;
	}

	ArrayList<PhoneBook> list() {
				
		return pd.list();
				
	}

	ArrayList<PhoneBook> search(PhoneBook pb) {
		
		return pd.search(pb);
	}
	
	void end() {
		pd.end();
	}

}
