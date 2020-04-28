package polymorphism;

import java.util.Scanner;

public class HighFriend extends Friend {

	String work;

	public HighFriend() {
		//AddFriend();
	}
	public HighFriend(String name, String phone, String addr, String job) {
		super(name, phone, addr);
		work = job;
	}

	public void showData() {
		super.showData();
		System.out.println("직업 : " + work);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
	}
	
	//테스트로 시도: 
	//결론: 비효율적. 차라리 입력 클래스를 따로 두는게 
	//좋지 않을 것 같다는 결론
	@Override
	void AddFriend() {		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화 : ");
		phoneNum = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();
		System.out.print("직업 : ");
		work = sc.nextLine();
		
		sc=null;
	}
}