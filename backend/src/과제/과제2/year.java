package 과제.과제2;

import java.util.Scanner;

public class year {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// 1조 문제
		System.out.print("년도 입력 : ");
		int year = sc.nextInt();
		
		int result = (year%4 == 0 && year%100 != 0 || year%400 == 0) ? 1 : 0;
		
		System.out.println(result);
	}

}
