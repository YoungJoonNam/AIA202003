package polymorphism;

// 상품 객체들의 상위 클래스
public class Product {

	final int price; // 제품 가격
	final int bounusPoint; // 제품의 포인트

	Product(int price) {
		this.price = price;
		this.bounusPoint = this.price / 10;
	}

	@Override
	public String toString() {
		String returnString = "Product" + " : " + getClass().getName() + "@" + Integer.toHexString(hashCode());
		return returnString;
	}

	public static void main(String[] args) {

		Product pa = new Product(100);
		Product pb = new Product(100);

		System.out.println(pa.toString());
		System.out.println(pb.toString());

		Tv t = new Tv(1000);
		System.out.println(t.toString());

		System.out.println("=============================");

		Computer com = new Computer(1000);

		Product p1 = t;
		Product p2 = com;
		
		Buyer b = new Buyer();
		
		b.buy(t);
		b.buy(com);
		
		b.PrintBuyerState();
		b.summary();
		
		System.out.println("=============================");
		
		Product[] products = new Product[3];
		products[0] = new Tv(1000);
		products[1] = new Computer(1500);
		products[2] = new Audio(700);
		
		int sumOfPrice=0;
		int sumOfPoint=0;
		
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i]);
			sumOfPrice += products[i].price;
			sumOfPoint += products[i].bounusPoint;			
		}
		
		System.out.println("전체 제품의 Price : "+sumOfPrice+" Point : "+sumOfPoint);
		
		

	}

}

class Tv extends Product {

	Tv(int price) {
		super(price);
	}

	@Override
	public String toString() {
		//String returnString = "Tv" + " : " + getClass().getName() + "@" + Integer.toHexString(hashCode());
		//return returnString;
		return "Tv";
	}
}

class Computer extends Product {

	Computer(int price) {
		super(price);
	}

	@Override
	public String toString() {
		//String returnString = "Computer" + " : " + getClass().getName() + "@" + Integer.toHexString(hashCode());
		//return returnString;
		return "Computer";
	}
}

class Audio extends Product {

	Audio(int price) {
		super(price);
	}

	@Override
	public String toString() {
		//String returnString = "Audio" + " : " + getClass().getName() + "@" + Integer.toHexString(hashCode());
		//return returnString;
		return "Audio";
	}
}

class Buyer {

	int money = 10000;
	int bonusPoint = 0;
	Product[] item = new Product[10];
	int numofProduct=0; // Product counter

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족해요 ㅠ.ㅠ");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bounusPoint;
		item[numofProduct++] = p;
		System.out.println(p + " 구입 완료!!_^.^)/");
		
	}
	
	void summary() {
		int sumM = 0;
		int sumP = 0;
		String itemList ="";
		
		for (int i = 0; i < numofProduct; i++) {
			if(item[i]==null) break;
			sumM += item[i].price;
			sumP += item[i].bounusPoint;
			itemList += item[i] + ", ";			
		}
		
		System.out.println("구입하신 제품는 "+itemList+" 입니다.");
		System.out.println("구입하신 제품의 총 금액은 "+sumM+" 만원입니다.");
		System.out.println("적립된 총 포인트는 "+sumP+" 입니다.");
		
		
	}
	
	void PrintBuyerState() {
		System.out.println("현재 남은 돈은 : "+money+" 입니다");
		System.out.println("현재 포인트는 : "+bonusPoint+" 입니다");
	}

}