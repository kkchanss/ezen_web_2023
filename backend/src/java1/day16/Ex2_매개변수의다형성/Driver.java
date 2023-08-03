package java1.day16.Ex2_매개변수의다형성;

public class Driver {
	// 매개변수의 다형성 예제의 메소드 선언
	public void drive( int value, Vehicle vehicle) {
		// 매개변수에 부모객체와 다양한 자식객체들이 자동타입변환 해서 매개변수 들어온 상태 
			// * 타입 확인 : 객체명 instanceof 클래스명  : 해당 객체가 해당 클래스의 타입이면 true / false
		System.out.println("vehicle 타입 확인 : " + (vehicle instanceof Bus));
		System.out.println("vehicle 타입 확인 : " + (vehicle instanceof Taxi));
			// * 강제타입변환 : 1. 태생 자식객체( 자동타입변환으로 부모객체된 객체 )  2. 캐스팅
			Bus bus2 = (Bus)vehicle;
			if(vehicle instanceof Bus ) { System.out.println("버스 전진");  Bus bus = (Bus)vehicle;}
			if(vehicle instanceof Taxi) { System.out.println("택시 전진"); Taxi taxi = (Taxi)vehicle;}
		vehicle.run();
	}
}
