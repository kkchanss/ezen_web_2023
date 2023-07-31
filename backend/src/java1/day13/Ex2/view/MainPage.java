package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex2.controller.BoardController;

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
			System.out.print("1.글등록 2.글보기 3.글수정 4.글삭제 선택> ");
			
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
		System.out.print("작성자 입력 : ");
		String writer = sc.next();
		System.out.print("내용 입력 : ");
		String content = sc.nextLine(); // nextLine()함수 앞뒤로 
		// 2. 입력받은 변수를 컨트롤에게 전달
		// 현재위치도 java컨트롤도 java이므로 메소드 이용한다.
		// 전달보내기 = 매개변수 / 전달받기 = 리턴
		
		boolean result = BoardController.getInstance().writeLogic(writer, content);
		if(result) System.out.println("안내] 글 등록 성공");
		else System.out.println("안내] 글 등록 실패");
	}
	
	// 글출력 페이지 입출력 함수
	public void printView() {
		// V -> C 
		BoardController.getInstance().printLogic();
	}
	
	// 글수정 페이지 입출력 함수
	public void updateView() {
		// V -> C 
		BoardController.getInstance().updateLogic();
	}
	
	// 글삭제 페이지 입출력 함수
	public void deleteView() {
		// V -> C 
		BoardController.getInstance().deleteLogic();
	}
	

}
