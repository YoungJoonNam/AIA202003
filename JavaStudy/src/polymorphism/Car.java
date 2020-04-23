package polymorphism;

public class Car {

	String color;
	int door;

	void drive() { // 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() { // 멈추는 기능
		System.out.println("stop!!!");
	}
	
	public static void main(String[] args) {
		
		Car car = null;
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		Ambulance am = null;
		
		fe1.water();
		car = fe1;
		//오류케이스 car.water();
		fe2 = (FireEngine)car;
		fe1.water();
		//오류케이스 am = (Ambulance)car;
		//오류케이스 am.siren();
		System.out.println(car instanceof Ambulance);
		
		if(car instanceof Ambulance) {
			am = (Ambulance)car;
			am.siren();
		}
	}
}

class FireEngine extends Car { 
	void water() { // 물을 뿌리는 기능
		System.out.println("물뿌리기");
	}
}


class Ambulance extends Car { 
	void siren() { 
		System.out.println("사이렌");
	}
}