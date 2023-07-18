package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		int set1 = 0, set2 = 0, set3 = 0, set4 = 0, set5 = 0, set6 = 0;
		while(true) {
			System.out.println("1. 예약하기 2. 예약취소 3. 예약현황");
			System.out.print(">> 선택 :");
			int num = scanner.nextInt();
			if(num==1) {
				System.out.println("예약할 좌석 선택 : ");
				int num2 = scanner.nextInt();
				if(num2 == 1) {
					if(set1 == 0 ) {
						System.out.println("예약성공"); set1 = 1;
					}else System.out.println("예약실패");
				} 
				else if(num2 == 2) {
					if(set2 == 0 ) {
						System.out.println("예약성공"); set2 = 1;
					}else System.out.println("예약실패");
				}
				else if(num2 == 3) {
					if(set3 == 0 ) {
						System.out.println("예약성공"); set3 = 1;
					}else System.out.println("예약실패");
				}
				else if(num2 == 4) {
					if(set4 == 0 ) {
						System.out.println("예약성공"); set4 = 1;
					}else System.out.println("예약실패");
				}
				else if(num2 == 5) {
					if(set5 == 0 ) {
						System.out.println("예약성공"); set5 = 1;
					}else System.out.println("예약실패");
				}
				else if(num2 == 6) {
					if(set6 == 0 ) {
						System.out.println("예약성공"); set6 = 1;
					}else System.out.println("예약실패");
				}
				else {
					System.out.println("잘못 선택하셨습니다.");
				}
			}
			else if(num == 2) {
				System.out.println("예약 취소할 좌석 선택 : ");
				int num3 = scanner.nextInt();
				if(num3 == 1) {set1 = 0;} 
				else if(num3 == 2) {set2 = 0;}
				else if(num3 == 3) {set3 = 0;}
				else if(num3 == 4) {set4 = 0;}
				else if(num3 == 5) {set5 = 0;}
				else if(num3 == 6) {set6 = 0;}
				System.out.println("예약이 취소되었습니다.");
			}
			else if(num==3) {
				if(set1 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				if(set2 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				if(set3 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				System.out.println();
				if(set4 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				if(set5 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				if(set6 == 1) System.out.print("[ 예약 ] ");
				else System.out.print("[ ] ");
				System.out.println();
			}
		}
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
