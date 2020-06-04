package polymorphism;

import java.util.Scanner;

public class UnivFriend extends Friend {
	String major; // 전공학과
	int grade;//친구의 학년

	public UnivFriend() {
		//AddFriend();
	}

	public UnivFriend(String name, String phone, String addr, String major,int grade) {
		super(name, phone, addr);
		this.major = major;
		this.grade = grade;
	}

	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("전공 : " + major);
		
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
		System.out.print("학과 : ");
		major = sc.nextLine();
		System.out.print("학년 : ");
		grade = Integer.parseInt(sc.nextLine());
		
		sc=null;
	}
}
