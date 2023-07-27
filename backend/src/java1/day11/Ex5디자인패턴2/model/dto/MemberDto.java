package java1.day11.Ex5디자인패턴2.model.dto;

public class MemberDto { // 데이터 모델/형식 이동 객체
	// 1. 필드 : 모든 필드는 private
	private String id; 
	private String pw;
	private String name;
	private String phone;
	private int age;
	
	// 2. 생성자 	
		// 1. 빈 생성자
	public MemberDto() {}
	public MemberDto(String id, String pw) {}
		// 2. 풀 생성자
	public MemberDto(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	// 3. 메소드 
		// 1. setter or getter : 필드가 private인 경우 간접접근
		
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
		// 2. toString : 객체의 필드 상태를 확인하기 위한 객체

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
}
