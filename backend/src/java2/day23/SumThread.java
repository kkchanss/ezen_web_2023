package java2.day23;

/*
	멀티스레드 구현하는 방법 
		1. Thread 클래스로부터 extends 
		2. *Runnable 인터페이스로부터 implements
			* run메소드 재정의
		- 상태 
			1. new 이용한 스레드 객체 생성 [ 스레드 생성 ]
			2. start() 메소드 이용한 run() 작업코드 실행 
				- start() 한다고 해서 바로 실행x
				
				실행대기(Runnable) : 실행 대기표 받고 기다리는 중 ( 운영체제가 하드웨어[CPU]를 사용할 수 있는 권한 올때까지 ) = cpu스케줄링 
				
					반복
				실행(Running) : 해당 스레드의 순서가 되면 CPU사용할 수 있는 권환 [ 명령어 실행 ]
				
				일시정지 : 스레드가 실행대디가 아닌 일시 정지한 상태.
				
				종료(Terminated) : 스레드 종료
		- 
 */

public class SumThread extends Thread{
	// 필드 
	private long sum;
	
	// 메소드
	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		this.sum = sum;
	}
	// !! 직업스레드가 실행할 직업코드 재정의
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) { // 1부터 100까지 누적합계
			sum+=i;
		}
	}
}
