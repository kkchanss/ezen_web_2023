package java2.day26_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ex2_Vector {
	public static void main(String[] args) {
		
		List<Board> list = new Vector<>();  // 두 스레드가 안전하게 2000개 모두 저장
		//List<Board> list = new ArrayList<>(); 두 스레드가 2000개 모두 저장 못함
		
		Thread threadA = new Thread() {
			
			public void run() {
				for( int i = 1; i <= 1000; i++) {
					list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
				}
			} 
		};
		
		Thread threadB = new Thread() {
			
			public void run() {
				for( int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
				}
			} 
		};
		
		threadA.start();
		threadB.start();
		
		try {
			threadA.join();
			threadB.join();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
	} 
}
