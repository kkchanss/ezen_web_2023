package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC연동 {
	
	public static void main(String[] args)  {
		
		// ------------------------- 예외 발생할 것 같은 코드들을 try{} 안에 넣기
		try {
			// 1. p.908 : 현재 프로젝트에 JDBC 파일을 build path add 하기
			// 2. p.909 : DB연결하기 위해 JDBC Driver 클래스를 찾아서 메모리 로딩 하기
				// Class.forName("oracle.jdbc.OracleDriver"); // 오라클 기준
			Class.forName("com.mysql.cj.jdbc.Driver");			// mysql 기준
				// 만약에 해당 JDBC 드라이버 클래스가 검색이 실패하면 예외발생 - > 예외처리
			// 3. DB 연결 [ DriverManager.getConnection() 메소드가 연결 성공하면 DB와 연결된 객체 리턴
														// -> 만약 실패하면 예외 발생 -> 예외처리
			// Connection conn = DriverManager.getConnection("DB주소", "계정명", "비밀번호");
				/* 1. DB주소 : 	- jdbc:mysql://ip주소:port번호/db명
				 				1. jdbc.oracle:thin:@localhost:1521/orcl
				 				2. jdbc:mysql://localhost:3306/orcl
				 
				 */
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web", "root", "1234");
			System.out.println("안내) 연동 성공 " + conn);
		}
		//--------------------- 만약 try{}에서 예외가 발생했으면 실행되는 catch{} 코드
		catch(Exception e) {
			System.out.println("안내) 연동 실패 " + e);
		} 
	}
}

/*
	예외처리 : 
		- Exception 클래스
		- 예외[오류] 발생했을 때 흐름 제어 [ *만약에 오류 발생했을때 다른 코드로 흐름 제어 ]
		- try{} catch{}
			try{ 예외[오류]가 발생할 것 같은 코드}
			catch(예외클래스명 객체변수명) { 예외가 발생했을때 실행할 코드}
			
			* try{} 안에서 예외가 발생하는 순간 
		- 예외[오류]가 발생할 것 같은 코드
			- 일반예외 : 컴파일 과정에서 발생하는 예외 [ - 컴파일 체크하기 때문에 미리 처리 가능 ] 
				
*/