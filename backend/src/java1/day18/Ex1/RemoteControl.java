package java1.day18.Ex1;

/*
	JVM 실행 메모리 
	
	1. 메소드영역		2. 스택영역		3. 힙영역
	 - 클래스정보 		 - 함수{}내 변수들	 - 객체(인스턴스)
	 - 메소드
	 - static정적
	 - 인터페이스정보
	 
	 class 사람{						사람 유재석 = 102번지		유재석객체(나이=30)		유재석.밥먹기() => 30
	 	int 나이;
	 	void 밥먹기() {
	 		print(this.나이)
	 	}
	 }
 */

// 인터페이스 선언 = interface
public interface RemoteControl {
	// 1. 상수 [ public static final ] 필드 : 프로그램내 수정 불가능한 데이터
		// int MAX_VOLUME;
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
		// 2. 추상메소드 : 선언만 하고 { } 구현은 안하는 함수
			// [ public abstract ] 리턴타입 메소드명(매개변수1, 매개변수2);
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
}
