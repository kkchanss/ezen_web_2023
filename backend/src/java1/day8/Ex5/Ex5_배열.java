package java1.day8.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_배열 {
	public static void main(String[] args) {
		
		String[] memberList = new String[100]; // 100개 문자열 저장할 수 있는 배열 선언
		System.out.println(Arrays.toString(memberList));
		
		while(true) { // 무한루프
			// 1. 무한 출력
			System.out.println("1. 회원가입 : ");
			// 2. 무한 입력
				// 1. scanner 객체 : Scanner 변수명 = new Scanner(System.in);
			Scanner sc = new Scanner(System.in); // 1. scanner 객체 : Scanner 객체변수명 = new Scanner
			int ch = sc.nextInt(); // 2. 객체 통한 메소드 호출
			
			if(ch == 1) { // 먄약 ch가 1이라면
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				// 1. 하나의 문자열로 합치기
				String member = id+","+pw;
				// 2. 배열내 비어 있는 인덱스 찾아서 대입 [ p.172 ]
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
				}
			}
		}
	}
}
