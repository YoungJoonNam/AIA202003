package phonebook202006;


public class PhoneBView implements NamedIF {
	
	final InputException	ie;		
	
	
	public PhoneBView() {
		ie = InputException.getInstance();	
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
		
	}
	
	void modify() {
		
	}
	
	void del() {
		
	}
	
	void list() {
		
	}
	
	void search() {
		
	}
/*	
	void input() {
				
		System.out.println(LINE1);
		System.out.println("사원 - 입력");
		System.out.println(LINE1);
		System.out.print("empno : ");
		int empno = Integer.parseInt(ie.userInputData("int"));
		System.out.print("ename : ");
		String ename = ie.userInputData("none");
		System.out.print("job : ");
		String job = ie.userInputData("none");
		System.out.print("mgr : ");
		int mgr = Integer.parseInt(ie.userInputData("int"));
		System.out.print("hiredate : (2020-11-5) 형식으로 입력해주세요");
		String hiredate = ie.userInputData("date");
		System.out.print("sal : ");
		int sal = Integer.parseInt(ie.userInputData("int"));
		System.out.print("comm : ");
		int comm = Integer.parseInt(ie.userInputData("int"));
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(ie.userInputData("int"));
			
		int result = jm.inputEmp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 입력되었습니다. 입력된 행의 수 : "+result);
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menu();
	}
	

	void modifyEmp() {
		System.out.println(LINE1);
		System.out.println("사원 - 수정");
		System.out.println(LINE1);
		System.out.println("이름, 부서, 급여 정보를 변경할 수 있습니다.");
		System.out.println("수정할 사원 번호를 입력해주세요");		
		System.out.print("empno : ");
		int empno = Integer.parseInt(ie.userInputData("int"));
		
		System.out.print("ename : ");
		String ename = ie.userInputData("none");		
		System.out.print("sal : ");
		int sal = Integer.parseInt(ie.userInputData("int"));		
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(ie.userInputData("int"));
			
		int result = jm.modifyEmp(empno,ename,sal,deptno);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다. 수정된 행의 수 : "+result);
		} else {
			System.out.println("수정 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menuEmp();
	}
	void delEmp() {
		
		System.out.println(LINE1);
		System.out.println("사원 - 삭제");
		System.out.println(LINE1);
						
		System.out.print("삭제할 사원번호를 입력해주세요 empno : ");
		int empno = Integer.parseInt(ie.userInputData("int"));
					
		int result = jm.delEmp(empno);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다. 삭제된 행의 수 : "+result);
		} else {
			System.out.println("삭제 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);	
		
		
		menuEmp();
		
	}
	
	void listEmp() {
		
		System.out.println(LINE1);
		System.out.println("사원 - 리스트");
		System.out.println(LINE1);		
		System.out.println(LINELIST);
		System.out.println("empno\t\t ename\t\t job\t\t\t mgr\t hiredate\t\t\t\t sal\t\t comm\t deptno");		
		System.out.println(LINELIST);
		
		jm.listEmp();
		
		menuEmp();
		
	}
	
	void searchEmp() {
		
		System.out.println(LINE1);
		System.out.println("검색 - 리스트");
		System.out.println(LINE1);
		
		System.out.print("검색할 사원이름 입력해주세요 ename : ");
		String ename = ie.userInputData("none");
		System.out.println(LINELIST);
		System.out.println("empno\t\t ename\t\t job\t\t\t mgr\t hiredate\t\t\t\t sal\t\t comm\t deptno");		
		System.out.println(LINELIST);
		jm.searchEmp(ename);
		
		menuEmp();
		
	}
	
void menuDept() {
		
		String inputStr = null;
		System.out.println(LINE1);
		System.out.println("부서 관리");
		System.out.println(LINE1);
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 리스트");
		System.out.println("5. 검색");
		System.out.println("6. 메뉴로 돌아가기");
		System.out.println("7. 종료");
		
		System.out.println(LINE1);
		inputStr = ie.userInputData("1","2","3","4","5","6","7");
				
		switch (inputStr) {
		// 목록보기
		case "1":		//입력
			inputDept();			
			break;
		case "2":		//수정
			modifyDept();			
			break;			
		case "3":		//삭제
			// 내가 쓴 글 목록
			delDept();			
			break;		 
		case "4":		// 리스트
			listDept();
			break;
		case "5":		// 검색
			searchDept();
			break;
		case "6":		// 메뉴로돌아가기
			menu();
			break;
		case "7":		// 종료			
			break;
		default:
			menuDept();
			break;				
		}		
		
	}
	
	
	void inputDept() {
		
		System.out.println(LINE1);
		System.out.println("부서 - 입력");
		System.out.println(LINE1);
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(ie.userInputData("int"));
		System.out.print("dname : ");
		String dname = ie.userInputData("none");
		System.out.print("loc : ");
		String loc = ie.userInputData("none");
					
		int result = jm.inputDept(deptno,dname,loc);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 입력되었습니다. 입력된 행의 수 : "+result);
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menuDept();
	}
	
	void modifyDept() {
		System.out.println(LINE1);
		System.out.println("부서 - 수정");
		System.out.println(LINE1);
		
		//System.out.println("수정할 사원 번호를 입력해주세요");
		
		System.out.println(LINE1);
		System.out.println("부서 - 입력");
		System.out.println(LINE1);
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(ie.userInputData("int"));
		System.out.print("dname : ");
		String dname = ie.userInputData("none");
		System.out.print("loc : ");
		String loc = ie.userInputData("none");
			
		int result = jm.modifyDept(deptno,dname,loc);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 수정되었습니다. 수정된 행의 수 : "+result);
		} else {
			System.out.println("수정 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menuDept();
	}
	
	void delDept() {
		
		System.out.println(LINE1);
		System.out.println("부서 - 삭제");
		System.out.println(LINE1);
						
		System.out.print("삭제할 부서번호를 입력해주세요 empno : ");
		int deptno = Integer.parseInt(ie.userInputData("int"));
					
		int result = jm.delDept(deptno);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다. 삭제된 행의 수 : "+result);
		} else {
			System.out.println("삭제 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);	
		
		
		menuDept();
		
	}
	
	void listDept() {
		
		System.out.println(LINE1);
		System.out.println("부서 - 리스트");
		System.out.println(LINE1);		
		System.out.println(LINELIST);
		System.out.println("deptno\t\t dname\t\t loc");		
		System.out.println(LINELIST);
		
		jm.listDept();
		
		menuDept();
		
	}
	
	void searchDept() {
		
		System.out.println(LINE1);
		System.out.println("검색 - 리스트");
		System.out.println(LINE1);
		
		System.out.print("검색할 부서 이름이나 지역을 입력해주세요  : ");
		String dname = ie.userInputData("none");
		System.out.println(LINELIST);
		System.out.println("deptno\t dname\t\t loc");		
		System.out.println(LINELIST);
		jm.searchDept(dname);
		
		menuDept();
		
	}

	
	void end () {
		
		System.out.println(LINE1);
		System.out.println("종료되었습니다.");
		System.out.println(LINE1);
		
		ie.Close();
		
	}

	public static void main(String[] args) {
		PhoneBView view = new PhoneBView();
		
		view.Start();
		view.end();
	
	}
*/
}
