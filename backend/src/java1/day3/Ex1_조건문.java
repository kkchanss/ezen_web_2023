package java1.day3;

import java.util.Random;

public class Ex1_조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		// [ p.111 ]
		int score = 93;
		// 1.
		if( score >= 90 ) System.out.println("1합격");
		// 2.
		if( score >= 90 ) 
			System.out.println("2점수가 90보다 큽니다.");
			System.out.println("2등급은 A등급입니다.");
		
		if( score < 90 ) 
			System.out.println("2점수가 90보다 작습니다.");
			System.out.println("2등급은 B등급입니다.");
		
		// 3. [ p.113 ]
		if( score >= 90 ) {
			System.out.println("2점수가 90보다 작습니다.");
			System.out.println("2등급은 B등급입니다.");
		}else {
			System.out.println("3점수가 90보다 큽니다.");
			System.out.println("3등급은 A등급입니다.");
		}
		
		// 4. [ p.114 ]
		if(score >= 90) {
			System.out.println("4점수가 100~90입니다.");
			System.out.println("4등급은 A등급입니다.");
		}
		else if(score >= 80) {
			System.out.println("4점수가 80~89입니다.");
			System.out.println("4등급은 B등급입니다.");
		}
		else if(score >= 70) {
			System.out.println("4점수가 70~79입니다.");
			System.out.println("4등급은 C등급입니다.");
		}
		else {
			System.out.println("4점수가 70 미만입니다.");
			System.out.println("4등급은 D등급입니다.");
		}
		
		//------------------------------------------------
		
		if(score >= 90) {
			System.out.println("4점수가 100~90입니다.");
			System.out.println("4등급은 A등급입니다.");
		}
		if(score >= 80) {
			System.out.println("4점수가 80~89입니다.");
			System.out.println("4등급은 B등급입니다.");
		}
		if(score >= 70) {
			System.out.println("4점수가 70~79입니다.");
			System.out.println("4등급은 C등급입니다.");
		}
		if(score < 70) {
			System.out.println("4점수가 70 미만입니다.");
			System.out.println("4등급은 D등급입니다.");
		}
		
		// [ p.115 ] 난수생성 : Math.random()
		System.out.println(Math.random()); // 0.0 <= ~ < 1.0
		System.out.println(Math.random()*6); // 0.0 <= ~ < 6.0
		System.out.println((int)(Math.random()*6)); // 0 <= ~ < 6
		System.out.println((int)(Math.random()*6) + 1); // 1 <= ~ < 7
		// 정수 난수공식 : (int) (Math.random() * n) + s
			// s : 난수 시작번호		n : 난수 개수
		// 예시) 1~45
		System.out.println((int)(Math.random()*45)+1);
		// ----------------------------------------------------------
		// 난수 생성 클래스 : Random 클래스
			// 1. Random 객체 생성한다. // 2. 랜덤 값 호출
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(3));
		// random.nextInt(개수) + 시작번호
		System.out.println(random.nextInt(6) + 1); // 1~6
		System.out.println(random.nextInt(45) + 1); // 1~45
		// 예시) a-z
		System.out.println((char)(random.nextInt(26) + 97)); // 97 ~ 122
		
		// [ p.116 ] 주사위 예제
		int num = (int)(Math.random()*6) + 1; // 1 ~ 6
		int num2 = random.nextInt(6)+1;
		
		if(num == 1) System.out.println("1 나왔습니다.");
		else if(num == 2) System.out.println("2 나왔습니다.");
		else if(num == 3) System.out.println("3 나왔습니다.");
		else if(num == 4) System.out.println("4 나왔습니다.");
		else if(num == 5) System.out.println("5 나왔습니다.");
		else System.out.println("6 나왔습니다.");
		
		// [ p.117 ] if 중첩
		int score3 = (int)(Math.random() * 20) + 81; // 81~100 난수 생성
		
		String grade; // 등급 저장하는 변수
		
		if( score3 >= 90 ) { // 점수가 90점 이상이면	
			if( score3 >= 95 ) { grade = "A+"; } // [ 100~95 ] 이면서 95점 이상이면 A+ 대입
			else { grade = "A"; } // [ 94 ~ 90] 이면서 95점 미만이면 A 대입
		}
		
		// [ p.119 ] 주사위 예제 = switch
		
		switch(num) {
			case 1 : System.out.println("1 나왔습니다."); break;
			case 2 : System.out.println("2 나왔습니다."); break;
			case 3 : System.out.println("3 나왔습니다."); break;
			case 4 : System.out.println("4 나왔습니다."); break;
			case 5 : System.out.println("5 나왔습니다."); break;
			default : System.out.println("6 나왔습니다.");
		}
		
		// [ p.121 ] 
		char grade2 = 'B';
		
		switch(grade2) { // 값을 제어할 변수
			case 'A': System.out.println("A등급 우수회원");
			case 'a': break;
			case 'B': System.out.println("B등급 우수회원");
			case 'b': break;
			default: System.out.println("우수회원이 되기 위해 노력하거라.");
		}
	}		
}

/*
 	if : 조건에 따른 흐름 제어
 		형태
 			1. if(조건식) 실행문;
 			
 			2. if(조건식) { 실행문; 실행문; }
 				* 만약에 참/거짓의 실행문이 2개 이상일 경우 { } 묶음
 			
 			3. if(조건식) { 참일경우 실행문 }
 			   else{ 거짓일 경우 실행문 }
 			
 			4. 
 				if( 조건식1 ) { 참1일 경우 실행문 }
 				else if( 조건식2 ) { 참2일 경우 실행문 }
 				else if( 조건식3 ) { 참3일 경우 실행문 }
 				else{ 거짓일 경우 실행문 }
 					* [ 다수 조건에 하나의 실행문 처리 ]
 			
 			4.
 			 	if(조건식1) { 참1일 경우 실행문 }
 			 	if(조건식2) { 참2일 경우 실행문 }
 			 	if(조건식3) { 참3일 경우 실행문 }
 			 	if(조건식4) { 참4일 경우 실행문 }
 			 		* [ 다수 조건에 다수 실행문 처리 ]
 			
 			5. 
 				if 중첩
 				if() {
 					if() {}
 				}
 				else {
 					if() {}
 				}
 	
 	switch( 변수 ) {
 		case 값1 : 
 		case 값2 : 
 		case 값3 : 
 		default :
 	}
 	
 	* if = 조건에 따른 true / false 실행
 	* switch = 변수 값에 따른 실행
 		- 경우의 수의 값이 정해져 있는 경우 / 범위 논리 x
 		- break; : switch {} 탈출 / 만약에 해당 case 실행 후 멈춤
*/
