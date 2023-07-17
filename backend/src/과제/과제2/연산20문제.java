package 과제.과제2;

import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//------ 문제1 여기에 풀이-------//
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		//------ 문제2 여기에 풀이-------//
		System.out.println("작성자 : ");
		String name = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		System.out.println("날짜 : ");
		String date = sc.next();
		
		System.out.println("-----------------방문록-----------------");
		System.out.println("| 순번  | 작성자	| 	내용 	| 날짜      |");
		System.out.println("|  1   | " + name + "	| 	" + content + "	| " + date + "  |");
		
		//------ 문제3 여기에 풀이-------//
		System.out.println("기본급 : ");
		int basePay = sc.nextInt();
		System.out.println("수당 : ");
		int extraPay = sc.nextInt();
		int realPay = basePay+extraPay-(basePay/10);
		System.out.println("실수령액 : " + realPay);
		//------ 문제4 여기에 풀이-------//
		System.out.println("금액 입력 : ");
		int money = sc.nextInt();
		System.out.println("십만원 : " + money/100000 + "장");
		System.out.println("만원 : " + money/10000%10 + "장");
		System.out.println("천원 : " + money/1000%10 + "장");
		System.out.println("백원 : " + money/100%10 + "개");
		//------ 문제5 여기에 풀이-------//
		System.out.println("문제5 정수 입력 : ");
		int num5 = sc.nextInt();
		String num5_s = num5 % 7 == 0 ? "O" : "X";
		System.out.println(num5_s);
		//------ 문제6 여기에 풀이-------//
		System.out.println("문제6 정수 입력 : ");
		int num6 = sc.nextInt();
		String num6_s = num6 % 2 != 0 ? "O" : "X";
		System.out.println(num6_s);
		//------ 문제7 여기에 풀이-------//
		System.out.println("문제7 정수 입력 : ");
		int num7 = sc.nextInt();
		String num7_s = (num7 % 7 == 0 && num7 % 2 == 0) ? "O" : "X";
		System.out.println(num7_s);
		
		//------ 문제8 여기에 풀이-------//
		System.out.println("문제8 정수 입력 : ");
		int num8 = sc.nextInt();
		String num8_s = (num8 % 7 == 0 || num8 % 2 != 0) ? "O" : "X";
		System.out.println(num8_s);
		
		//------ 문제9 여기에 풀이-------//
		System.out.println("문제9 첫번째 정수 입력 : ");
		int num9_1 = sc.nextInt();
		System.out.println("문제9 두번째 정수 입력 : ");
		int num9_2 = sc.nextInt();
		
		int num9_s = (num9_1 > num9_2) ? num9_1 : num9_2;
		System.out.println(num9_s);
	
		//------ 문제10 여기에 풀이-------//
		System.out.println("문제10 반지름 입력 : ");
		int b = sc.nextInt();
		System.out.println("원 넓이 : " + b*b*3.14);
		
		//------ 문제11 여기에 풀이-------//
		System.out.println("문제11 첫번째 실수 입력 : ");
		double d1 = sc.nextDouble();
		System.out.println("문제11 두번째 실수 입력 : ");
		double d2 = sc.nextDouble();
		
		System.out.println("앞실수의 값은 뒤의 값의 " + (d1/d2)*100 + "%이다.");
		
		//------ 문제12 여기에 풀이-------//
		System.out.println("문제12 윗변 길이 입력 : ");
		int topSide = sc.nextInt();
		System.out.println("문제12 밑변 길이 입력 : ");
		int underSide = sc.nextInt();
		System.out.println("문제12 높이 입력 : ");
		int height = sc.nextInt();
		System.out.println("사다리꼴 넓이 : " + (topSide + underSide)*height/2);
		
		//------ 문제13 여기에 풀이-------//
		System.out.println("문제13 키 입력 : ");
		int tall = sc.nextInt();
		System.out.println("표준체중 : " + (tall-100) * 0.9);
		
		//------ 문제14 여기에 풀이-------//
		System.out.println("문제14 키 입력 : ");
		int tall14 = sc.nextInt();
		System.out.println("문제14 몸무게 입력 : ");
		int weight = sc.nextInt();
		int tallhap = tall14/100;
		System.out.println("BMI : " + (tallhap*tallhap)/weight);
	
		//------ 문제15 여기에 풀이-------//
		System.out.println("문제15 inch 입력 : ");
		int inch = sc.nextInt();
		System.out.println(inch + "inch -> " + inch*2.54 + "cm");
		
		//------ 문제16 여기에 풀이-------1//
		System.out.println("문제16 중간고사 점수 : ");
		double score1 = sc.nextDouble();
		System.out.println("문제16 기말고사 점수 : ");
		double score2 = sc.nextDouble();
		System.out.println("문제16 수행평가 점수 : ");
		double score3 = sc.nextDouble();
		System.out.printf("총합 : %.2f \n", (score1*0.3)+(score2*0.3)+(score3*0.4));
		//------ 문제17 여기에 풀이-------//
		/*
		 	!순서!
		 	1. x = 10; 
		 	2. --x; -> x = 9
		 	3. y = x + 5 + x; -> y = 23, x = 9
		 	4. x--; -> x = 8
		 	==> y : 23, x = 8
		 */
		//------ 문제18 여기에 풀이-------//
		System.out.println("문제18 나이 입력 : ");
		int age = sc.nextInt();
		String age_s = age>=40 ? "중년" : age>=20 ? "성인" : age>=10 ? "학생" : "";
		System.out.println(age_s);
		
		//------ 문제19 여기에 풀이-------//
		System.out.println("문제19 국어 점수 입력 : ");
		double language = sc.nextDouble();
		System.out.println("문제19 영어 점수 입력 : ");
		double english = sc.nextDouble();
		System.out.println("문제19 수학 점수 입력 : ");
		double math = sc.nextDouble();
		int sum = (int) (language+english+math);
		double avg = (language+english+math)/3;
		System.out.printf("총점 : %d, 평균 : %.2f \n", sum, avg);

		//------ 문제20 여기에 풀이-------//
		System.out.print("문제20 아이디 입력 : ");
		String id = sc.next();
		System.out.print("문제20 비번 입력 : ");
		String pw = sc.next();
		
		String result20 = (id.equals("admin") && pw.equals("1234")) ? "로그인 성공" : "로그인 실패";
		System.out.println(result20);
		
		//------ 문제21 여기에 풀이-------//
		System.out.println("문제21 정수1 입력 : ");
		int num21_1 = sc.nextInt();
		System.out.println("문제21 정수2 입력 : ");
		int num21_2 = sc.nextInt();
		System.out.println("문제21 정수3 입력 : ");
		int num21_3 = sc.nextInt();
		
		int max = num21_1;
		max = max < num21_2 ? num21_2 : max;
		max = max < num21_3 ? num21_3 : max;
		System.out.println("가장 큰 수 : " + max);
		
		
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
