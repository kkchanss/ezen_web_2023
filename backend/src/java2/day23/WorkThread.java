package java2.day23;

public class WorkThread extends Thread {
	
	// 필드
	public boolean work = true; // : 스레드 상태의 사용되는 스위치변수 [ on / off ]
	
	// 생성자
	public WorkThread(String name) {
		super.setName(name); // 스레드의 이름 변경
		// Thread.currentThread().setName()
	}
	// 메소드
	@Override
	public void run() {
		while(true) {	
			if(work) {				// super.getName() : 
				System.out.println(super.getName());
			}else {
				Thread.yield(); // 현재스레드의 양보 
			}
		} // 해당 스레드는 무한루프 [ 절대 종료되지 않는 메소드 ]
	}
}
