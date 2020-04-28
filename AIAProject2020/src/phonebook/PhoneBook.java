package phonebook;

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

//
//Project ver 0.50
//PhoneBookManager 클래스의 인스턴스수가 최대 하나를 넘지 않도록 코드를
//변경.
//‘initerface’기반의 상수 표현을 바탕으로 메뉴 선택과 그에 따른 처리가, 
//이름에 부여된 상 수를 기반으로 진행되도록 변경.
//
//현재의 기본 크래스를 interface와 추상클래스를 사용하는 구조로 변경해 봅시다.
//
//interface : 필수 메서드 정의
//추상클래스 : 인터스 변수와 interface를 상속 받지만 구현하지 않은 클래스
//[기능 추가]
//- 데이터 수정 기능을 추가 합시다.
//  수정의 의미를 생각해보고, 객체의 변수를 참조해서 
//수정하는 방법을 사용하지 말고 수정 기능을 구현해 봅시다.
//Ver 0.5
//1. manager 클래스의 싱글톤 패턴
//	1) 생성자의 접근제어지시자 : private
//		인스턴스 생성을 막는다.
//	2) 공동으로 사용할 인스턴스를 생성 : static private
//	3) 참조변수 반환 메서드 : static public
//2. interface 기반의 상수 표현
//   메뉴 표현
//3. interface -> 추상클래스 -> 상속
// 관계 구조로 변경
//
//○  향후 개선해야할 것 및 문제점
//- 숫자 입력 메뉴에서 문자 입력시 오류 발생(Exception 배우면 수정 가능?)
//- Key 값인 동일 이름 입력시 입력 안됨 추가 필요
//- 입력 종료시 메인 메뉴가 아닌 더 입력할 건지 물어보는 메뉴 추가
//- 입력과 수정메서드 중복부분을 메서드로 추출해보기



public class PhoneBook extends PhoneBookAB implements MenuInterface {

	private int m_nSizeOfPB;	
	private String m_strUserInput;
	private int m_nUserInput;
	private boolean m_bSearchSuccess;
	private int m_nIndex;
	
	private final PhoneInfo[] m_pi; //초기화가 한번되면 변경되지 않도록 final 처리
	private Scanner m_scInputUser;

	
	{
		m_nSizeOfPB = 100;
		m_strUserInput=null;
		m_nUserInput=0;
		m_bSearchSuccess = false;
		m_nIndex=0;
	}
	
// 싱글톤패턴 적용 20200428
// 1) 생성자의 접근제어지시자 : private
//	 인스턴스 생성을 막는다.
// 2) 공동으로 사용할 인스턴스를 생성 : static private
// 3) 참조변수 반환 메서드 : static public

	static private PhoneBook pb = new PhoneBook();
	
	static public PhoneBook getInstance() {
		return pb;
	}
	
	private PhoneBook(){		
		m_pi = new PhoneInfo[m_nSizeOfPB];
	}
	
	//20200428
//	PhoneBook(int nSizeOfPhoneBook){
//		m_nSizeOfPB = nSizeOfPhoneBook;
//		m_pi = new PhoneInfo[m_nSizeOfPB];
//	}
	

	//메뉴
	public void DoStart() {
		
		m_scInputUser=new Scanner(System.in);
			
		
		while(true) {
						
			Menu.DoPrintMenu();
			
//			System.out.println("--------------------------------------------------------------------");
//			System.out.println("[전화번호부]");
//			System.out.println("--------------------------------------------------------------------");
//			System.out.println("○메뉴");
//			System.out.println("         - 1. 입력,저장");
//			System.out.println("         - 2. 검색");
//			System.out.println("         - 3. 삭제");
//			System.out.println("         - 4. 전체목록출력");
//			System.out.println("         - 0. 종료");
			//저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
			//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
			//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
						
			try {
				m_nUserInput=Integer.parseInt(m_scInputUser.nextLine().trim());	
			}
			catch(NumberFormatException e) {
				System.out.println("입력값이 잘못되었네요, 다시 입력부탁드립니다~");
				continue;
			}
			
			
//20200428			
//			int INSER_SAVE = 1;
//			int SEARCH = 2;
//			int DELETE = 3;
//			int PRINT_ALL = 4;
//			int EXIT = 0;
			if(m_nUserInput == EXIT) {
				System.out.println("감사합니다. 전화번호부를 종료합니다~~");
				break;				
			}
			else if(m_nUserInput == INSER_SAVE) {
				DoInput();
			}
			else if(m_nUserInput == SEARCH) {
				DoSearch();
			}
			else if(m_nUserInput == DELETE) {
				DoDelete();
			}
			else if(m_nUserInput == PRINT_ALL) {
				DoPrintAll();
			}
			else if(m_nUserInput == MODIFY) {
				DoModify();
			}
			else {
				
			}
			
			System.out.println("-계속하시려면 아무키나 눌러주세요");
			m_strUserInput=m_scInputUser.nextLine();		
		} //while(true) {
	}

//	검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
	public int DoSearch() {
		
		System.out.print("이름을 입력해주세요 : ");
		m_strUserInput=m_scInputUser.nextLine();				
		m_bSearchSuccess = false;
		for (m_nIndex = 0; m_nIndex < m_pi.length; m_nIndex++) {
			if(m_pi[m_nIndex] != null) {
				if(m_strUserInput.contentEquals(m_pi[m_nIndex].name)) {
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
	public void DoDelete() {
		//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
		//데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
		//재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
				
		int nIndex;

		nIndex = DoSearch();

		if (nIndex >= 0) {
			System.out.println("정말 삭제하시겠습니까?? (Y/N)");
			if (DoCheckYesOrNo()) {
				m_pi[nIndex] = null;
				System.out.println("[삭제 완료] - Index : " + m_nIndex);
			}
			// 삭제된 값 뒤의 값들을 한칸씩 당김
			// 맨끝에 있는 값을 삭제할경우엔 당기지 않음
			// index 98, 99 삭제시 생각해보기
			if (nIndex >= (m_pi.length - 1)) {

			} else {
				for (int i = nIndex; i < m_pi.length - 1; i++) {
					m_pi[i] = m_pi[i + 1];
				}
			}

		}
	}
	public void DoPrintAll() {
		for (int i = 0; i < m_pi.length-1; i++) {								
			if(m_pi[i] == null) {
				break;
			}	
			System.out.println("[ IndexNo : "+i+" ]");
			m_pi[i].DoPrintPhoneInfo();
		}			
	}
		
	private boolean DoCheckYesOrNo() {
		boolean bResult=false;
		
		m_strUserInput=m_scInputUser.nextLine();					
		if(m_strUserInput.contentEquals("Y")||m_strUserInput.contentEquals("y")) {
			bResult=true;
		}
		else {
			bResult=false;			
		}			
		return bResult;
	}
	
	public void DoInput()  {
						
		String name=null;
		String phoneNumber=null;
		String email=null;
		String address=null;
		String major=null;
		String year=null;
		String company=null;
		String club=null;
		String location=null;
		
		
		
//		System.out.println("--------------------------------------------------------------------");
//		System.out.println("○입력상세메뉴");
//		System.out.println("         - 1. 일반");
//		System.out.println("         - 2. 대학");
//		System.out.println("         - 3. 회사");
//		System.out.println("         - 4. 동호회");		
//		System.out.println("--------------------------------------------------------------------");
		
		while (true) {
			Menu.DoPrintInputMenu();

			try {
				m_nUserInput=Integer.parseInt(m_scInputUser.nextLine().trim());	
			}
			catch(NumberFormatException e) {
				System.out.println("입력값이 잘못되었네요, 다시 입력부탁드립니다~");
				continue;
			}
			
			if ((m_nUserInput == 1) || (m_nUserInput == 2) || (m_nUserInput == 3) || (m_nUserInput == 4)) {
				try {
					System.out.print("이름을 입력해주세요 : ");
					name = m_scInputUser.nextLine();				
					checkBeEmpty(name);
								
					System.out.print("전화번호를 입력해주세요 : ");
					phoneNumber = m_scInputUser.nextLine();
					checkBeEmpty(phoneNumber);
	
					System.out.print("이메일을 입력해주세요 : ");
					email = m_scInputUser.nextLine();
					checkBeEmpty(email);
					
	
					if (m_nUserInput == GENERAL) {
						addInfo(new PhoneInfo(name, phoneNumber, email));
						break;
					} else if (m_nUserInput == UNIVERSITY) {
						System.out.print("주소를 입력해주세요 : ");
						address = m_scInputUser.nextLine();
						checkBeEmpty(address);
	
						System.out.print("전공을 입력해주세요 : ");
						major = m_scInputUser.nextLine();
						checkBeEmpty(major);
	
						System.out.print("학년을 입력해주세요 : ");
						year = m_scInputUser.nextLine();
						checkBeEmpty(year);
						
						addInfo(new PhoneInfoUnivInfo(name, phoneNumber, email, address, major, year));
						break;
					} else if (m_nUserInput == COMPANY) {
						System.out.print("회사명을 입력해주세요 : ");
						company = m_scInputUser.nextLine();
						checkBeEmpty(company);
						addInfo(new PhoneInfoCompanyInfo(name, phoneNumber, email, company));
						break;
					} else if (m_nUserInput == CLUB) {
						System.out.print("클럽명을 입력해주세요 : ");
						club = m_scInputUser.nextLine();
						checkBeEmpty(club);
						System.out.print("위치를 입력해주세요 : ");
						location = m_scInputUser.nextLine();
						checkBeEmpty(location);
						addInfo(new PhoneInfoClub(name, phoneNumber, email, club,location));
						break;
					} else {
						System.out.println("값을 잘못 입력하셨어요");
					}
				
				} catch (EmptyException e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
			else {
				System.out.println("값을 잘못 입력하셨어요");				
			}
			
			
		}
	}
	

	public void addInfo(PhoneInfo pInfo) {
	
		
		System.out.println("\n[사용자 입력정보]");
		pInfo.DoPrintPhoneInfo();		
		System.out.println("저장하시겠습니까??? (Y or N)");		
		if(DoCheckYesOrNo()) {
			//앞에서부터 순차적으로 검색, 이름이 비어 있는 저장공간을 찾아서 저장
			//추가 : 이름이 동일한 사람이 있는 경우 입력하지 않도록
			m_bSearchSuccess = false;
			for (m_nIndex = 0; m_nIndex < m_pi.length; m_nIndex++) {
				if(m_pi[m_nIndex] == null) {					
					m_pi[m_nIndex] = pInfo;
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

	void DoModify(){
		int nIndex;

		String name=null;
		String phoneNumber=null;
		String email=null;
		String address=null;
		String major=null;
		String year=null;
		String company=null;
		String club=null;
		String location=null;
		
		nIndex = DoSearch();

		if (nIndex >= 0) {
			System.out.println("수정하시겠습니까?? (Y/N)");
			if (DoCheckYesOrNo()) {
				//수정 코드 - 개선사항 : 향후, 입력란과 중복된 부분 추출하여 메서드로 뽑기
				System.out.print("이름을 입력해주세요 : ");
				name = m_scInputUser.nextLine();

				System.out.print("전화번호를 입력해주세요 : ");
				phoneNumber = m_scInputUser.nextLine();

				System.out.print("이메일을 입력해주세요 : ");
				email = m_scInputUser.nextLine();

				
				if(m_pi[nIndex] instanceof  PhoneInfoUnivInfo) {
					System.out.print("주소를 입력해주세요 : ");
					address = m_scInputUser.nextLine();

					System.out.print("전공을 입력해주세요 : ");
					major = m_scInputUser.nextLine();

					System.out.print("학년을 입력해주세요 : ");
					year = m_scInputUser.nextLine();
					
					//값을 교체하는 방법
					//((PhoneInfoUnivInfo)m_pi[nIndex]).SetInfo(name, phoneNumber, email, address, major, year);
					//객체를 교체하는 방법
					m_pi[m_nIndex] = new PhoneInfoUnivInfo(name, phoneNumber, email, address, major, year);
					
				}
				else if(m_pi[nIndex] instanceof  PhoneInfoCompanyInfo) {
					System.out.print("회사명을 입력해주세요 : ");
					company = m_scInputUser.nextLine();
					//값을 교체하는 방법
					//((PhoneInfoCompanyInfo)m_pi[nIndex]).SetInfo(name, phoneNumber, email, company);
					//객체를 교체하는 방법
					m_pi[m_nIndex] = new PhoneInfoCompanyInfo(name, phoneNumber, email, company);
				}
				else if(m_pi[nIndex] instanceof  PhoneInfoClub) {
					System.out.print("클럽명을 입력해주세요 : ");
					club = m_scInputUser.nextLine();
					System.out.print("위치를 입력해주세요 : ");
					location = m_scInputUser.nextLine();
					//값을 교체하는 방법
					//((PhoneInfoClub)m_pi[nIndex]).SetInfo(name, phoneNumber, email, club, location);
					//객체를 교체하는 방법
					m_pi[m_nIndex] = new PhoneInfoClub(name, phoneNumber, email, club, location);
				}
				else if(m_pi[nIndex] instanceof  PhoneInfo) {
					//값을 교체하는 방법
					//m_pi[nIndex].SetInfo(name, phoneNumber, email);
					//객체를 교체하는 방법
					m_pi[m_nIndex] = new PhoneInfo(name, phoneNumber, email);					
				}
				else {
	
				}			
				
				System.out.println("[수정 완료] - Index : " + m_nIndex);
			}
 
		}		
	}
	
	public static boolean checkBeEmpty(String str) throws EmptyException {
		boolean bResult;
		bResult = false;
		if(str.equals("")) {
			bResult = true;
			EmptyException excpt=new EmptyException();
			throw excpt; //예외상황을 알리는 문장!!!			
		}
		return bResult;
	}
	
	public static void main(String[] args)  {
		
		//20200428 PhoneBook pb = new PhoneBook(100);
		PhoneBook pb = PhoneBook.getInstance();
		
		pb.DoStart();

	}

}

class EmptyException extends Exception {
	public EmptyException() {
		super(">>>>>>>공백이 입력되었습니당~ 다시 입력해주세요");
	}
}
