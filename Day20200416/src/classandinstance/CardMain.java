package classandinstance;

public class CardMain {

	public static void main(String[] args) {
		
		// 인스턴스 생성
		Card c1 = new Card();
		c1.kind="Heart";
		c1.number=7;
		
		// 인스턴스 생성
		Card c2 = new Card();
		c2.kind="Spade";
		c2.number=4;
		
		System.out.println("첫번째 카드는 "+c1.kind+c1.number );
		System.out.println("두번째 카드는 "+c2.kind+c2.number );
		
		
		Card[] cArrayCard;
		cArrayCard = new Card[52];
		
		
		for(int i=0;i<13;i++) {
			
			cArrayCard[i] = new Card();
			cArrayCard[i].number = i+1;
			cArrayCard[i].kind = "Spade";
			
			cArrayCard[i+13] = new Card();
			cArrayCard[i+13].number = i+1;
			cArrayCard[i+13].kind = "Dia";
			
			cArrayCard[i+26] = new Card();
			cArrayCard[i+26].number = i+1;
			cArrayCard[i+26].kind = "Heart";
			
			cArrayCard[i+39] = new Card();
			cArrayCard[i+39].number = i+1;
			cArrayCard[i+39].kind = "Clover";		
		}
		
		int aa=0;

	}

}
