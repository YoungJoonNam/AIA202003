package classandinstance;

public class StringInstance {

	public static void main(String[] args) {
				
		java.lang.String str="My name is Sunny";
		
		int strLen1=str.length();
		System.out.println("길이 1: "+strLen1);
		int strLen2="한글의 길이는?".length();
		//문자열의 선언  인스턴스 생성
		System.out.println("길이 2: "+strLen2);

		
		String str1 = "My String";
		String str2 = "My String";
		String str3 = "Your String";
		if (str1 == str2)
			System.out.println("동일 인스턴스 참조");
		else
			System.out.println("다른 인스턴스 참조");
		if (str2 == str3)
			System.out.println("동일 인스턴스 참조");
		else
			System.out.println("다른 인스턴스 참조");
		
	}

}
