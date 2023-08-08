package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;


public class MainPage {
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	
	// 0. 입력 객체
	private Scanner sc = new Scanner(System.in);
	
	// 1. 메인 메뉴
	public void mainView() {
		while(true) {
			System.out.println("-------회원제 커뮤니티--------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 선택> ");
			try {
				int ch = sc.nextInt();
				if(ch == 1) {
					signupView();
				}
				if(ch == 2) {
					loginView();
				}
				if(ch == 3) {
					findByIdView();
				}
				if(ch == 4) {
					findByPwView();
				}
			}catch(Exception e) {
				System.out.println("경고] 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기
			}
			
		}
	}
	// 2. 회원가입
	public void signupView() {
		// 1. 출력에 따른 입력값 받는다.
		System.out.println("-------- 회원가입 페이지 -------");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : "); 	String pw = sc.next();
		System.out.print("이름 : "); 		String name = sc.next();
		System.out.print("전화번호 : "); 	String phone = sc.next();
		// 2. 입력받은 값을 컨트롤에게 전달
		int result = MemberController.getInstance().signupLogic(id, pw, name, phone);
		if(result == 1) System.out.println("안내] 회원가입 완료");
		else if(result == 2) System.out.println("경고] 회원가입 실패 [관리자에게 문의]");
		else if(result == 3) System.out.println("경고] 아이디 중복");
		else if(result == 4) System.out.println("경고] 비밀번호 중복");
	}
	// 3. 로그인
	public void loginView() {
		System.out.println("-------- 로그인 페이지 -------");
		System.out.print("아이디 : "); 	String id = sc.next();
		System.out.print("비밀번호 : "); 	String pw = sc.next();
		boolean result = MemberController.getInstance().loginLogic(id, pw);
		if(result) { 
			System.out.println("안내] 로그인 완료");
			// 만약에 로그인 성공하면 다른 view 클래스로 이동 
			LoginPage.getInstance().loginMenuView();
		}
		else System.out.println("경고] 로그인 실패");
	}
	
	// 4. 아아디 찾기
	public void findByIdView() {
		System.out.println("------아이디 찾기 페이지-------");
		System.out.print("이름> "); String name = sc.next();
		System.out.print("전화번호> "); String phone = sc.next();
		
		String result = 
				MemberController.getInstance().findByIdLogic(name,phone);
		
		if(result != null) System.out.println("회원님의 아이디 : " + result);
		else System.out.println("경고] 정보가 일치한 아이디가 없습니다.");
	}
	
	// 5. 비밀번호 찾기
	public void findByPwView() {
		System.out.println("------비밀번호 찾기 페이지-------");
		System.out.print("아이디> "); String id = sc.next();
		System.out.print("전화번호> "); String phone = sc.next();
		
		String result = 
				MemberController.getInstance().findByPwLogic(id,phone);
		
		if(result != null) System.out.println("회원님의 비밀번호 : " + result);
		else System.out.println("경고] 정보가 일치한 비밀번호가 없습니다.");
	}
}
