package modifier;

import array.Member;

public class TestMain1 {
	
	public static void main(String[] args) {

		Member member = new Member();
		System.out.println(member.memberId);
		
	
		Singleton s = Singleton.getInstance();
		s.print();
	
	}
}
