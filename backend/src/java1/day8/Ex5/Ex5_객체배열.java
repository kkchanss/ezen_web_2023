package java1.day8.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_객체배열 {
	public static void main(String[] args) {
		
		Member memberList[] = new Member[100]; // member 객체 100개를 저장할 수 있는 배열
		
		while(true) {
			System.out.println("1. 회원가입 : ");
			Scanner sc = new Scanner(System.in); 
			int ch = sc.nextInt(); 
			
			if(ch == 1) { // 먄약 ch가 1이라면
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				System.out.print("이름 : "); String name = sc.next();
				// 1. 객체 선언 : 클래스명 객체변수명 = new 생성자명();
				Member m = new Member(); // 1. 객체 생성
				m.id = id; m.pw = pw; m.name = name;
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = m;
						break;
					}
				}
				// 2. 배열에 저장
			} // if end
		}
	}
}
