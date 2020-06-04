package classandinstance;

//작성자		: 남영준
//수정일		: 2020.04.17
//수정내용	: 생성자로 변수 초기화 ,showResult() 생성
public class FruitSeller {

	
	//	속성 : 변수
	// 		사과의 개수
	// 		수입
	// 		사과의 가격
	//	멤버 변수, 인스턴스 변수

	// 수정 : 변수의 명시적 초기화 생략 2020.04.17
//	int numofApple = 20;		// 사과의 개수
//	int myMoney = 0;			// 수입
//	final int PRICE = 1000;			// 사과의 가격
	
	int numofApple;		// 사과의 개수
	int myMoney;			// 수입
	final int APPLE_PRICE;			// 사과의 가격
	
	// 생성자 2020.04.07
	FruitSeller(){
//		numofApple = 20;		
//		myMoney = 0;		
//		APPLE_PRICE = 1000;

		this(20, 0, 1000);
	}
	
	FruitSeller(int price) {
		this(20, 0, price);
	}
	
	FruitSeller(int num, int money, int price){
		numofApple = num;		
		myMoney = money;		
		APPLE_PRICE = price;
	}
	
	
	
	
	
	
	
	
	
	//	판매 기능 : 메서드
	//	1. 돈을 받는다. => 매개변수 int money
	//	2. 받은 돈의 사과의 개수
	//	3. 나의 사과 개수에서 반환해야 하는 사과의 개수를 빼준다.
	//	4. 받은 금액은 나의 수입으로 더해준다.
	//	5. 사과의 개수를 반환한다. 
	//		=> 반환 데이터, int return 사과의 개수
	int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numofApple -= num;
		myMoney += money;
		return num;
	}

	void showResult() {
		System.out.println("사과의 개수 : "+numofApple+" 보유금액 : "+myMoney);
	}
	
}
