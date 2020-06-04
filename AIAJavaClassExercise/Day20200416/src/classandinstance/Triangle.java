package classandinstance;

public class Triangle {
	
	// 변수 : 밑변, 높이
	int width; // 밑변의 데이터
	int height; // 높이의 데이터
	
	// 생성자 : 인스턴스 생성시에 반드시 한번 실행
	//	-> 인스턴스 변수들의 초기화 작업
	//	생략가능 (default Constructor)
	
	// 기본 생성자
	Triangle( ){
		
	}
	
	Triangle(int w, int h ){
		width=w;
		height=h;
	}
	
	// 밑변과 높이 데이터를 변경하는 메서드
	void setData(int w, int h) {
		width=w;
		height=h;
	}

	// 삼각형의 넓이를 구해서 반환하는 메서드
	float area() {
		float result = width*height/2f;
		return result;
	}
	
	
	public static void main(String[] args) {
		
		//Triangle t = new Triangle();
		Triangle t = new Triangle(5,3);
		
		//t.setData(10, 3);
		System.out.println("삼각형의 밑변 " + t.width + " 삼각형의 높이 "+t.height);
		System.out.println("삼각형의 넓이 " + t.area());
		
	}
}

