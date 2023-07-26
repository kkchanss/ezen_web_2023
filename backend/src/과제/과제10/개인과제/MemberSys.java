package 과제.과제10.개인과제;

import java.util.Arrays;
import java.util.Scanner;


public class MemberSys {
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}
	
	static void 회원가입 () { 
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i]!=null) {
				if(id.equals(memberList[i].getId()) ) {
					System.out.println("이미 있는 아이디입니다. 다시 회원가입을 진행해주시길 바랍니다. ");
					return;
				}
			}
		}
		Member member = new Member(id,pw,name,phone,age);
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i]==null) {
				memberList[i] = member;
			}
		}
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	static void 로그인 () {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i]!=null) {
				if(id.equals(memberList[i].getId())  && pw.equals(memberList[i].getPw()) ) {
					System.out.println("로그인 성공");
					return;
				}
			}
		}
		System.out.println("로그인 실패");
	}
	static void 아이디찾기 () { 
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i]!=null) {
				if(name.equals(memberList[i].getName())  && phone.equals(memberList[i].getPhone())) {
					System.out.println("찾은 아이디 : " + memberList[i].getId());
					return;
				}
			}
		}
		System.out.println("해당 정보의 아이디가 없음");
	}
	static void 비밀번호찾기 () {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i]!=null) {
				if(id.equals(memberList[i].getId())  && phone.equals(memberList[i].getPhone())) {
					int num = (int) (Math.random()*10000); 
					System.out.println("임시 비밀번호 : " + num);
					memberList[i].setPw(Integer.toString(num));
					return;
				}
			}
		}
	}
	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














