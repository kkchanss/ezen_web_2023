package 과제.과제10;

import java.util.Scanner;

public class 과제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Phone phone = new Phone();
		Battery battery = new Battery();
		
		

		String appInfo = "유튜브,15 카톡,3 카메라,5 테트리스,20";
		App[] app = new App[appInfo.split(" ").length];
		
		for (int i = 0; i < app.length; i++) {
			String _tmp = appInfo.split(" ")[i];
			app[i] = new App(_tmp.split(",")[0], Integer.parseInt(_tmp.split(",")[1]));
		}

		phone.setApp(app);
		phone.setBattery(battery);
		Scanner sc = new Scanner(System.in);
		// -------------------초기화-------------------

		while (true) {
			System.out.println("1. 켜기 2.충전");
			if (sc.nextInt() == 1) {
				while (true) {
					if (phone.getBattery().capacity > 0) {
						for (int i = 0; i < app.length; i++) {
							System.out.printf("%d. %s ", (i + 1), app[i].getName());
						}
						System.out.println("\t 현재 배터리 >> " + phone.getBattery().capacity + "%");
						System.out.print("실행할 앱 선택>> ");
						int ch = sc.nextInt()-1 ;
						if(ch >= app.length) 
						{
							System.out.println("해당 앱이 없습니다.");
							continue;
						}
						
						phone.getBattery().capacityMinus(app[ch].namePrint());
					} else {
						System.out.println("배터리가 없습니다.");
						break;
					}
				}

			} else {
				phone.getBattery().capacityPlus();
			}

		}
	}

}
