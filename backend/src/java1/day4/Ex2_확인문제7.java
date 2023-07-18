package java1.day4;

import java.util.Scanner;

public class Ex2_확인문제7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = 0; int num2;
		boolean t = true;
		while(t) {
			System.out.println("------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1: System.out.print("예금액>");
				num2 = sc.nextInt();
				money += num2; break;
				case 2: System.out.print("출금액>");
				num2 = sc.nextInt();
				money -= num2; break;
				case 3: System.out.println("잔고 : " + money); break;
				case 4: System.err.println("\n프로그램 종료"); t = false; break;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주시길 바랍니다.");
			}
		}
	}

}
