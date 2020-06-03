package phonebook202006;

import java.util.ArrayList;

public class PhoneBView implements NamedIF {
	
	final InputException	ie;		
	PhoneBook				pb;
	final PhoneBCtrl			pctrl;
	ArrayList<PhoneBook> arr;
	
	public PhoneBView() {
		ie = InputException.getInstance();
		pctrl = new PhoneBCtrl();
		
	}
	
	void Start() {
		menu();
	}
	
	void menu() {
		
		String inputStr = null;
		System.out.println(LINE1);
		System.out.println("메뉴");
		System.out.println(LINE1);
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 목록");
		System.out.println("5. 검색");		
		System.out.println("6. 종료");
		
		
		System.out.println(LINE1);
		inputStr = ie.userInputData("1","2","3","4","5","6");
				
		switch (inputStr) {
		// 목록보기
		case "1":		//입력
			input();			
			break;
		case "2":		//수정
			modify();			
			break;			
		case "3":		//삭제 
			del();			
			break;		 
		case "4":		//,목록
			list();
			break;
		case "5":		//검색
			search();
			break;
		case "6":		//종료			
			break;					
		default:			
			break;				
		}		
		
				
	}
	

	void input() {
		
		pb = new PhoneBook();
		
		System.out.println(LINE1);
		System.out.println("입력");
		System.out.println(LINE1);
		System.out.print("이름 : ");
		pb.setName(ie.userInputData("none"));
		System.out.print("전화번호 : ");
		pb.setPhoneNumber(ie.userInputData("none"));		
		System.out.print("주소 : ");
		pb.setAddress(ie.userInputData("none"));
		System.out.print("이메일 : ");
		pb.setEmail(ie.userInputData("none"));
		System.out.print("분류 : 1.대학, 2.회사, 3.까페");
		switch (ie.userInputData("1","2","3")) {
		case "1":
			pb.setType("univ");			
			break;
		case "2":
			pb.setType("com");			
			break;			
		case "3": 
			pb.setType("cafe");			
			break;							
		default:			
			break;				
		}		
		System.out.print("전공 : ");
		pb.setMajor(ie.userInputData("none"));
		System.out.print("학년 : ");
		pb.setGrade(Integer.parseInt(ie.userInputData("int")));		
		System.out.print("회사 : ");
		pb.setCompany(ie.userInputData("none"));
		System.out.print("부서 : ");
		pb.setDept(ie.userInputData("none"));
		System.out.print("직급 : ");
		pb.setRank(ie.userInputData("none"));
		System.out.print("까페이름 : ");
		pb.setCafename(ie.userInputData("none"));
		System.out.print("닉네임 : ");
		pb.setNickname(ie.userInputData("none"));
				
			
		int result = pctrl.input(pb);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 입력되었습니다. 입력된 행의 수 : "+result);
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
			
		
		menu();		
	}
	
	void modify() {
		
		pb = new PhoneBook();
		
		System.out.println(LINE1);
		System.out.println("수정");
		System.out.println(LINE1);
		System.out.println("이름, 전화번호 를 변경할 수 있습니다.");
		System.out.println("수정할 대상의 번호를 입력해주세요 : ");		
		System.out.print("no : ");
		pb.setPid(ie.userInputData("none"));		
		System.out.print("이름 : ");
		pb.setName(ie.userInputData("none"));
		System.out.print("전화번호 : ");
		pb.setPhoneNumber(ie.userInputData("none"));	
		
			
		int result = pctrl.modify(pb);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다. 수정된 행의 수 : "+result);
		} else {
			System.out.println("수정 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menu();	
	}
	
	void del() {
		
		pb = new PhoneBook();
		
		System.out.println(LINE1);
		System.out.println("삭제");
		System.out.println(LINE1);
						
		System.out.print("삭제할 대상자의 번호를 입력해주세요 no : ");
		pb.setPid(ie.userInputData("none"));
					
		
		int result = pctrl.del(pb);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다. 삭제된 행의 수 : "+result);
		} else {
			System.out.println("삭제 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);	
				
		menu();	
	}
	
	void list() {
		
		System.out.println(LINE1);
		System.out.println("리스트");
		System.out.println(LINE1);		
		System.out.println(LINELIST);		
		System.out.printf("%4s \t","NO");
		System.out.printf("%10s \t","NAME");
		System.out.printf("%10s \t","P.NUMBER");
		System.out.printf("%10s \t","ADDRESS");
		System.out.printf("%10s \t","EMAIL");
		System.out.printf("%7s \t","TYPE");
		System.out.printf("%10s \t","MAJOR");
		System.out.printf("%4s \t","GRADE");
		System.out.printf("%10s \t","COMPANY");
		System.out.printf("%10s \t","DEPT");
		System.out.printf("%10s \t","RANK");
		System.out.printf("%10s \t","CAFENAME");
		System.out.printf("%10s \n","NICKNAME");
		System.out.println(LINELIST);
		
		arr = pctrl.list();
		
		if(arr.size() == 0) {
			System.out.println("결과가 없습니다.");
		}
		
		
		for(int i=0; i<arr.size(); i++) {
			System.out.printf("%4s \t",arr.get(i).getPid());
			System.out.printf("%10s \t",arr.get(i).getName());
			System.out.printf("%10s \t",arr.get(i).getPhoneNumber());
			System.out.printf("%10s \t",arr.get(i).getAddress());
			System.out.printf("%10s \t",arr.get(i).getEmail());
			System.out.printf("%7s \t",arr.get(i).getType());
			System.out.printf("%10s \t",arr.get(i).getMajor());
			System.out.printf("%4d \t",arr.get(i).getGrade());
			System.out.printf("%10s \t",arr.get(i).getCompany());
			System.out.printf("%10s \t",arr.get(i).getDept());
			System.out.printf("%10s \t",arr.get(i).getRank());
			System.out.printf("%10s \t",arr.get(i).getCafename());
			System.out.printf("%10s \n",arr.get(i).getNickname());
		}
		
				
		menu();
		
		
	}
	
	void search() {
		
		pb = new PhoneBook();
		
		System.out.println(LINE1);
		System.out.println("검색");
		System.out.println(LINE1);
		
		System.out.print("검색 이름 입력해주세요 name : ");
				
		pb.setName(ie.userInputData("none"));
		
		arr = pctrl.search(pb);
		
		System.out.printf("%4s \t","NO");
		System.out.printf("%10s \t","NAME");
		System.out.printf("%10s \t","P.NUMBER");
		System.out.printf("%10s \t","ADDRESS");
		System.out.printf("%10s \t","EMAIL");
		System.out.printf("%7s \t","TYPE");
		System.out.printf("%10s \t","MAJOR");
		System.out.printf("%4s \t","GRADE");
		System.out.printf("%10s \t","COMPANY");
		System.out.printf("%10s \t","DEPT");
		System.out.printf("%10s \t","RANK");
		System.out.printf("%10s \t","CAFENAME");
		System.out.printf("%10s \n","NICKNAME");
		System.out.println(LINELIST);
		
		if(arr.size() == 0) {
			System.out.println("검색된 결과가 없습니다.");
		}
				
		for(int i=0; i<arr.size(); i++) {
			System.out.printf("%4s \t",arr.get(i).getPid());
			System.out.printf("%10s \t",arr.get(i).getName());
			System.out.printf("%10s \t",arr.get(i).getPhoneNumber());
			System.out.printf("%10s \t",arr.get(i).getAddress());
			System.out.printf("%10s \t",arr.get(i).getEmail());
			System.out.printf("%7s \t",arr.get(i).getType());
			System.out.printf("%10s \t",arr.get(i).getMajor());
			System.out.printf("%4d \t",arr.get(i).getGrade());
			System.out.printf("%10s \t",arr.get(i).getCompany());
			System.out.printf("%10s \t",arr.get(i).getDept());
			System.out.printf("%10s \t",arr.get(i).getRank());
			System.out.printf("%10s \t",arr.get(i).getCafename());
			System.out.printf("%10s \n",arr.get(i).getNickname());
		}
		
		
		
		menu();
		
	}
	
	void end() {
		System.out.println(LINE1);
		System.out.println("종료되었습니다");
		System.out.println(LINE1);	
		pctrl.end();
	}
	public static void main(String[] args) {
		PhoneBView view = new PhoneBView();
		
		view.Start();
		view.end();
	
	}	

}
