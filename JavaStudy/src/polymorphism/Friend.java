package polymorphism;

import java.util.Scanner;

// 친구의 정보를 저장하기 위한 클래스
// 상속을 목적으로 기본 클래스 정의
// 기본 속성과 기능을 구성

public class Friend {
	String name;
	String phoneNum;
	String addr;

	public Friend() {
		//AddFriend();		
	}
	
	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phoneNum = phone;
		this.addr = addr;
	}

	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("주소 : " + addr);
	}

	public void showBasicInfo() {
	}

	void AddFriend() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화 : ");
		phoneNum = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();
		
		sc=null;
	}
	
}
