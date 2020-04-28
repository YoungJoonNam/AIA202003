package phonebook;

public class Menu implements MenuInterface {
	
	public static void DoPrintMenu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("[전화번호부]");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("○메뉴");
		System.out.println("         - "+INSER_SAVE+". 입력,저장");
		System.out.println("         - "+SEARCH+". 검색");
		System.out.println("         - "+MODIFY+". 수정");
		System.out.println("         - "+DELETE+". 삭제");
		System.out.println("         - "+PRINT_ALL+". 전체목록출력");
		System.out.println("         - "+EXIT+". 종료");
	}
	
	public static void DoPrintInputMenu() {		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("○입력상세메뉴");
		System.out.println("         - "+GENERAL+". 일반");
		System.out.println("         - "+UNIVERSITY+". 대학");
		System.out.println("         - "+COMPANY+". 회사");
		System.out.println("         - "+CLUB+". 클럽");
		System.out.println("--------------------------------------------------------------------");
	}

}
