package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class LoginPage {
	// 0. 싱글톤 
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() {return loginPage;}
	private LoginPage() {}
	// 0. 입력객체
	private Scanner sc = new Scanner(System.in);
	// 1. loginMenu : 로그인했을때 접속 
	public void loginMenuView() {
		
		while(MemberController.getInstance().getLoginSession() != 0) {
			
			System.out.println("\n\n ===== ===== ===== ===== ");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 선택 : ");
			
			try {
				int ch = sc.nextInt();
				if(ch == 1) { MemberController.getInstance().logOut();}
				if(ch == 2) { infoView(); }
				if(ch == 3) { boardWriteView();}
			}catch(Exception e) {
				System.out.println("경고] 잘못된 입력입니다.");
				sc = new Scanner(System.in);
			}
		}
		
	}
	
	// 2. info : 회원정보 페이지
	public void infoView() {}
	
	// 3. infoUpdate : 회원정보수정 페이지
	public void infoUpdateView() {}
	
	// 4. infoDelete : 회원탈퇴 페이지
	public void infoDeleteView() {}
	
	// 5. boardWrite : 게시물쓰기 페이지 
	public void boardWriteView() {}
	
	// 6. boardPrint : 모든 게시물 출력 페이지
	public void boardPrintView() {}
	
	// 7. boardView : 개별 게시물 출력 페이지
	public void boardView() {}
	
	// 8. boardUpdate : 게시물 수정 페이지
	public void boardUpdate() {} 
	
	// 9 boardDelete : 게시물 삭제 페이지
	public void boardDelete() {}
}
