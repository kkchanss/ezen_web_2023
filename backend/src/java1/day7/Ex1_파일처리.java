package java1.day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {

	public static void main(String[] args) throws IOException {
		
		// 스택영역 : 함수는 호출시 메모리할당 종류시 메모리초기화 * 지역변수
		// 힙영역 : 객체/배열은 참조하는 스택이 없으면 자동으로 메모리가 초기화
			// ---> RAM 기억장치 : 현재 처리된 멸령어 저장 --> 전기x저장x 	-> 휘발성 [ 타서 날라감 ]
		// 영구저장
			// ---> c: , usb, cd 등등 : 명령어 영구 저장 --> 전기x저장o			-> 비휘발성
		
		// Ex1_파일처리.java
			// 저장위치 : C : ~~~ 보조기억장치
			// 실행[ctrl+f11] : 실행중에 필요한 메모리 ( 변수, 객체, 배열 등 ) -> 주기억장치
			// 실행중인 메모리를 다음에 또 사용할려면 주기억장치 메모리를 보조기억장치 저장 / 불러오기
			
			// String a = scanner.next();	------------> c : 저장		[ 파일처리, 데이터베이스 ]
			// 컴퓨터 종료 후 다음날
			// String b = 					<------------ c : 불러오기 	[ 파일처리, 데이터베이스 ]
		/*
		// 파일처리 라이브러리 ( 미리 만들어진 클래스/메소드 )
			// * 스트림 : 자바 외부와 통신할 때 사용 통로
				// * 통신하다가 갑자기 오류 발생할수도 있음 [* 필수 : 미리 예외처리/오류처리 ]
			// 1. FileOutputStream : 파일 내보내기/저장 관련된 메소드 제공하는 클래스
				// new FileOutputStream("파일경로"); : 해당파일과 연동/연결
					만약에 파일경로에 해당 파일이 존재하지 않으면 해당 파일 생성, 새로 쓰기
				// new FileOutputStream("파일경로", true); : 해당파일과 연동/연결
					만약에 파일경로에 해당 파일이 존재하지 않으면 실행 불가, 이어 쓰기
				// 파일경로 :
					// 상대경로 : 프로젝트명생략 : ./src/패키지명/파일명
			// 2. 제공하는 함수/메소드
				1. .write(바이트배열) : 해당 객체와 연결된 파일의 바이트 내보내기 	1바이트=영문	바이트배열 = 여러글자
				2. .read(바이트배열) : 해당 객체와 연결된 파일의 바이트 읽어오기
			
			1. 문자열.getBytes() : 해당 문자열을 바이트배열 반환
			2. new String(바이트배열); : 해당 바이트배열을 문자열로 반환
			
			// 3. File	: 파일에 정보/제어 관련 메소드 제공
				메소드
					1. .exists() : 파일 경로에 파일 존재여부 true / false
					2. .getPath()
					3. 경로
		*/
		
		Scanner sc = new Scanner(System.in);		// 입력객체 = 입력한 값이 바이트로 들어옴
		String instr = sc.next(); // 객체 입력받은 값 바이트열을 문자열로 반환
		
		// 1. 파일처리 [ 저장 ]
			// 1. 파일출력스트림 객체 선언 [ 파일경로 ]
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day7/Ex1_테스트.txt", true);
			// 2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용 [ 바이트 단위 ]
				// 1. 문자열을 바이트배열로 변환 후
		byte[] instrArray = instr.getBytes();
				// 2. 바이트배열을 내보내기
		fileOutputStream.write(instrArray);
		
		// 2. 파일처리 [ 불러오기 ]
			// 1. 파일입력스트림 객체 선언 [ 파일경로 ]
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day7/Ex1_테스트.txt");
			// 2. 파일입력스트림 객체를 이용한 파일내용 읽어오기 [ 바이트 단위 ]
		byte[] intstrArray = new byte[100]; // 파일의 바이트만큼 배열 선언 [ * 정확한 파일의 용량 알 수 없어서 임의로 ]
		fileInputStream.read(intstrArray);
			// 3. 바이트배열을 문자열 변환
		String str = new String("intstrArray"); // 만약에 빈 바이트는 공백 채움
		System.out.println(str);
		
		// 3. 외부파일 불러오기 [ CSV 불러오기 ]
			// 1. 역대 로또 번호 [ CSV ]
		FileInputStream 복권파일 = new FileInputStream("./src/java1/day7/로또.csv");
			// 2. 해당파일의 용량 알기 [ 40,960 바이트 ]
		File file = new File("./src/java1/day7/로또.csv");
		System.out.println("해당 경로에 파일존재여부 : " + file.exists());
			// file.delete();
		System.out.println("해당 파일의 경로 : " + file.getPath());
		System.out.println("해당 파일의 용량(바이트) : " + file.length());
		byte[] 복권파일바이트배열 = new byte[(int)file.length()]; // 용량만큼 배열 선언
			// 3. 읽어오기
		복권파일.read(복권파일바이트배열);
			// 4. 바이트배열 --> 문자열 변환
		String 복권파일정보 = new String(복권파일바이트배열);
		System.out.println(복권파일정보);
		
		// 4. 외부파일 불러오기 [ CSV 불러오기 ]
		String path = "./src/java1/day7/전국관광지정보표준데이터.csv";
		FileInputStream 관광지파일 = new FileInputStream(path); // 1. 파일 입력 객체 생성
		File file2 = new File(path); // 2. 파일 정보 객체 생성 [ file.length() 메소드 사용하기 위해 ]
		byte[] 관광지파일바이트배열 = new byte[(int)file.length()]; // 3. 파일 용량만큼의 바이트배열 선언
		관광지파일.read(관광지파일바이트배열); // 4. 읽어온 바이트를 해당 배열에 저장
		// String 관광지파일정보 = new String(관광지파일바이트배열); // 5. 바이트배열 --> 문자열 변환 ( 사람은 바이트 못 읽음 )
		// String 관광지파일정보 = new String(관광지파일바이트배열, "UTF-8");
		String 관광지파일정보 = new String(관광지파일바이트배열, "EUC-KR");
		//System.out.println(관광지파일정보); // 한글 인코딩(번역) 방법 :     
		System.out.println(관광지파일정보.split("\n")[0]);
		System.out.println(관광지파일정보.split("\n"));
	}

}
