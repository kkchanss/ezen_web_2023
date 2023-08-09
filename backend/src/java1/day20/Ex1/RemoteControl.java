package java1.day20.Ex1;

public interface RemoteControl { // 인터페이스 선언
	// 인터페이스 : 두 장치(객체)를 연결하는 접속기
	// 구성멤버
		// 1. public 상수 필드 [ public static final ]
		int MAX_VOLUME = 10;
		public static final int MIN_VOLUME = 0;
		// 2. public 추상 메소드 [ public abstract ]
		void turnOn();
		public abstract void turnOff();
		void setVolume(int volume);
		// 3. public 디폴트 메소드
		default void setMute(boolean mute) {
			if(mute) { System.out.println("무음 처리합니다"); setVolume(MIN_VOLUME);}
			else { System.out.println("무음 해제합니다.");}
		}
		public default void getMute() {System.out.println();}
		// 4. public 정적 메소드
		static void changeBattery() {System.out.println("리모콘 건전지를 교체합니다.");}
		public static void chackBattery() {System.out.println("건전지 확인합니다.");}
		// 5. private 메소드
		
		// 6. private 정적 메소드
}

/*
 인스턴스멤버 : 객체 생성시 메모리 할당되는 필드, 메소드 [ static없는 ]
 정적멤버 : 객체가 없어도 메모리 우선할당량인 필드, 메소드 [ static있는 ]
 	- 정적멤버는 인스턴스멤버에 접근할 수 없다. [ p.249 ]
 
*/