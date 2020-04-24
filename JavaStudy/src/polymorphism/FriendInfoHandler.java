package polymorphism;

import java.util.Scanner;

public class FriendInfoHandler {
	private Friend[] myFriends;
	private int numOfFriends;
	Scanner sc;
	
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
		Scanner sc = new Scanner(System.in);
	}

	private void addFriendInfo(Friend fren) {
		//myFriends[numOfFriends++] = fren;
		//테스트로 시도: 
		//결론: 비효율적. 차라리 입력 클래스를 따로 두는게 
		//좋지 않을 것 같다는 결론
		myFriends[numOfFriends] = fren;
		myFriends[numOfFriends++].AddFriend();		
	}

	public void addFriend(int choice) {
//		String name, phoneNum, addr, job, major;

//		System.out.print("이름 : ");
//		name = sc.nextLine();
//		System.out.print("전화 : ");
//		phoneNum = sc.nextLine();
//		System.out.print("주소 : ");
//		addr = sc.nextLine();
//		
//		if (choice == 1) {
//			System.out.print("직업 : ");
//			job = sc.nextLine();
//			addFriendInfo(new HighFriend(name, phoneNum, addr, job));
//		} else // if(choice==2)
//		{
//			System.out.print("학과 : ");
//			major = sc.nextLine();
//			addFriendInfo(new UnivFriend(name, phoneNum, addr, major));
//		}
		//Integer.parseInt(s); --> 자주 쓰임	
		
		//테스트로 시도: 
		//결론: 비효율적. 차라리 입력 클래스를 따로 두는게 
		//좋지 않을 것 같다는 결론
		if (choice == 1) {			
			addFriendInfo(new HighFriend());
		} else // if(choice==2)
		{			
			addFriendInfo(new UnivFriend());
		}
		System.out.println("입력 완료! \n");
	}

	public void showAllData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showData();
			System.out.println("");
		}
	}

	public void showAllSimpleData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("");
		}
	}

}
