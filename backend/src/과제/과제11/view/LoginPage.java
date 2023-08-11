package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.controller.MessageController;
import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.model.dto.MessageDto;

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
			boardPrintView();
			System.out.println("\n\n ===== ===== ===== ===== ");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 4.글조회 선택 : ");
			
			try {
				int ch = sc.nextInt();
				if(ch == 1) { MemberController.getInstance().logOut();}
				if(ch == 2) { infoView(); }
				if(ch == 3) { boardWriteView();}
				if(ch == 4) { boardView();}
			}catch(Exception e) {
				System.out.println("경고] 잘못된 입력입니다.");
				sc = new Scanner(System.in);
			}
		}
		
	}
	
	// 6. info : 로그인된 회원정보 페이지
	public void infoView() {
		System.out.println("\n\n ===== info ===== ");
		// 1. 컨트롤에게 회원정보 요청해서 반환 받기
		MemberDto result = MemberController.getInstance().infoLogic();
		System.out.println(">ID : " + result.getMid());
		System.out.println(">NAME : " + result.getMname());
		System.out.println(">PHONE : " + result.getMphone());
		
		// 2. 서브메뉴
		System.out.print("1. 비밀번호 수정 2. 회원탈퇴 3. 뒤로가기 4. 쪽지 확인 선택> ");
		int ch = sc.nextInt();
		if(ch == 1) { infoUpdateView(); }
		if(ch == 2) { infoDeleteView(); }
		if(ch == 3) { return; } // 생략 가능
		if(ch == 4) { messageCheckView();} 
	}
	
	// 7. infoUpdate : 회원정보수정 페이지
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
	
	// 8. infoDelete : 회원탈퇴 페이지
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
	
	// 9. boardWrite : 게시물쓰기 페이지 
	public void boardWriteView() {
		sc.nextLine();
		System.out.println("-------- post write -------");
		System.out.print("제목 > "); 	String title = sc.nextLine();
		System.out.print("내용 > "); 	String content = sc.nextLine();
	
		boolean result = BoardController.getInstance().boardWriteLogic(title, content);
		if(result) System.out.println("안내] 글쓰기 성공");
		else System.out.println("안내] 글쓰기 실패 : 관리자 문의");
	}	
	// 10. boardPrint : 모든 게시물 출력 페이지
	public void boardPrintView() {
		System.out.println(" ----- post List ----- ");
		ArrayList<BoardDto> result = BoardController.getInstance().boardPrintLogic();
		// 2. 출력
		System.out.printf("%-3s %-4s %-20s %-10s %s \n", "no", "view", "date", "mid", "title");
		for(int i = 0; i < result.size(); i++) {
			BoardDto boardDto = result.get(i);
			
			System.out.printf("%-3s %-4s %-20s %-10s %s \n", 
					boardDto.getBno(), boardDto.getBview(), 
					boardDto.getBdate(), boardDto.getMid(), 
					boardDto.getBtitle()
 			);
		}
		
	}
	
	// 11. boardView : 개별 게시물 출력 페이지
	public void boardView() {
		System.out.println(" ----- post VIEW ----- ");
		// 1. 보고자하는 게시물의 게시물번호를 입력받기[식별번호]
		System.out.println("게시물 번호 : "); int bno = sc.nextInt();
		// 2.
		BoardDto result = BoardController.getInstance().boardViewLogic(bno);
		// 3. 출력
		System.out.printf("bno : %3s view : %3s mid : %10s date : %20s \n",
					result.getBno(), result.getBview(), result.getMid(),
					result.getBdate()
		);
		System.out.printf("title : %s \n", result.getBtitle());
		System.out.printf("content : %s \n", result.getBcontent());
		// 4. 추가메뉴
		System.out.println("1.뒤로가기 2.수정 3.삭제 4.쪽지보내기 선택> "); int ch = sc.nextInt();
		if(ch == 1) {}
		if(ch == 2) { boardUpdateView(bno, result.getMno());}
		if(ch == 3) { boardDeleteView(bno, result.getMno());}
		if(ch == 4) { messageSendView(result.getMno());}
	}
	
	// 12. boardUpdate : 게시물 수정 페이지
	public void boardUpdateView(int bno, int mno) {
		
		System.out.println(" ----- post UPDATE ----- ");
		sc.nextLine();
		
		System.out.print("수정할 제목 : "); String title = sc.nextLine();
		System.out.print("수정할 내용 : "); String content = sc.nextLine();
		int result = BoardController.getInstance().boardUpdateLogic(bno, mno, title, content);
		if(result == 4) System.out.println("제목이 너무 깁니다");
		else if(result == 3) System.out.println("해당 게시물의 작성자가 아닙니다.");
		else if(result == 1) System.out.println("수정 완료");
		else if(result == 2) System.out.println("수정 실패");
	} 
	
	// 13 boardDelete : 게시물 삭제 페이지
	public void boardDeleteView(int bno, int mno) {
//		if(mno != MemberController.getInstance().getLoginSession()) {
//			System.out.println("해당 게시물의 작성자가 아닙니다.");
//			return;
//		}
		System.out.println(" ----- post DELTE ----- ");
		boolean result = BoardController.getInstance().boardDeleteLogic(bno, mno);
		if(result) System.out.println("삭제 완료");
		else System.out.println("삭제 실패");
	}
	
	// 14. 쪽지보내기 페이지
	public void messageSendView(int mno) {
		sc.nextLine();
		System.out.print("보낼 내용 : "); String content = sc.nextLine();
		boolean result = MessageController.getInstance().messageSendLogic(mno, content);
		if(result) System.out.println("쪽지 보내기 성공");
		else System.out.println("쪽지 보내기 실패");
	}
	
	
	// 15. 쪽지확인 페이지 // + 쪽지 답장 보내기 
	public void messageCheckView() {
		System.out.println("---------쪽지 함-----------");
		ArrayList<MessageDto> result = MessageController.getInstance().messageCheckLogic();
		
		for(int i = 0; i < result.size(); i++) {
			MessageDto dto = result.get(i);
			System.out.printf("번호 : %-10d \t 내용 : %-20s \t 발신자 : %-10s \t 보낸 일시 : %-20s \n",
					dto.getMsno(), dto.getMscontent(), dto.getSenderid(), dto.getMsdatetime() );
		}
		
		System.out.print("1.답장하기 2.뒤로가기"); int ch = sc.nextInt();
		if(ch == 1) messageReplyView();
		if(ch == 2) return;
	}
	
	// 16. 쪽지 답장 보내기 페이지
	public void messageReplyView() {
		System.out.print("답장 보낼 쪽지를 선택해주세요. 선택> "); int ch = sc.nextInt();
		sc.nextLine();
		System.out.println("내용 입력 : "); String mscontent = sc.nextLine();
		boolean result = MessageController.getInstance().messageReplyLogic(ch, mscontent);
		if(result) System.out.println("답장 성공");
		else System.out.println("답장 실패");
	}
}
