package java2.day21;

public class Ex1_예외처리 {

	// p.466
	public static void printLength(String data) {
		
		// p.467 : 예외처리
		try { // 예외가 발생할 것 같은 코드 [ 경험 의존, 테스트 ]
			int result = data.length(); // 1. ThisIsJava => String 객체의 주소값 // 2. null -> 객체의 주소값 없음
			System.out.println("문자수 : " + result);
		}catch(NullPointerException e) { // 예외 발생하면 이곳으로 이동하고 *예외 정보를 객체내 저장
			// NullPointerException : 처음에는 모르지만 . 실행한 결과(경험을 결과) NullPointerException 예외 발생했다는 경험을 했기 때문에
			System.out.println(e.getMessage()); // e 객체 : 예외 발생에 관련된 
		}finally {
			System.out.println("마무리 실행");
		}
	
	} 
	
	public static void main(String[] args) {
		
		// p.466 
		System.out.println("프로그램 시작");
		printLength("ThisIsJava");
		printLength(null); // 예외발생 : NullPointerException
		System.out.println("프로그램 종료");
		
		// p.468 : 일반 예외 [ - 실행 전부터 컴파일러가 예외 검사 하기 때문에 예외 필수!! ]
		try { // 예외가 발생할 것 같은 코드 + (일반예외) 예외 무조건 발생하는 코드
			Class.forName("java.lang.String"); // Class.forName : 클래스 찾기 // java.lang.String 
			// ClassNotFoundException : 만약에 클래스를 못 찾았을때 예외처리 미리
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}

/*
	에러 : 컴퓨터의 하드웨어 고장으로 인해 실행 오류가 발생 
	예외 : 에러 이외
		-1. 일반예외 : 컴파일러가 예외 처리 코드 여부를 검사하는 예외,
			- 외부입출력 관련 : 파일처리, JDBC(DAO), 네트워크, 입출력
			
		-2. 실행예외 : 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외를 말함.
			- 실행 도중에 오류가 발생하는 것 : - 개발자의 경험에 의존
			- 타입오류, 배열인덱스, NULL
*/