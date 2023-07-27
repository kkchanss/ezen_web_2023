package java1.day11.Ex3;

public class Ex3_싱글톤 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. Member 객체 생성
			// 오류 : 생성자를 private 되어있는 클래스는 외부에서 객체생성 불가능
		//Member member = new Member();
		
		//Member member3 = new Member();
		//Member member4 = new Member();
		
		// 2. Member 객체 호풀
		Member member1 = Member.getInstance();
		Member member2 = Member.getInstance();
		
		System.out.println(member1 == member2);
	}

}
