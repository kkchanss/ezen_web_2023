package java2.day23;

public class Ex1_멀티스레드join {

	public static void main(String[] args) {
		// main 스레드가 main 함수 호출
		System.out.println("현재 스레드 : " + Thread.currentThread().getName());

		// 1. [main스레드] 작업 스레드객체 생성 [ main 외 추가적으로 작업스레드 생성 ]
		SumThread sumThread = new SumThread(); 
		// 2. [main스레드] 작업 스레드 실행 => 대기상태 => CPU스케줄링 =>
		sumThread.start();
		
		System.out.println("[join 하기전]1 ~ 100 합 : " + sumThread.getSum());
		
		try {
			sumThread.join();
		}catch(Exception e) {
			System.out.println("[join 했을때]1 ~ 100 합 : " + sumThread.getSum());
		}
	}

}
/*
 
	함수를 호출하는 방법 [ 내부 객체에서 ]
		
		1. 인스턴스 함수 [ static 아닌 함수 ]
			클래스명 객체명 = new 생성자();
			객체명.함수명(); 
			
		2. 정적 함수 [ static 함수 ]
			클래스명.함수명(); 
			
		3. 싱글톤 
			클래스명.getInstance().메소드명()
			
		4. main함수
			X -> 모든 자바 프로그램에서는 main스레드가 main함수 최초로 1번 호출
*/
