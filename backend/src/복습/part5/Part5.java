package 복습.part5;

import java.util.Scanner;

public class Part5 {

	public static void main(String[] args) {
		
		Member[] memberList = new Member[100];
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------- 회원 시스템 ---------");
			System.out.print("1.회원가입 2.로그인\t선택> ");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("전화번호 : ");
				String phone = sc.next();
				System.out.print("나이 : ");
				int age = sc.nextInt();
				
				Member m = new Member(id, pw, name, phone, age);
				
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = m;
						break;
					}
				}
			}
			else if(ch == 2) {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				int login = 0;
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] != null) {
						if(memberList[i].id.equals(id) && 
								memberList[i].pw.equals(pw)) {
							System.out.println("안내) 로그인성공");
							login = 1;
						}
					}
				}
				if(login == 0) System.out.println("안내) 로그인 실패");
				login = 0;
			}
		}
	}
	
}
