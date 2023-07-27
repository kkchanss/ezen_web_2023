package java1.day11.Ex5디자인패턴2.view;

import java.util.Scanner;

import java1.day11.Ex5디자인패턴2.controller.MemberController;

public class MainPage { // 입출력 담당하는 클래스 // view -> HTML/JS
	// 0. 싱글톤 생성
		// 1. 현재 클래스에 static 객체 생성, 필드는 무조건 잠금
	private static MainPage mainPage = new MainPage();
		// 2. 외부 객체에서 해당 싱글톤 호출하기 위한 메소드
	public static MainPage getInstance() { return mainPage; }
		// 3. 객체 외부에서 해당 클래스로 객체 생성 잠금, 생성자를 private
	private MainPage() {}
	
	// 1. 필드
	private Scanner sc = new Scanner(System.in);
	
	// 2. 생성자
	
	// 3. 함수
	public void mainPage() {
	
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); // 1. 무한 출력
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");  
			// 입력 객체의 사용 구역 범위 생각! [ 프로그램 내 전체구역 = static ] 
		
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { signupPage(); } // main 함수 밖에 있는 다른 함수 호출
			// 1. 인스턴스(static없는) 함수는 객체를 생성하고 호출한다.
			// 2. 정적멤버(static있는) 함수는 객체없이 클래스를 통해 호출한다.
			else if( ch == 2 ) { loginPage(); }  
			else if( ch == 3 ) { findIdPage(); } 
			else if( ch == 4 ) { findPwPage(); } 
			
		} // while e
	}
	
	// 회원가입
	void signupPage() {
		System.out.println("----------회원가입----------");
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
		// ---> 컨트롤러/서빙에게 전달
		// 컨트롤 클래스내 메소드 호출
		boolean result = MemberController.getInstanse().signupLogic(id, pw, name, phone, age);
		if(result) {
			System.out.println("안내)회원가입성공");
		}
		else {
			System.out.println("안내)회원가입실패");
		}
	}
	
	// 로그인
	void loginPage() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		boolean result = MemberController.getInstanse().loginLogic(id, pw);
		if(result) {
			System.out.println("안내)로그인성공");
		}
		else {
			System.out.println("안내)로그인실패");
		}
	}
	
	// 아이디 찾기
	void findIdPage() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		String result = MemberController.getInstanse().findIdLogic(name, phone);
		if(result != null) {
			System.out.println("안내)아이디는 " + result + "입니다.");
		}
		else {
			System.out.println("안내)아이디찾기실패");
		}
	}
	
	// 비밀번호 찾기
	void findPwPage() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		String result = MemberController.getInstanse().findPwLogic(id, phone);
		if(result != null) {
			System.out.println("안내)비밀번호는 " + result + "입니다.");
		}
		else {
			System.out.println("안내)비밀번호찾기실패");
		}
	}
}
