package 복습.part7.view;

import java.util.Scanner;

import 복습.part7.controller.MemberController;

public class MainPage {
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() { return mainPage; }
	private MainPage() {}
	Scanner sc = new Scanner(System.in);
	public void startView() {
		
		while(true) {
			System.out.println("------회원 가입-------");
			System.out.print("1.회원가입 2.로그인 선택> ");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				joinView();
			}
			else if(ch == 2) {
				loginView();
			}
		}
	}
	
	public void joinView() {
		System.out.print("아이디 : "); String id = sc.next();
		System.out.print("비밀번호 : "); String pw = sc.next();
		System.out.print("이름 : "); String name = sc.next();
		System.out.print("전화번호 : "); String phone = sc.next();
		System.out.print("나이 : "); int age = sc.nextInt();
		
		boolean result = MemberController.getInstance().joinController(id, pw, name, phone, age);
		
		if(result) System.out.println("회원가입 성공");
		else System.out.println("회원가입 실패");
	}
	
	public void loginView() {
		System.out.print("아이디 : "); String id = sc.next();
		System.out.print("비밀번호 : "); String pw = sc.next();
		
		boolean result = MemberController.getInstance().loginController(id, pw);
		if(result) System.out.println("로그인 성공");
		else System.out.println("로그인 실패");
	}
}
