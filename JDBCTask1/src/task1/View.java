package task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;


//1. 사원관리 프로그램
//   #기능
//		입력, 
//		수정(사원번호로 입력 - 이름,부서,급여), 
//		삭제(사원번호 기준), 
//		리스트,
//		검색(이름)

//2. 부서관리 프로그램
//#기능
//	입력, 
//	수정(부서번호로 입력 - 부서이름,위치), 
//	삭제(부서번호 기준), 
//	리스트,
//	검색(부서이름 or 지역)

public class View implements DefineIF {
		
	final InputException	ie;		//예외처리체크용 클래스
	final JdbcManager		jm;		
	HashMap<String, String> map; //예외처리시 허용값을 넣어줄 맵
	
	
	public View() {
		ie = InputException.getInstance();
		jm = new JdbcManager();
		map = new HashMap<>();
	}
	
	
	
	// Util Method
	private String userInputData(String ...exceptS) {
		
		int count=1;
		String key=null;
		String input=null;
				
		map.clear();
		
		for(String str : exceptS) {
			
			if(str.equals("int")) {
				map.put("int","int");
				break;				
			}
			else if(str.equals("double")) {
				map.put("double","double");
				break;				
			}
			else if(str.equals("none")) {
				map.put("none","none");
				break;				
			}
			else if(str.equals("date")) {
				map.put("date","date");
				break;				
			}
			else {
				key = "k"+count;
				map.put(key, str);
				count++;				
			}
		}
				
		
		
		
		
		while(true) {
			System.out.print(">>  ");
					
			input=ie.InputDataException(map);
			
			if(input != null) { //
				break;
			}
			else { //적합하지 않은 값이 입력된 경우
				System.out.println("적합하지 않은 값이 입력되었습니다. ");
				continue;
			}			
		}
				
		return input;		
	}
	
	void Start() {
		jm.Init();
		menu();
	}
	
	void menu() {
		
		String inputStr = null;
		System.out.println(LINE1);
		System.out.println("1. 사원 관리");
		System.out.println("2. 부서 관리");
		System.out.println(LINE1);
		inputStr = userInputData("1","2");		
		
		
		if(inputStr.equals("1")) {
			menuEmp();			
		}
		else {
			menuDept();			
		}
		
				
	}
	
	void menuEmp() {
		
		String inputStr = null;
		System.out.println(LINE1);
		System.out.println("사원 관리");
		System.out.println(LINE1);
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 리스트");
		System.out.println("5. 검색");
		System.out.println("6. 메뉴로 돌아가기");
		System.out.println("7. 종료");
		
		System.out.println(LINE1);
		inputStr = userInputData("1","2","3","4","5","6","7");
				
		switch (inputStr) {
		// 목록보기
		case "1":		//입력
			inputEmp();			
			break;
		case "2":		//수정
			modifyEmp();			
			break;			
		case "3":		//삭제
			// 내가 쓴 글 목록
			delEmp();			
			break;		 
		case "4":		// 리스트
			listEmp();
			break;
		case "5":		// 검색
			searchEmp();
			break;
		case "6":		// 메뉴로돌아가기
			menu();
			break;
		case "7":		// 종료			
			break;			
		default:
			menuEmp();
			break;				
		}		
		
	}
	
	
	void inputEmp() {
				
		System.out.println(LINE1);
		System.out.println("사원 - 입력");
		System.out.println(LINE1);
		System.out.print("empno : ");
		int empno = Integer.parseInt(userInputData("int"));
		System.out.print("ename : ");
		String ename = userInputData("none");
		System.out.print("job : ");
		String job = userInputData("none");
		System.out.print("mgr : ");
		int mgr = Integer.parseInt(userInputData("int"));
		System.out.print("hiredate : (2020-11-5) 형식으로 입력해주세요");
		String hiredate = userInputData("date");
		System.out.print("sal : ");
		int sal = Integer.parseInt(userInputData("int"));
		System.out.print("comm : ");
		int comm = Integer.parseInt(userInputData("int"));
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(userInputData("int"));
			
		int result = jm.inputEmp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
		
		System.out.println(LINE2);
		if(result > 0) {
			System.out.println("정상적으로 입력되었습니다. 입력된 행의 수 : "+result);
		} else {
			System.out.println("입력이 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
		}			
		System.out.println(LINE2);		
		
		menuEmp();
	}
	
//	void modifyEmp() {
//		System.out.println(LINE1);
//		System.out.println("사원 - 수정");
//		System.out.println(LINE1);
//		
//		//System.out.println("수정할 사원 번호를 입력해주세요");
//		
//		System.out.print("empno : ");
//		int empno = Integer.parseInt(userInputData("int"));
//		System.out.print("ename : ");
//		String ename = userInputData("none");
//		System.out.print("job : ");
//		String job = userInputData("none");
//		System.out.print("mgr : ");
//		int mgr = Integer.parseInt(userInputData("int"));
//		System.out.print("hiredate : (2020-11-5) 형식으로 입력해주세요");
//		String hiredate = userInputData("date");
//		System.out.print("sal : ");
//		int sal = Integer.parseInt(userInputData("int"));
//		System.out.print("comm : ");
//		int comm = Integer.parseInt(userInputData("int"));
//		System.out.print("deptno : ");
//		int deptno = Integer.parseInt(userInputData("int"));
//			
//		int result = jm.modifyEmp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
//		
//		System.out.println(LINE2);
//		if(result > 0) {
//			System.out.println("정상적으로 수정되었습니다. 수정된 행의 수 : "+result);
//		} else {
//			System.out.println("수정 되지 않았습니다. 확인 후 재시도 해주세요. : "+result);
//		}			
//		System.out.println(LINE2);		
//		
//		menuEmp();
//	}
	
	void modifyEmp() {
		System.out.println(LINE1);
		System.out.println("사원 - 수정");
		System.out.println(LINE1);
		System.out.println("이름, 부서, 급여 정보를 변경할 수 있습니다.");
		System.out.println("수정할 사원 번호를 입력해주세요");		
		System.out.print("empno : ");
		int empno = Integer.parseInt(userInputData("int"));
		
		System.out.print("ename : ");
		String ename = userInputData("none");		
		System.out.print("sal : ");
		int sal = Integer.parseInt(userInputData("int"));		
		System.out.print("deptno : ");
		int deptno = Integer.parseInt(userInputData("int"));
			
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
		int empno = Integer.parseInt(userInputData("int"));
					
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
		String ename = userInputData("none");
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
		inputStr = userInputData("1","2","3","4","5","6","7");
				
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
		int deptno = Integer.parseInt(userInputData("int"));
		System.out.print("dname : ");
		String dname = userInputData("none");
		System.out.print("loc : ");
		String loc = userInputData("none");
					
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
		int deptno = Integer.parseInt(userInputData("int"));
		System.out.print("dname : ");
		String dname = userInputData("none");
		System.out.print("loc : ");
		String loc = userInputData("none");
			
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
		int deptno = Integer.parseInt(userInputData("int"));
					
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
		String dname = userInputData("none");
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
		
		ie.ScannerClose();
		jm.end();
	}

	public static void main(String[] args) {
		View view = new View();
		
		view.Start();
		view.end();
	
	}

	
}
