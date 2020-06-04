package abstractinterface;

class PersonalNumInfo {
	
	String name;
	String number;

//	public PersonalNumInfo(String name, String number) {
//		this.name = name;
//		this.number = number;
//	}

	
	public PersonalNumInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}

	String getName() {
		return name;
	}

	String getNumber() {
		return number;
	}
}
