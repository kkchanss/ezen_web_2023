package java1.day9.Ex2;

public class Korean {
	// 1. 필드
	String nation = "대한민국";	// 1. 객체마다 동일한 값을 갖고 있다면 / 객체의 필드값 미리 초기화
	String name;				// 2. 객체마다 다른 값을 가져야 한다면 / 객체의 필드값 기본값 -> 생성자
	String ssn;
	
	// 2. 생성자
		// 1. 기본 생성자 = 깡통 생성자
	public Korean() {}
		// 1. 매개변수1개인 생성자
	public Korean(String name) { }
		// 2. 매개변수2개인 생성자
	public Korean(String name, String ssn) { // 가독성(읽기좋게) 매개변수명은 필드명과 동일하게 저장
		// String n = "박자바"
		// String s = "011225-1234567"
		// this : 현재 클래스 뜻 [ 매개변수 : 외부로부터 들어온 변수명 동일할때 ]
			// this.필드명 this.메소드명()
			// this : 해당 함수/메소드/생성자 호출한 객체 = 주체자
		this.name = name; this.ssn = ssn;
	}
		// 3. 매개변수3개인 생성자 [ 1. 매개변수의 개수가 다를 경우 ]
	public Korean(String name, String ssn, String nation) { 
		this(name,ssn); this.nation = nation;
	}
		// 4. 매개변수2개인 생성자 [ 2. 매개변수의 타입이 다를 경우 ]
	public Korean(String name, int ssn) { 
		
	}
	
		// 5. 매개변수2개인 생성자 [ 3. 매개변수의 타입순서가 다를 경우 ]
	public Korean(int ssn, String name) { 
			
	}
	// 3. 메소드
	
}
