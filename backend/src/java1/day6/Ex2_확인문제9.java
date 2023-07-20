package java1.day6;

import java.util.Scanner;

public class Ex2_확인문제9 {
	
	// [ p.199 ] 확인문제 9
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] scores = null;
		boolean wt = true;
		while(wt) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수맅스 | 4. 분석 | 5. 종료 ");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");
			
			int num = sc.nextInt();
			switch(num) {
				case 1: 
					System.out.print("학생수> ");
					int n = sc.nextInt();
					scores = new int[n];
					break;
				case 2:
					for(int i = 0; i < scores.length; i++) {
						System.out.print("scores[" + i + "] : ");
						int s = sc.nextInt();
						scores[i] = s;
					} 
					break;
				case 3:
					for(int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "] : " + scores[i]);
					} 
					break;
				case 4:
					int max = scores[0];
					for(int i = 1; i < scores.length; i++) {
						if(max < scores[i]) max = scores[i];
					}
					int sum = 0;
					for(int i = 0; i < scores.length; i++) {
						sum+=scores[i];
					}
					System.out.println("최고 점수: "+ max);
					System.out.println("평균 점수: " + sum/scores.length);
					break;
				case 5:
					System.out.println("프로그램 종료");
					wt = false;
			}
		}
		
	}
}
