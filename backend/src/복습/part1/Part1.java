package 복습.part1;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
	    Scanner sc = new Scanner(System.in);
	    while(true) {
	    	System.out.println("1.콜라 2.사이다 3.환타 4.결제");
	    	System.out.print(">> 선택 : ");
	    	int num = sc.nextInt();
	    	
	    	if(num == 1) {
	    		if(콜라재고 > 0) {
	    			콜라재고--; 콜라바구니++;
	    			System.out.println("콜라가 담겼습니다.");
	    		}else {
	    			System.out.println("콜라 재고가 없습니다.");
	    		}
	    	}
	    	else if(num == 2) {
	    		if(사이다재고 > 0) {
	    			사이다재고--; 사이다바구니++;
	    			System.out.println("사이다가 담겼습니다.");
	    		}else {
	    			System.out.println("사이다 재고가 없습니다.");
	    		}
	    	}
	    	else if(num == 3) {
	    		if(환타재고 > 0) {
	    			환타재고--; 환타바구니++;
	    			System.out.println("환타가 담겼습니다.");
	    		}else {
	    			System.out.println("환타 재고가 없습니다.");
	    		}
	    	}
	    	else if(num == 4) {
	    		System.out.println("------------------------");
	    		System.out.println("제품명\t수량\t가격");
	    		int mon = 콜라바구니*콜라가격+사이다바구니*사이다가격+환타바구니*환타가격;
	    		if(콜라바구니 > 0) {
	    			System.out.println("콜라\t" + 콜라바구니 + "\t" + 콜라바구니*콜라가격);
	    		}
	    		if(사이다바구니 > 0) {
	    			System.out.println("사이다\t" + 사이다바구니 + "\t" + 사이다바구니*사이다가격);
	    		}
	    		if(환타바구니 > 0) {
	    			System.out.println("환타\t" + 환타바구니 + "\t" + 환타바구니*환타가격);
	    		}
	    		System.out.println("총가격 : " + mon);
	    		System.out.println("1.결제 2.취소");
	    		int num2 = sc.nextInt();
	    		if(num2 == 1) {
	    			System.out.println("금액 입력 : ");
	    			int money = sc.nextInt();
	    			if(money < mon) {
	    				System.out.println("금액이 부족합니다. 결제가 취소됩니다.");
	    				콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
	    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
	    			}
	    			else {
	    				System.out.println("결제가 완료되었습니다. 남은 금액 : " + (money-mon));
	    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
	    			}
	    		}
	    		else if(num2 == 2) {
	    			System.out.println("취소합니다.");
	    			콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
    				콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
	    		}
	    	}
	    }
	}

}
