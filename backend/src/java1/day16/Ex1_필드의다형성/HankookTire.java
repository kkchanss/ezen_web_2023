package java1.day16.Ex1_필드의다형성;

public class HankookTire extends Tire {
		// 상속 : 자식클래스 extends 부모클래스
	
	// !오버라이딩 : 부모클래스의 메소드를 물려받았지만 재정의 (오버라이딩)
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		//super.roll(); // super.메소드() : 부모메소드 호ㅜㄹ
		// 새로운 코드 = 재정의
		System.out.println("한국 Tire 회전");
	}
}
