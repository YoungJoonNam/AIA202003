package classandinstance;

import java.util.Scanner;

//전화번호 저장
//전화번호 정보 뷰
//전화번호 검색
//전화번호 삭제

//Version 0.1 전화번호 관리 프로그램. PhoneInfor 라는 이름의 클래스를 정의해 보자. 
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
//핵심.
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

public class PhoneInfor {
	
	String strPname;
	String strPphoneNumber;
	String strPbirthday;

	{
		strPname = "";
		strPphoneNumber = "";
		strPbirthday = "";
	}
	
	PhoneInfor(){
		
	}
	
	PhoneInfor(String name, String number, String birthday){
		strPname = name;
		strPphoneNumber = number;
		strPbirthday = birthday;
	}
	
	PhoneInfor(String name, String number){
		strPname = name;
		strPphoneNumber = number;		
		strPbirthday = "[사용자미입력]";
	}
	
	
	void DoPrintPhoneBook() {
			
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("이름 - "+strPname+" 전화번호 - "+strPphoneNumber+" 생년월일 - "+strPbirthday);
		System.out.println("-------------------------------------------------------------------------");
		
	}
	
	boolean IsEmpty() {
		
		boolean bResult=true;
		
		if(strPname.isEmpty()) {
			bResult=true;			
		}
		else {
			bResult=false;			
		}
		return bResult;
	}
	
	
	

	public static void main(String[] args) {

		Scanner scInputUser=new Scanner(System.in);
		String strInputMenu=null;
		String strInputName=null;
		String strInputNumber=null;
		String strInputBirthday=null;
			
		PhoneInfor[] PhoneBook = new PhoneInfor[100];
		
		
		while(true) {
			
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("[전화번호부]");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("<메뉴>-------( ^O^)/");
			System.out.println("         - 입력,저장 : I 혹은 i");
			System.out.println("         - 검색 : F 혹은 f  //미구현");
			System.out.println("         - 삭제 : D 혹은 d //미구현");
			System.out.println("         - 종료는 X 혹은 x");
			//저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
			//검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
			//삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제
						
			strInputMenu=scInputUser.nextLine();
			if(strInputMenu.contentEquals("X")||strInputMenu.contentEquals("x")) {
				System.out.println("감사합니다. 전화번호부를 종료합니다~~");
				break;				
			}
			else if(strInputMenu.contentEquals("I")||strInputMenu.contentEquals("i")) {
			
				System.out.println("이름을 입력해주세요 : ");
				strInputName=scInputUser.nextLine();
				
				System.out.println("전화번호를 입력해주세요 : ");
				strInputNumber=scInputUser.nextLine();
				
				System.out.println("생년월일을 입력해주세요 : ");
				strInputBirthday=scInputUser.nextLine();
				
				PhoneInfor pi;
				if(strInputBirthday.isEmpty()) {
					pi = new PhoneInfor(strInputName,strInputNumber);
					//System.out.println("----BirthDay Empty!!!");
				}
				else {
					pi = new PhoneInfor(strInputName,strInputNumber,strInputBirthday);					
				}
				
				System.out.println("[사용자 입력정보]");
				pi.DoPrintPhoneBook();		
				
				System.out.println("저장하시겠습니까??? (Y or N)");
				strInputMenu=scInputUser.nextLine();
				if(strInputMenu.contentEquals("Y")||strInputMenu.contentEquals("y")) {
					//이름이 비어 있는 저장공간을 찾아서 저장
					PhoneBook[0] = pi;
					System.out.println("[저장 완료]");
				}
				else {
					System.out.println("[저장 취소]");
					
				}
				
			} // 사용자 입력 부분
			else if(strInputMenu.contentEquals("F")||strInputMenu.contentEquals("f")) {
				// 검색 후 출력
			}
			else if(strInputMenu.contentEquals("D")||strInputMenu.contentEquals("d")) {
				
			}
			else {
				
			}
			
			
			
		}
		

	}

}
