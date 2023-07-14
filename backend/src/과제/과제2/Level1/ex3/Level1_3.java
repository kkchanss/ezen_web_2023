package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		System.out.print("input boolean : ");
		boolean bo = scanner.nextBoolean();
		System.out.print("input byte : ");
		byte b = scanner.nextByte();
		System.out.print("input char : ");
		String ss = scanner.next();
		char ch = ss.charAt(0);
		System.out.print("input short : ");
		short s = scanner.nextShort();
		System.out.print("input int : ");
		int i = scanner.nextInt();
		System.out.print("input long : ");
		long l = scanner.nextLong();
		System.out.print("input float : ");
		float f = scanner.nextFloat();
		System.out.print("input double : ");
		double d = scanner.nextDouble();
		
		System.out.println("output boolean : " + bo);
		System.out.println("output byte : " + b);
		System.out.println("output char : " + ch);
		System.out.println("output short : " + s);
		System.out.println("output int : " + i);
		System.out.println("output long : " + l);
		System.out.println("output float : " + f);
		System.out.println("output double : " + d);
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
