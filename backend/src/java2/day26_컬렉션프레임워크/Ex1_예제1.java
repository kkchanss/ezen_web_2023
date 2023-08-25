package java2.day26_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.AbstractProcessor;

public class Ex1_예제1 {

	public static void main(String[] args) {
		
		List<Board> list = new ArrayList<>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		list.add(0, new Board("제목6", "내용6", "글쓴이6")); // 인덱스 0번에 객체 생기고 한칸씩 뒤로 물러남 
		list.set(1, new Board("제목7", "내용7", "글쓴이7")); // 인덱스 1번에 객체 사라지고 해당 객체 추가
		
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println("인덱스 : " + list.get(i));
		}
		int index = 0;
		for(Board b : list) {
			System.out.println("인덱스 : " + index + " " + b);
			index++;
		}
		
		list.forEach(b -> {System.out.println(b);});
		
		list.remove(2);
		//list.remove(board);
		
		list.clear();
		
		
	}

}
