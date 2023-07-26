package 과제.과제10;

public class Battery {
	public int capacity = 100;
	
	public void capacityMinus(int batteryDesc) {
		capacity-=batteryDesc;
		if(capacity <0) {capacity =0;}
	}
	
	public void capacityPlus() {
		while(true) {
			capacity+=5;
			if(capacity >= 100) {
				capacity = 100; 
				System.out.println("충전 완료");
				return;
			}
			System.out.println("충전중 : " + capacity + "%");
		}
	}
}
