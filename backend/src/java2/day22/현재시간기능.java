package java2.day22;

import java.time.LocalTime;

public class 현재시간기능 implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			// LocalTime.now() : 현재시간 반환 함수
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	

}
