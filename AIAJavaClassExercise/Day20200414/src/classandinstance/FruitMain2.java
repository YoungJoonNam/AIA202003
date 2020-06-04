package classandinstance;

public class FruitMain2 {

	public static void main(String[] args) {
		
		// seller 객체 생성
		FruitSeller seller1 = new FruitSeller(30, 0, 1000);
		FruitSeller seller2 = new FruitSeller(20, 0, 1500);
		FruitSeller seller3 = new FruitSeller();
		
		// buyer 객체 생성
		FruitBuyer buyer = new FruitBuyer(10000, 0);
		
		// seller에게 구매
		buyer.buyApple(seller1, 3000);
		buyer.buyApple(seller2, 3000);
		buyer.buyApple(seller3, 4000);
		
		// seller 의 현황 출력
		System.out.println("판매자 1의 현재 현황");
		seller1.showResult();
		System.out.println("판매자 2의 현재 현황");
		seller2.showResult();
		System.out.println("판매자 3의 현재 현황");
		seller3.showResult();

	}

}
