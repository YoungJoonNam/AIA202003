package abstractinterface;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
		
//		PersonalNumberStorage storage=new PersonalNumberStorageImpl(100);
	
//		storage.addPersonalInfo("손흥민", "202020-1111111");
//		storage.addPersonalInfo("박지성", "201010-1000000");
//
//		System.out.println(storage.searchName("202020-1111111"));
//		System.out.println(storage.searchName("201010-1000000"));
//		
		PersonalNumber pn = new PersonalNumberStorageImpl(100);
		
		pn.addPersonalInfo("손흥민", "202020-1111111");
		pn.addPersonalInfo("박지성", "201010-1000000");

		System.out.println(pn.searchName("202020-1111111"));
		System.out.println(pn.searchName("201010-1000000"));
		

	}

}
