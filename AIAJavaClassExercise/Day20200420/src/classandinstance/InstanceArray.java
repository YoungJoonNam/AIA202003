package classandinstance;

public class InstanceArray {

	public static void main(String[] args) {


		String[] strArr=new String[3];
		strArr[0]=new String("Java");
		strArr[1]=new String("JS");
		strArr[2]=new String("Python");
		for(int i=0; i<strArr.length; i++)
			System.out.println(strArr[i]);
		
		
		System.out.println("문자열의 길이 : " + strArr[0].length());

	}

}
