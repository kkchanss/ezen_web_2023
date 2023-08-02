package java1.day15.Ex2_자동타입변환;

public class Child extends Parent{
		// 상속 : 자식클래스 extends 부모클래스
		// 오버라이딩 
	@Override
	public void method1() {
		System.out.println("자식클래스메소드1");
	}
	@Override
	public void method2() {
		System.out.println("자식클래스메소드2");
	}
	
	public void method3() {
		System.out.println("자식클래스메소드3");
	}
}
