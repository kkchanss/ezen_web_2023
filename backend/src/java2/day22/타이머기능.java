package java2.day22;

public class 타이머기능 implements Runnable{
	@Override
	public void run() {
		int second = 0;
		while(true) {
			try { Thread.sleep(1000); } // 1초 일시정지
			catch(Exception e) { System.out.println(e);}
			second++;
		}
		
	}
}
