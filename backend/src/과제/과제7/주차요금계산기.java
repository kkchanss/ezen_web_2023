package 과제.과제7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class 주차요금계산기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("1. 입차 | 2. 출차 | 3. 입출차현황 | 4. 매출");
			System.out.println("------------------------------------------------");
			int num = sc.nextInt();
			
			// 주차장파일
			String carParkfilePath = "./src/과제/과제7/주차장파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(carParkfilePath, true);
			FileInputStream fileInputStream = new FileInputStream(carParkfilePath);
			File file = new File(carParkfilePath);
			
			
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileinfo = new String(inByteArray);
			String[] carParkArray = fileinfo.split("\n");
			
			// 입차
			if(num == 1) {
				for(int i = 1; i <= 15; i++) {
					
					if(fileinfo.indexOf(i + "번") == -1) { // 해당 자리에 주차한 사람이 없다면
						System.out.print("[" + i + "]"); // 번호 입력
					}
					else {
						System.out.print("[주차중]"); // 이미 주차한 사람이 있다면 [주차중]으로 바꿔주기
					}
					if(i % 5 == 0) System.out.println(); // 5자리 마다 줄바꿈
				}
				
				System.out.print("자리 선택 : ");
				int seat = sc.nextInt();
				int t = 0;
				if(fileinfo.indexOf(seat + "번") != -1) { // 이미 주차되어있는 자리라면
					System.out.println("이미 주차되어 있는 자리입니다.");
				}
				else {
					
					System.out.print("차량 번호 입력 : ");
					String carNum = sc.next();
					
					// 현재 시간
			        LocalTime now = LocalTime.now();
			        // 시 구하기
			        int hour = now.getHour();
			      
			        // 입차차량 개수 늘려주기
			        String outStr2 = "";
					int inCar = Integer.parseInt(carParkArray[0].split(",")[0]);
					inCar++;
					int outCar = Integer.parseInt(carParkArray[0].split(",")[1]);
					carParkArray[0] = inCar + "," + outCar;
					for(int j = 0 ; j < carParkArray.length; j++) {
						outStr2 += carParkArray[j] + "\n";
					}
					FileOutputStream fileOutputStream2 = new FileOutputStream(carParkfilePath); // 이어쓰기x
					fileOutputStream2.write(outStr2.getBytes());
					 
					// 주차한 차 저장
					String outStr = seat + "번," + carNum + "," + hour + "\n";
					fileOutputStream.write(outStr.getBytes());
					
					
					
					System.out.println("입차가 완료되었습니다.");
					
				}

			}
			
			// 출차
			else if(num == 2) {
				System.out.print("차량 번호 입력 : ");
				String carNum = sc.next();
				// 현재 시간
		        LocalTime now = LocalTime.now();
		 
		        // 시 구하기
		        int hour = now.getHour();
		        
				boolean exist = false; // 차량을 찾았는지 
				
				for(int i = 2; i < carParkArray.length; i++) {
					if(carParkArray[i].split(",")[1].equals(carNum)) { // 차량번호와 일치한다면
						exist = true; // 차량을 찾았다고 표시
						
						int mon = (hour-Integer.parseInt(carParkArray[i].split(",")[2]))*10000+5000; // 내야 할 금액
						System.out.println("내야 할 금액 : " + mon);
						System.out.print("금액 입력 : ");
						int money = sc.nextInt();
						if(money >= mon) { 
							// 입차 하나 빼기
							System.out.println(carParkArray[0].split(",")[1]);
							
							// 입출차 관리
							int inCar = Integer.parseInt(carParkArray[0].split(",")[0]);
							inCar--;
							int outCar = Integer.parseInt(carParkArray[0].split(",")[1]);
							outCar++;
							int sumMon = Integer.parseInt(carParkArray[1])  + mon;
							carParkArray[0] = inCar + "," + outCar;
							carParkArray[1] = Integer.toString(sumMon);
							
							System.out.println("출차가 완료되었습니다\n거스름 돈 : " + (money-mon));
							carParkArray[i] = "출차,-," + carParkArray[i].split(",")[2]; // 출차 상태로 변경
							String outStr = "";
							for(int j = 0 ; j < carParkArray.length; j++) {
								outStr += carParkArray[j] + "\n";
							}
							// 5. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트로 변환후 내보내기
							FileOutputStream fileOutputStream2 = new FileOutputStream(carParkfilePath); // 이어쓰기x
							fileOutputStream2.write(outStr.getBytes());
						}else {
							System.out.println("금액이 부족해 출차가 정상적으로 처리되지 않았습니다.");
						}
						break;
					}
				}
				if(!exist) System.out.println("일치하는 차량 번호가 없습니다."); // 일치하는 차량번호가 없다면
				exist = false;
			}
			
			// 입출차현황
			else if(num == 3) {
				String inCar = carParkArray[0].split(",")[0];
				String outCar = carParkArray[0].split(",")[1];
				System.out.println("입차 현황 : " + inCar + " | 출차 현황 : " + outCar);
			}
			
			// 매출
			else if(num == 4) {
				String sumMon = carParkArray[1];
				System.out.println("총 매출 : " + sumMon);
			}
		}
	}

}

/*
	
	주제 : 주차요금 정산기 [ 입차 , 출차(요금지출) , 입출차현황 , 매출(입차시간과 출차시간 기준으로 요금산정) ] 등등 
      - 날짜/시간 함수를 이용한 요금 계산 
   - 입차시 : 차량 번호만 입력받습니다.   - 출차시 : 차량 번호 입력받고 일차할 경우 금액을 입력받습니다.
   - 상단 기본 기능 모두 구현 후 기능 추가 
      - 주차 좌석배치
      - 매출 세분화 및 그래프화
      - 관리자 기능 

   * 센서 및 터치 기능은 입력 기능으로 대체
   * 주제에 맞춰서 C R U D [ 추가 호출 수정 삭제 ] 기능을 1개 이상씩 필수로 한다.
   * 모든 정보를 영구저장 할 수 있도록 파일처리 합니다.
*/