package java1.day15.Ex2_자동타입변환;

public class Ex2_실행 {
	public static void main(String[] args) {
			
		// 1. 부모객체 생성
		Parent parent = new Parent();
		
		
		// 2. 자식객체 생성 [ 자식객체는 힙생성시 부모객체 힙도 생성 ]
		Child child = new Child();
		
		// 3. 자식객체를 부모객체에 대입?
		Parent parent2 = child; // 가능 : 자식객체는 부모객체가 될 수 있다
		// !! : 자식 객체가 부모객체로 대입 후에 변환된 부모객체는 자식객체의 멤버 사용 x
		parent2.method1(); // *단 : 오버라이딩 된 자식 메소드는 사용 가능
		parent2.method2();
		//parent2.method3();
		
		// 4. 부모객체를 자식객체에 대입
		// Parent parent4 = new Parent();
		// Child child2 = parent4; // 불가능 : 부모객체는 자식객체가 될 수 없다
		
		// !! : (강제타입변환) : 캐스팅
		Parent parent3 = new Child(); // 자동 타입 변환 후에 강제 타입 변환 가능하다.
		Child child2 = (Child)parent3; // *단 : 강제 가능
		// !! : 부모객체가 자식객체로 대입 후에 변환된 자식객체는 부모객체의 멤버 사용할 수 있다.
	}
}
