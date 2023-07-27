package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 파일처리연습 {

	public static void main(String[] args) throws IOException {
		
		while(true)	{
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			System.out.println(fileInfo);
			
			String[] fileArray = fileInfo.split("\n"); System.out.println("제품별 분리:" + Arrays.toString(fileArray));
			String[] 재고관리 = fileInfo.split("\n");
			System.out.println(Arrays.toString(재고관리));
			System.out.println("\n\n-----------------메뉴------------------");
			System.out.println("-1:제품등록 0:결제");
				
				for(int i = 0; i<재고관리.length; i++) {
					if(!재고관리[i].equals("")) {
						
					}
				}
			
		}
	}

}
