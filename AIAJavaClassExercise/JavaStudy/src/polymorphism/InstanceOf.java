package polymorphism;

class InstanceOf {
	public static void wrapBox(Box box) {		
		box.wrap();
	}	
// 변경전		
//	public static void wrapBox(Box box) {
//		if (box instanceof GoldPaperBox)
//			((GoldPaperBox) box).goldWrap();
//		else if (box instanceof PaperBox)
//			((PaperBox) box).paperWrap();
//		else
//			box.simpleWrap();
//	}

// 변경전
//	public static void wrapBox(Box box){
//		box.wrap();
//	}
	
	public static void main(String[] args) {
		Box box1 = new Box();
//		PaperBox box2 = new PaperBox();
//		GoldPaperBox box3 = new GoldPaperBox();
		
		Box box2 = new PaperBox();
		Box box3 = new GoldPaperBox();
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		wrapBox((Box)box3); //부모메서드 로 인식 안됨
		
		
		((GoldPaperBox)box3).warpParent(); 
		//꼭하고 싶다면 이런식으로. 하지만 권장하지 않음.
		//이렇게 사용되야한다는 것 자체가 잘못된 설계
	}
}

class Box {
	public void simpleWrap() {
		System.out.println("simple wrap");
	}
	void wrap() {
		System.out.println("simple wrap");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("paper wrap");
	}
	@Override
	void wrap() {
		System.out.println("paper wrap");
	}
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("gold wrap");
	}
	@Override
	void wrap() {
		System.out.println("gold wrap");
	}
	
	void warpParent() {
		super.wrap();
	}
}