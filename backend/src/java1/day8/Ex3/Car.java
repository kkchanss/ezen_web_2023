package java1.day8.Ex3;

//현 클래스의 사용목적 : 설계도
public class Car { // class s

		// 1. 필드 : 객체의 데이터를 저장하는 곳 * 변수와 비슷하지만 다름
		String model; // 선언시 = (대입) 초기화 값이 없으므로 기본값인 null로 초기화
		boolean start; // 선언시 = (대입) 초기화 값이 없으므로 기본값인 false로 초기화
		int speed; // 선언시 = (대입) 초기화 값이 없으므로 기본값인 0로 초기화
		// 2. 생성자 : 객체 생성시 초기화 역할 담당 * 클래스명과 동일하게 선언
		// 3. 메소드 : 객체의 동작으로 호출시 실행되는 블록
		void method() { System.out.println(model); }
} // class e
