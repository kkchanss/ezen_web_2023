package java2.day23;

public class Calculator {
	// 필드
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory1(int memory) { 
		// 동기화 메소드 : 해당 메소드를 여럿 스레드가 호출시 대기상태
		System.out.println(Thread.currentThread().getName() + "비동기화 구역");
		this.memory = memory; // 1. 매개변수로 들어온 값을 필드에 저장 [ setter ]
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e);
		} // 2. 현재 스레드를 2초간 일시정지 
	
		// 3. 2초 후 메모리 필드 확인
		System.out.println(Thread.currentThread().getName() + "요청한 2초 후 저장된 메모리 : " + this.memory);
	}
	
	public void setMemory2(int memory) { 
		System.out.println(Thread.currentThread().getName() + "비동기화 구역");
		synchronized(this) {
			this.memory = memory; // 1. 매개변수로 들어온 값을 필드에 저장 [ setter ]
			try {
				Thread.sleep(2000);
			}catch(Exception e) {
				System.out.println(e);
			} // 2. 현재 스레드를 2초간 일시정지 
			// 3. 2초 후 메모리 필드 확인
			System.out.println(Thread.currentThread().getName() + "요청한 2초 후 저장된 메모리 : " + this.memory);
		}
	
	
		
	}
}
