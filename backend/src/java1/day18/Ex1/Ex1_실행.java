package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 1. 인터페이스타입의 변수 선언
		RemoteControl rc;
			// * 인터페이스 안으로 객체 생성 불가능 [ 객체 생성하려면 추상메소드를 구현 후 가능 ]
		// 2. 인터페이스 변수에 텔리비전 객체 대입 [ 주소 대입 ]
		rc = new Television();
		// 3. 인터페이스로 메소드 실행
		rc.turnOn();
		// 4. 리모컨을 오디오로 변경 
		rc = new Audio();
		
		rc.turnOn();
		
		// 5. 리모콘의 상수필드 호출
		System.out.println("리모콘의 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘의 최대 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		/*

			인터페이스        vs         	상속
			implements             		extends
			구현하다                		연장하다
			여러개구현                  	1개 상속
			추상메소드                    	메소드
			*버전[다양한메소드제공]
			목적 : 메소드 통합  		        빠른 개발 / 설계 모듈화[쪼개서]
			게임패드/키보드          	    직급별 사원


		*/
	}
}
