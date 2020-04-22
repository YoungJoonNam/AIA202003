package modifier;

import java.util.Scanner;

//전화번호 저장
//전화번호 정보 뷰
//전화번호 검색
//전화번호 삭제

//Version 0.1 전화번호 관리 프로그램. PhoneInfo 라는 이름의 클래스를 정의해 보자. 
//클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
//저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
//•이름 name String
//•전화번호 phoneNumber String
//•생년월일 birthday String 단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
//Project ( 전화번호 관리 프로그램 )
//
//Project : ver 0.20
//“프로그램 사용자로부터 데이터 입력”
//프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이
//핵심
//단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
//프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
//키보드로부터 데이터 입력 
//입력 받은 데이터로 인스턴스 생성 
//생성된 인스턴스의 메소드 호출
//Project	

//Project : ver 0.30
//배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지
//유지되도록 프로그램을 변경. 아래기능 삽입
//저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
//데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
//재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.	

public class PhoneBook {

	private int m_nSizeOfPB;	
	private String m_strUserInput;
	private boolean m_bSearchSuccess;
	private int m_nIndex;
	
	private final PhoneInfo[] m_pi; //초기화가 한번되면 변경되지 않도록 final 처리
	private Scanner m_scInputUser;

	
	{
		m_nSizeOfPB = 100;
		m_strUserInput=null;
		m_bSearchSuccess = false;
		m_nIndex=0;
	}
	
	PhoneBook(){		
		m_pi = new PhoneInfo[m_nSizeOfPB];
	}
	
	PhoneBook(int nSizeOfPhoneBook){
		m_nSizeOfPB = nSizeOfPhoneBook;
		m_pi = new PhoneInfo[m_nSizeOfPB];
	}
	

	//메뉴
	void DoStart() {
		
		m_scInputUser=new Scanner(System.in);
			
		
		while(true) {
						
			Menu.DoPrintMenu();
			
//			System.out.println("--------------------------------------------------------------------");
//			System.out.println("[전화번호부]");
//			System.out.println("--------------------------------------------------------------------");
//			System.out.println("○메뉴");
//			System.out.println("         - 입력,저장 : I 혹은 i");
//			System.out.println("         - 검색 : F 혹은 f");
//			System.out.println("         - 삭제 : D 혹은 d");
//			System.out.println("         - 전체목록출력 : P 혹은 p");
//			System.out.println("         - 종료 : X 혹은 x");
			//저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
			//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
			//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
						
			m_strUserInput=m_scInputUser.nextLine();
			if(m_strUserInput.contentEquals("X")||m_strUserInput.contentEquals("x")) {
				System.out.println("감사합니다. 전화번호부를 종료합니다~~");
				break;				
			}
			else if(m_strUserInput.contentEquals("I")||m_strUserInput.contentEquals("i")) {
				DoInput();
			}
			else if(m_strUserInput.contentEquals("F")||m_strUserInput.contentEquals("f")) {
				DoSearch();
			}
			else if(m_strUserInput.contentEquals("D")||m_strUserInput.contentEquals("d")) {
				DoDelete();
			}
			else if(m_strUserInput.contentEquals("P")||m_strUserInput.contentEquals("p")) {
				DoPrintAll();
			}
			else {
				
			}
			
			System.out.println("-계속하시려면 아무키나 눌러주세요");
			m_strUserInput=m_scInputUser.nextLine();		
		} //while(true) {
	}

	//입력, 저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
	void DoInput() {
		
		String strInputName=null;
		String strInputNumber=null;
		String strInputBirthday=null;
		
		System.out.print("이름을 입력해주세요 : ");
		strInputName=m_scInputUser.nextLine();
		
		System.out.print("전화번호를 입력해주세요 : ");
		strInputNumber=m_scInputUser.nextLine();
		
		System.out.print("생년월일을 입력해주세요 : ");
		strInputBirthday=m_scInputUser.nextLine();
		
		PhoneInfo pi;
		//2020.04.22 if(strInputBirthday.isEmpty()) {
		if(strInputBirthday==null||strInputBirthday.trim().isEmpty()) {
			pi = new PhoneInfo(strInputName,strInputNumber);
			//System.out.println("----BirthDay Empty!!!");
		}
		else {
			pi = new PhoneInfo(strInputName,strInputNumber,strInputBirthday);					
		}
		
		System.out.println("\n[사용자 입력정보]");
		pi.DoPrintPhoneInfo();		
		
		System.out.println("저장하시겠습니까??? (Y or N)");
		m_strUserInput=m_scInputUser.nextLine();
		if(m_strUserInput.contentEquals("Y")||m_strUserInput.contentEquals("y")) {
			//앞에서부터 순차적으로 검색, 이름이 비어 있는 저장공간을 찾아서 저장
			//추가 : 이름이 동일한 사람이 있는 경우 입력하지 않도록
			m_bSearchSuccess = false;
			for (m_nIndex = 0; m_nIndex < m_pi.length; m_nIndex++) {
				if(m_pi[m_nIndex] == null) {
					m_pi[m_nIndex] = pi;
					m_bSearchSuccess = true;
					break;
				}						
			}
			
			if(m_bSearchSuccess) {
				System.out.println("[저장 완료] - Index : "+m_nIndex);						
			}
			else {
				System.out.println("!! 저장 실패 - 빈공간이 없습니다.");
			}
		}
		else {
			System.out.println("[저장 취소]");
			
		}
	}
	//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	int DoSearch() {
		
		System.out.print("이름을 입력해주세요 : ");
		m_strUserInput=m_scInputUser.nextLine();				
		m_bSearchSuccess = false;
		for (m_nIndex = 0; m_nIndex < m_pi.length; m_nIndex++) {
			if(m_pi[m_nIndex] != null) {
				if(m_strUserInput.contentEquals(m_pi[m_nIndex].strPname)) {
					System.out.println("찾았습니다!! Index : " + m_nIndex);
					m_pi[m_nIndex].DoPrintPhoneInfo();		
					m_bSearchSuccess = true;
					break;
				}					
			}												
		}				
		
		if(!m_bSearchSuccess) {
			System.out.println("-입력하신 이름에 해당하는 정보가 없습니다.");
			m_nIndex = -1;
		}		
			
		return m_nIndex;
		
	}
	//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
	void DoDelete() {
		//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
		//데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
		//재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
				
		int nIndex;
		
		nIndex = DoSearch();
		
		if(nIndex>=0) {			
			System.out.println("정말 삭제하시겠습니까?? (Y/N)");
			m_strUserInput=m_scInputUser.nextLine();					
			if(m_strUserInput.contentEquals("Y")||m_strUserInput.contentEquals("y")) {
				m_pi[nIndex] = null;
				System.out.println("삭제하였습니다.");
			}
			//삭제된 값 뒤의 값들을 한칸씩 당김
			//맨끝에 있는 값을 삭제할경우엔 당기지 않음
			//index 98, 99 삭제시 생각해보기
			if(nIndex >=  (m_pi.length-1)) {
				
			}
			else {
				for (int i = nIndex; i < m_pi.length-1; i++) {
					m_pi[i] = m_pi[i+1];						
				}						
			}
					
		}	
	}
	void DoPrintAll() {
		for (int i = 0; i < m_pi.length-1; i++) {								
			if(m_pi[i] == null) {
				break;
			}	
			System.out.println("[ IndexNo : "+i+" ]");
			m_pi[i].DoPrintPhoneInfo();
		}			
	}
		
	
	public static void main(String[] args) {
		
		PhoneBook pb = new PhoneBook(100);
		
		pb.DoStart();

	}

}
