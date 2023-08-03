package java1.day16.Ex1_필드의다형성;

public class Car {
	public Tire tire; // Tire 클래스 타입의 필드 선언 [ 객체x ] 
	public void run() { tire.roll(); }
}
