package 복습.part2;

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		Scanner sc = new Scanner(System.in);
		
		int 콜라재고 = Integer.parseInt(재고관리.split("\n")[0].split(",")[0]);
		int 콜라바구니 = Integer.parseInt(재고관리.split("\n")[0].split(",")[1]);
		int 콜라가격 = Integer.parseInt(재고관리.split("\n")[0].split(",")[2]);
		
		int 환타재고 = Integer.parseInt(재고관리.split("\n")[1].split(",")[0]);
		int 환타바구니 = Integer.parseInt(재고관리.split("\n")[1].split(",")[1]);
		int 환타가격 = Integer.parseInt(재고관리.split("\n")[1].split(",")[2]);
		
		int 사이다재고 = Integer.parseInt(재고관리.split("\n")[2].split(",")[0]);
		int 사이다바구니 = Integer.parseInt(재고관리.split("\n")[2].split(",")[1]);
		int 사이다가격 = Integer.parseInt(재고관리.split("\n")[2].split(",")[2]);
		
		int 주문번호 = 1;
		while(true) {
			
			System.out.println("-------------------- 메뉴 -----------------------------");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : ");
			int num = sc.nextInt();
			
			if(num == 1) {
				if(콜라재고 > 0) {
					콜라재고--; 콜라바구니++;
					System.out.println("안내) 콜라 담겼습니다.");
				}
				else {
					System.out.println("안내) 콜라 재고가 없습니다. [ 관리자에게 문의 ]");
				}
			}
			else if(num == 2) {
				if(환타재고 > 0) {
					환타재고--; 환타바구니++;
					System.out.println("안내) 환타 담겼습니다.");
				}
				else {
					System.out.println("안내) 환타 재고가 없습니다. [ 관리자에게 문의 ]");
				}
			}
			else if(num == 3) {
				if(사이다재고 > 0) {
					사이다재고--; 사이다바구니++;
					System.out.println("안내) 사이다 담겼습니다.");
				}
				else {
					System.out.println("안내) 사이다 재고가 없습니다. [ 관리자에게 문의 ]");
				}
			}
			else if(num==4) {
				System.out.println("-------------------------");
				System.out.println("제품명\t수량\t가격");
				int sum = 콜라가격*콜라바구니+환타가격*환타바구니+사이다가격*사이다바구니;
				if(콜라바구니 > 0) {
					System.out.println("콜라\t" + 콜라바구니 + "\t" + 콜라가격*콜라바구니);
				}
				if(환타바구니 > 0) {
					System.out.println("환타\t" + 환타바구니 + "\t" + 환타가격*환타바구니);
				}
				if(사이다바구니 > 0) {
					System.out.println("사이다\t" + 사이다바구니 + "\t" + 사이다가격*사이다바구니);
				}
				System.out.println("총가격 : " + sum);
				System.out.println("-------------------------");
				System.out.println("1.결제 2.취소 : ");
				int num2 = sc.nextInt();
				if(num2 == 1) {
					System.out.print("안내 금액 투여 : ");
					int money = sc.nextInt();
					if(money >= sum) {
						System.out.println("잔액 : " + (money-sum));
						System.out.println("주문 번호 : " + 주문번호);
						주문번호++;
						콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
					}
					else {
						System.out.println("금액이 부족합니다. 결제가 취소됩니다.");
						콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
						콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
					}
				}else if(num2 == 2) {
					System.out.println("결제가 취소됩니다.");
					콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
					콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
				}
			}
		}
	}
}
