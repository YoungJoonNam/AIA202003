package classandinstance;

public class Ex20200417_2 {

	public static void main(String[] args) {
		String str = "ABCDEFGHIJKLMN";
		
		StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.reverse());
        
        String str2 = "990929-1010123";
        
        String str3 = str2.replace("-","");
        System.out.println(str3);
        
	}
}
