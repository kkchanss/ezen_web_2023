package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			String filePath = "./src/복습/part4/Part4.txt";

			FileOutputStream fileOutputStream = new FileOutputStream( filePath ,true); 

			FileInputStream fileInputStream = new FileInputStream( filePath ); 

			File file = new File( filePath );
			
			System.out.println("------------------메뉴----------------------");
			System.out.print("-1:제품등록 0:결제 ");
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] 재고관리 = fileInfo.split("\n");
			
			for(int i = 0 ; i < 재고관리.length; i++) {
				if(!재고관리[i].equals("")) {
					String name = 재고관리[i].split(",")[0];
					String price = 재고관리[i].split(",")[1];
					System.out.print((i+1) + ":" + name + "[" + price + "] ");
				}
			}
			System.out.println();
			System.out.print(">>>> 선택 : ");
			int num = sc.nextInt();
			
			if(num == -1) {
				System.out.print("제품명 : "); String inName = sc.next();
				System.out.print("초기재고 : "); String inJ = sc.next();
				System.out.print("가격 : "); String inPrice = sc.next();
				
				String outStr = inName + "," + inPrice + "," + inJ + ",0\n";   
				
				fileOutputStream.write(outStr.getBytes());
				
				System.out.println("안내) 상품 등록이 완료되었습니다.");
			}
			else if(num > 0 && num <= 재고관리.length) {
				String product = 재고관리[num-1];
				String name = product.split(",")[0];
				int price = Integer.parseInt(product.split(",")[1]) ;
				int jj = Integer.parseInt(product.split(",")[2]);
				int back = Integer.parseInt(product.split(",")[3]);
				if(jj > 0) {
					System.out.println(name + " 제품을 담았습니다.");
					jj--; back++;
					
					재고관리[num-1] = name + "," + price + "," + jj + "," + back;
 					
					String outStr = "";
					
					for(int i = 0; i < 재고관리.length; i++) {
						outStr += 재고관리[i] + "\n";
					}
					
					FileOutputStream fileOut2 = new FileOutputStream(filePath);
					fileOut2.write(outStr.getBytes());
				}
				else {
					System.out.println(name + " 제품의 재고가 부족합니다.");
				}
			}
			else if(num == 0) {
				System.out.println("제품명\t수량\t가격");
				for(int i = 0; i < 재고관리.length; i++) {
					String product = 재고관리[i];
					String name = product.split(",")[0];
					int price = Integer.parseInt(product.split(",")[1]);
					int back = Integer.parseInt(product.split(",")[3]);
					
					if(back > 0) {
						System.out.println(name + "\t" + back + "\t" + back*price );
					}
				}
			}
		}
	}

}
