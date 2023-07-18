package 과제.과제4;

import java.util.Scanner;

public class 과제4_3_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
		
		int 콜라바구니 = 0 ; 	int 환타바구니 = 0 ; 	int 사이다바구니 = 0;
		
		int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			switch(ch) {
				case 1: 
					if(콜라재고>0) {
						콜라바구니++; 콜라재고--;
						System.out.println("콜라가 장바구니에 담겼습니다.");
					}else {
						System.out.println("콜라 재고 부족");
					} break;
				case 2: 
					if(환타재고>0) {
						환타바구니++; 환타재고--;
						System.out.println("환타가 장바구니에 담겼습니다.");
					}else {
						System.out.println("환타 재고 부족");
					} break;
				case 3:
					if(사이다재고>0) {
						사이다바구니++; 사이다재고--;
						System.out.println("사이다가 장바구니에 담겼습니다.");
					}else {
						System.out.println("사이다 재고 부족");
					} break;
				case 4:
					System.out.println("----------------------------------");
					System.out.println("제품명\t수량\t가격");
					if(콜라바구니>0) System.out.printf("콜라\t%d\t%d\n", 콜라바구니, 콜라바구니*콜라가격 );
					if(환타바구니>0) System.out.printf("환타\t%d\t%d\n", 환타바구니, 환타바구니*환타가격 );
					if(사이다바구니>0) System.out.printf("사이다\t%d\t%d\n", 사이다바구니, 사이다바구니*사이다가격 );
					int 총가격 = 콜라바구니*콜라가격+사이다바구니*사이다가격+환타바구니*환타가격;
					System.out.println("총가격 : " + 총가격);
					System.out.println("1. 결제 2. 취소");
					int num = scanner.nextInt();
					if(num==1) {
						
						System.out.print("금액 입력 : ");
						int money = scanner.nextInt();
						if(총가격 > money) {
							System.out.println("잔액이 부족합니다. 장바구니를 초기화합니다.");
							콜라재고+=콜라바구니; 콜라바구니=0;
							사이다재고+=사이다바구니; 사이다바구니=0;
							환타재고+=환타바구니; 환타바구니=0;
						}
						else {
							System.out.println("남은 잔액 : " + (money-총가격));
							콜라바구니=0;
							사이다바구니=0;
							환타바구니=0;
						}
					
					}
					else if(num==2) {
						System.out.println("장바구니를 초기화합니다.");
						콜라재고+=콜라바구니; 콜라바구니=0;
						사이다재고+=사이다바구니; 사이다바구니=0;
						환타재고+=환타바구니; 환타바구니=0;
					}
			}
			
			/* ----------- */
			
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격
			int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		2. 제품 초기 재고
			콜라 10개	, 사이다 10개 , 환타 10개      * 판매시 재고 차감되고 다시 채우기 안됩니다.
			int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
			
		3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







