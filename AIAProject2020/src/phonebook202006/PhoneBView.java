package phonebook202006;


public class PhoneBView implements NamedIF {
	
	final InputException	ie;		
	PhoneBook				pb;
	final PhoneBCtrl			pctrl;
	
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
		pb.setName(ie.userInputData("none"));
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
		System.out.println("empno\t\t ename\t\t job\t\t\t mgr\t hiredate\t\t\t\t sal\t\t comm\t deptno");		
		System.out.println(LINELIST);
		
		pctrl.list();
				
		menu();
		
		
	}
	
	void search() {
		
		System.out.println(LINE1);
		System.out.println("검색");
		System.out.println(LINE1);
		
		System.out.print("검색 이름 입력해주세요 name : ");
		String ename = ie.userInputData("none");
		System.out.println(LINELIST);
		System.out.println("empno\t\t ename\t\t job\t\t\t mgr\t hiredate\t\t\t\t sal\t\t comm\t deptno");		
		System.out.println(LINELIST);
		
		pctrl.search(ename);
		
		menu();
		
	}
	
	void end() {
		
	}
	public static void main(String[] args) {
		PhoneBView view = new PhoneBView();
		
		view.Start();
		view.end();
	
	}	

}
