package java2.day22;

public class 작업스레드1 implements Runnable{
	
	@Override
	public void run() {
		try {
			int count = 1;
			while(true) {
				System.out.println(Thread.currentThread().getName() + "[작업1 Thread] output" + count);
				Thread.sleep(5000); // 1초간 일시정지 [ 예외처리 필수 ] 
				count++;
			}
		}catch(Exception e) {System.out.println(e);}
		
	}
}
