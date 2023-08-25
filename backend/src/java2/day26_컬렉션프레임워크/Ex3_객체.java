package java2.day26_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex3_객체 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<>();
		
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime(); // 현재시간을 나노시간으로 호출/반환 받기
		
		for(int i = 0; i < 10000; i ++) {
			list1.add(0, i+"");
			endTime = System.nanoTime(); // 현재시간을 나노시간으로 호출/반환 받기
		}
	}

}
