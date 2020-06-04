package abstractinterface;

//public class PersonalNumberStorageImpl extends PersonalNumberStorage {

//public class PersonalNumberStorageImpl extends Object implements PersonalNumber {
public class PersonalNumberStorageImpl implements PersonalNumber {

	
	PersonalNumInfo[] perArr;
	int numOfPerInfo;

	public PersonalNumberStorageImpl(int sz){
	perArr=new PersonalNumInfo[sz];
	numOfPerInfo=0;
	}

	@Override
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		//perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		numOfPerInfo++;
	}	

	@Override
	public String searchName(String perNum) {
		for (int i = 0; i < numOfPerInfo; i++) {
			if (perNum.compareTo(perArr[i].getNumber()) == 0)
				return perArr[i].getName();
		}
		return null;
	}

}
