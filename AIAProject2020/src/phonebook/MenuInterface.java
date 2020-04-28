package phonebook;

//public static void DoPrintMenu() {
//	System.out.println("--------------------------------------------------------------------");
//	System.out.println("[전화번호부]");
//	System.out.println("--------------------------------------------------------------------");
//	System.out.println("○메뉴");
//	System.out.println("         - 1. 입력,저장");
//	System.out.println("         - 2. 검색");
//	System.out.println("         - 3. 삭제");
//	System.out.println("         - 4. 전체목록출력");
//	System.out.println("         - 0. 종료");
//}
//
//public static void DoPrintInputMenu() {		
//	System.out.println("--------------------------------------------------------------------");
//	System.out.println("○입력상세메뉴");
//	System.out.println("         - 1. 일반");
//	System.out.println("         - 2. 대학");
//	System.out.println("         - 3. 회사");
//	System.out.println("         - 4. 동호회");
//	System.out.println("--------------------------------------------------------------------");
//}

public interface MenuInterface {

		int EXIT = 0;
		int INSER_SAVE = 1;
		int SEARCH = 2;		
		int DELETE = 4;
		int PRINT_ALL = 5;
		int MODIFY = 3;

		
		int GENERAL = 1;
		int UNIVERSITY = 2;
		int COMPANY = 3;
		int CLUB = 4;
		
		
}
