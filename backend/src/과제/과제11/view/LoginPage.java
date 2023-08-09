package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

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
	
	// 2. info : 로그인된 회원정보 페이지
	public void infoView() {
		System.out.println("\n\n ===== info ===== ");
		// 1. 컨트롤에게 회원정보 요청해서 반환 받기
		MemberDto result = MemberController.getInstance().infoLogic();
		System.out.println(">ID : " + result.getMid());
		System.out.println(">NAME : " + result.getMname());
		System.out.println(">PHONE : " + result.getMphone());
		
		// 2. 서브메뉴
		System.out.print("1. 비밀번호 수정 2. 회원탈퇴 3. 뒤로가기 선택> ");
		int ch = sc.nextInt();
		if(ch == 1) { infoUpdateView(); }
		if(ch == 2) { infoDeleteView(); }
		if(ch == 3) { return; } // 생략 가능
	}
	
	// 3. infoUpdate : 회원정보수정 페이지
	public void infoUpdateView() {
		System.out.println("\n\n ===== password Update ===== ");
		System.out.print("새로운 비밀번호 : " ); String nwePw = sc.next();
		
		boolean result = MemberController.getInstance().infoUpdateLogic(nwePw);
		if(result) {
			System.out.println("안내] 비밀번호 수정 완료 : 로그아웃합니다.");
			MemberController.getInstance().logOut();
		} else {
			System.out.println("경고] 비밀번호 수정 실패 : 관리자에게 문의");
		}
 	}
	
	// 4. infoDelete : 회원탈퇴 페이지
	public void infoDeleteView() {
		System.out.println("\n\n ===== member delete ===== ");
		System.out.print("정말 탈퇴하시겠습니까? 1.예 2.아니요 : ");
		int ch = sc.nextInt();
		if(ch == 1) {
			boolean result = MemberController.getInstance().infoDeleteLogic();
			if(result) {
				System.out.println("안내] 회원탈퇴 성공 : 로그아웃됩니다.");
				MemberController.getInstance().logOut();
			}else {
				System.out.println("경고] 회원탈퇴 실패 : 관리자에게 문의");
			}
		}
	}
	
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
