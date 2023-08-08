package java1.day18.Ex1;

// 클래스에서 인터페이스를 구현하기
public class Television implements RemoteControl {
	
		// 클래스명 implements 인터페이스명
		// 인터페이스가 선언한 추상메소드를 해당 클래스가 구현 대신 하기
	// !!!! : implements 키워드 사용했으면 추상메소드를 꼭 구현한다.
	
	private int volume; // 인스턴스 필드
	
	// 추상메도르 구현 : implements 인터페이스명을 하게 되면 해당 인터페이스
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume > RemoteControl.MAX_VOLUME) {
			//만약에 볼륨이 최대볼륨보다 크면
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			// 만약에 볼륨이 최소볼륨보다 작으면
			this.volume = RemoteControl.MIN_VOLUME;
			
		}
	}
}
