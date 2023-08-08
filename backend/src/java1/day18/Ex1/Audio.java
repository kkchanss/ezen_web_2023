package java1.day18.Ex1;

public class Audio implements RemoteControl{
	
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 끕니다");
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
