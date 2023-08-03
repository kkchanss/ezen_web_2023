package 복습.part6;

import java.util.Scanner;

public class Part6 {

	public static void main(String[] args) {
		Member[] memberList = new Member[100];
		Scanner sc = new Scanner(System.in);
		int login = -1;
		while(true) {
			System.out.println("------- 회원 시스템 --------");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 선택> ");
			int ch = sc.nextInt();
			
			if(ch == 1) {
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				System.out.print("이름 : "); String name = sc.next();
				System.out.print("전화번호 : "); String phone = sc.next();
				System.out.print("나이 : "); int age = sc.nextInt();
				
				Member m = new Member(id, pw, name, phone, age);
				
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = m;
						System.out.println("안내)회원가입 성공");
						break;
					}
				}
			}
			else if(ch==2) {
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] != null) {
						if(memberList[i].id.equals(id) && memberList[i].pw.equals(pw)) {
							System.out.println("안내) 로그인 성공");
							login = i;
							break;
						}
					}
				}
				if(login == -1) System.out.println("안내) 로그인 실패 : 아이디 혹은 비밀번호가 일치 하지 않습니다.");
				login = -1;
			}
			else if(ch==3) {
				System.out.print("이름 : "); String name = sc.next();
				System.out.print("전화번호 : "); String phone = sc.next();
				
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] != null) {
						if(memberList[i].name.equals(name) && memberList[i].phone.equals(phone)) {
							System.out.println("안내) 회원님의 아이디 : " + memberList[i].id);
							login = i;
							break;
						}
					}
				}
				if(login == -1) System.out.println("안내) 이름 혹은 전화번호가 일치하는 아이디가 없습니다.");
				login = -1;
			}
			else if(ch==4) {
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("전화번호 : "); String phone = sc.next();
				
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] != null) {
						if(memberList[i].id.equals(id) && memberList[i].phone.equals(phone)) {
							System.out.println("안내) 회원님의 비밀번호 : " + memberList[i].pw);
							login = i;
							break;
						}
					}
				}
				if(login == -1) System.out.println("안내) 아이디 혹은 전화번호가 일치하는 비밀번호가 없습니다.");
				login = -1;
			}
		}
	}

}
