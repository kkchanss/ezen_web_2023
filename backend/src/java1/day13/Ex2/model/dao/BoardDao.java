package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	// 싱글톤o : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() { return boardDao; }
	private BoardDao() {}
	
	// 게시물 여러개 저장하는 곳
		// 1. 배열
	public BoardDto[] boardDtoArray= new BoardDto[100];
		// 2. 리스트
	public ArrayList<BoardDto> boardList = new ArrayList<>();
		// ArrayList : 배열처럼 사용가능한 클래스 객체 선언
			// <클래스> : 리스트객체 안에 여러개 객체를 저장할 저장 객체의 타입
			// boardList : 리스트객체변수명
}

/*
 	- 리스트 선언 방법
 		ArrayList<타입명> 리스트변수명 = new ArrayList<>();
 
 	- 리스트에 값 저장하는 방법
		- 리스트객체명.add(객체명) : 해당 객체를 리스트에 저장 [ - 마지막 인덱스 뒤로 객체 추가 ]
	
	- 리스트의 값 불러오는 방법
		- 리스트객체명.get(인덱스) : 해당 인덱스의 객체를 호출
	
	- 리스트의 값 삭제하는 방법 
		- 리스트객체명.remove(인덱스) : 해당 인덱스의 객체를 삭제 [ - 중간 객체 삭제해도 자동채움 ]
*/