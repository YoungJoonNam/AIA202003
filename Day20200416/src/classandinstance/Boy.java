package classandinstance;

//import card.Card;

public class Boy {
	
	// 구슬의 개수
	int numOfMarble;
	
	Boy(){
		
	}
	
	Boy(int num){
		numOfMarble = num;
	}
	// 구슬의 개수 설정
	void setMarble(int num) {
		numOfMarble = num;
	}
	
	void gameWin(Boy boy, int num) {
		numOfMarble+=num;
		boy.numOfMarble-=num;
	}
	
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 " + numOfMarble + " 입니다");
	}
	
	

	public static void main(String[] args) {

		Boy boy1 = new Boy(15);
		Boy boy2 = new Boy(9);
		
//		boy1.setMarble(15);
//		boy2.setMarble(9);
		
		System.out.println("--------------------------------------------");
		System.out.println("[철수]" );
		boy1.showData();
		System.out.println("[영희]" );
		boy2.showData();
		System.out.println("--------------------------------------------");
		
		System.out.println("1차 게임>철수는 영희의 구슬을 2개 획득");
		boy1.gameWin(boy2, 2);
		
		System.out.println("--------------------------------------------");
		System.out.println("[철수]" );
		boy1.showData();
		System.out.println("[영희]" );
		boy2.showData();
		System.out.println("--------------------------------------------");
		
		System.out.println("2차 게임>영희는 철수의 구슬을 7개 획득");
		boy2.gameWin(boy1, 7);
		
		System.out.println("--------------------------------------------");
		System.out.println("[철수]" );
		boy1.showData();
		System.out.println("[영희]" );
		boy2.showData();
		System.out.println("--------------------------------------------");
		
		
		
	}

}
