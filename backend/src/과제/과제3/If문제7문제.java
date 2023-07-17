package 과제.과제3;

import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		
		/* -------문제1----- */
		Scanner sc = new Scanner(System.in);
		System.out.print("1 정수1 입력 : ");
		int num1_1 = sc.nextInt();
		System.out.print("1 정수2 입력 : ");
		int num1_2 = sc.nextInt();
		if(num1_1 > num1_2) System.out.println(num1_1);
		else System.out.println(num1_2);
		/* -------문제2----- */
		System.out.print("2 정수1 입력 : ");
		int num2_1 = sc.nextInt();
		System.out.print("2 정수2 입력 : ");
		int num2_2 = sc.nextInt();
		System.out.print("2 정수3 입력 : ");
		int num2_3 = sc.nextInt();
		int max2 = num2_1;
		if(max2 < num2_2) max2 = num2_2;
		if(max2 < num2_3) max2 = num2_3;
		System.out.println(max2);
		/* -------문제3----- */
		System.out.print("3 정수1 입력 : ");
		int num3_1 = sc.nextInt();
		System.out.print("3 정수2 입력 : ");
		int num3_2 = sc.nextInt();
		System.out.print("3 정수3 입력 : ");
		int num3_3 = sc.nextInt();
		
		int max3 = num3_1;
		if(max3 < num3_2) max3 = num3_2;
		if(max3 < num3_3) max3 = num3_3;
		
		int min3 = num3_1;
		if(min3 > num3_2) min3 = num3_2;
		if(min3 > num3_3) min3 = num3_3;
		
		int mid3;
		if(num3_1 != min3 && num3_1 != max3) mid3 = num3_1;
		else if(num3_2 != min3 && num3_2 != max3) mid3 = num3_2;
		else mid3 = num3_3;
		System.out.println("오름차순 : " + min3 + ", " + mid3 + ", " + max3);
		System.out.println("오름차순 : " + max3 + ", " + mid3 + ", " + min3);
		
		/* -------문제4----- */
		System.out.print("4 점수 입력 : ");
		int score4 = sc.nextInt();
		if(score4 >= 90) System.out.println("합격");
		else System.out.println("불합격");
		
		/* -------문제5----- */
		System.out.print("5 점수 입력 : ");
		int score5 = sc.nextInt();
		switch(score5/10) {
			case 10: 
			case 9: System.out.println("A등급"); break;
			case 8: System.out.println("B등급"); break;
			case 7: System.out.println("C등급"); break;
			default: System.out.println("재시험");
		}
		/* -------문제6----- */
		System.out.print("6 국어 점수 : ");
		int kor = sc.nextInt();
		System.out.print("6 영어 점수 : ");
		int eng = sc.nextInt();
		System.out.print("6 수학 점수 : ");
		int mat = sc.nextInt();
		int sum = kor+eng+mat;
		int avg = sum/3;
		switch(avg/10) {
			case 10:
			case 9: 
				if(kor == 100) System.out.println("국어우수");
				if(eng == 100) System.out.println("영어우수");
				if(mat == 100) System.out.println("수학우수");
				break;
			case 8:
				if(kor == 100) System.out.println("국어장려");
				if(eng == 100) System.out.println("영어장려");
				if(mat == 100) System.out.println("수학장려");
				break;
			default:
				System.out.println("재시험");
		}
		/* -------문제7----- */
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		System.out.println("비밀번호 입력 : ");
		String pw = sc.next();
		if(id.equals("admin") && pw.equals("1234")) System.out.println("로그인 성공");
		else System.out.println("로그인 실패");
		
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
