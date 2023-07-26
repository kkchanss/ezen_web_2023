package 복습.part3;

import java.util.Scanner;

public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.콜라 2.환타 3.사이다 4.결제");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			
			if(num >= 1 && num <= 3) {
				String 제품 = 재고관리[num-1];
				int 재고 = Integer.parseInt(제품.split(",")[0]);
				int 바구니 = Integer.parseInt(제품.split(",")[1]);
				int 가격 = Integer.parseInt(제품.split(",")[2]);
				String name = 제품.split(",")[3];
				
				if(재고 > 0) {
					재고--; 바구니++;
					System.out.println(name + "가 담겼습니다.");
				}
				else {
					System.out.println(name + " 재고가 부족합니다.");
				}
				재고관리[num-1] = 재고 + "," + 바구니 + "," + 가격 + "," + name;
			}
			else if(num == 4) {
				System.out.println("------------------------------");
				System.out.println("제품명\t수량\t가격");
				int sum = 0;
				for(int i = 0; i < 재고관리.length; i++) {
					String 제품 = 재고관리[i];
					int 재고 = Integer.parseInt(제품.split(",")[0]);
					int 바구니 = Integer.parseInt(제품.split(",")[1]);
					int 가격 = Integer.parseInt(제품.split(",")[2]);
					sum += (바구니*가격);
					String name = 제품.split(",")[3];
					if(바구니 > 0) {
						System.out.println(name + "\t" + 바구니 + "\t" + 바구니*가격);
					}
				}
				System.out.println("총가격 : " + sum);
			}
		}
	}

}
