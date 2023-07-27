package 과제.과제10.개인과제;


public class Member {
	
	// 1. 필드 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버static
	String id; 
	String pw;
	String name;
	String phone;
	int age;
	
	// 2. 생성자 : 객체의 초기화를 담당 역할 = 인스턴스 vs 정적멤버static 
	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	// 3. 메소드 : 객체의 행동을 담당 역할 = 인스턴스 vs 정적멤버static
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

/*
	
	JVM : 자바 가상(논리적으로 만들어낸) 메모리
	
		Member.java ----- 클래스로더 ----> Member.class --------> 메소드영역						스택영역				힙영역
		자바 코드파일						바이트코드파일				클래스 코드, 메소드 코드,			{ }					new			
																정적멤버											this
															
		this	: 인스턴스멤버 : new 힙생성시 할당되고 힙 초기화될때 [ GC ] [ 공용x, 각각 ]
			- static 키워드 없으면
			- 객체를 통해 사용
		static  : 정적멤버 : 프로그램 시작 할당 되고 프로그램이 종료될떄 [ 전역 / 공통 / 공용 / 공유 ]
					- static 키워드 있으면
					- 클래스 통해 사용
		final	: 수정 불가 : 초기화할때 대입만 가능하고 수정 불가능
		static final : 상수 : 프로그램 내에서 1개만 저장 ( static ) 수정불가능 ( final ) 합친 키워드
*/
