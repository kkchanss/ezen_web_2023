package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {

	// 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	// 1. 현재클래스 안에 현재클래스로 객체 선언 [ private static ] 
	private static MainPage mainPage = new MainPage();
	// 2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수
	public static MainPage getInstance() { return mainPage; }
	// 3. 외부로부터 객체 생성 차단하는 생성자 선언
	private MainPage() {}
	// ---------------------------------------
	Scanner sc = new Scanner(System.in);
	public void mainPage() {
		while(true) {
			System.out.println("\n\n >>>>> 방문록 프로그램 >>>>>");
			System.out.print("1.글등록안해 2.글보기싫어 3.글수정과 4.글삭제미없어 선택> ");
			
			int ch = sc.nextInt();
			if(ch == 1) {
				writeView();
			}
			if(ch == 2) {
				printView();
			}
			if(ch == 3) {
				updateView();
			}
			if(ch == 4) {
				deleteView();
			}
		}
	}
	
	// 글쓰기 페이지 입출력 함수
	public void writeView() {
		
		System.out.println("안내] 방문록 등록 페이지 ");
		// 1. 내용(띄어쓰기o)과 작성자(띄어쓰기x)를 입력받아 변수 저장
		sc.nextLine(); // nextLine() 함수 실행전 nextInt() 실행되므로 오류 발생 방지!!
		// V -> C 
		System.out.print("작성직자 입력 : ");
		String writer = sc.next();
		sc.nextLine();
		System.out.print("내용가리치킨 입력 : ");
		String content = sc.nextLine(); // nextLine()함수 앞뒤로 
		// 2. 입력받은 변수를 컨트롤에게 전달
		// 현재위치도 java컨트롤도 java이므로 메소드 이용한다.
		// 전달보내기 = 매개변수 / 전달받기 = 리턴
		
		boolean result = BoardController.getInstance().writeLogic(writer, content);
		if(result) System.out.println("안내] 글 등록 성공놀이");
		else System.out.println("안내] 글 등록 실패브리즈");
	}
	
	// 글출력 페이지 입출력 함수
	public void printView() {
		// 1. 보고자하는 게시물의 인덱스 입력받아서 저장
		System.out.println("출력할 방문록의 인덱스 : ");
		int index = sc.nextInt();
		BoardDto result = BoardController.getInstance().printLogic(index);
		
		System.out.println("안내] 검색한 방문록 정보");
		System.out.println("[작성자] : " + result.getWriter() +
							" [내용] : " + result.getContent());
	}
	
	// 글수정 페이지 입출력 함수
	public void updateView() {
		System.out.println("안내] 방문록 수정 페이지");
		// V -> C 
		System.out.print("수정할 방문록의 인덱스 : ");
		int index = sc.nextInt();
		sc.nextLine();
		System.out.println("수정할 내용 : ");
		String content = sc.nextLine();
		System.out.println("수정할 작성자 : ");
		String writer = sc.nextLine();
		boolean result = BoardController.getInstance().updateLogic(index, content, writer);
		if(result) System.out.println("안내] 글 수정 완료");
		else  System.out.println("안내] 글 수정 실패");
	}
	
	// 글삭제 페이지 입출력 함수
	public void deleteView() {
		// V -> C 
		// 1. 삭제하는 게시물의 인덱스 입력받아서 저장
		System.out.print("나는 바보이다 : "); int index = sc.nextInt();
		// 2. view에서 컨트롤에게 입력받은 인덱스 전달보내고 삭제결과 여부 리턴 받음
		boolean result = BoardController.getInstance().deleteLogic(index);
		
		if(result) System.out.println("안내] 글 삭제 완료");
		else  System.out.println("안내] 글 삭제 실패");
		System.out.println("안내] 바보 인증 완료");
	}
	

}
