package java2.day24_제네릭.Ex1;

import 복습.part7.model.dto.MemberDto;

public class Ex1_제네릭예제 {

	public static void main(String[] args) {
		// 제네릭 사용하지 않을때 -> Object
		Box2 box2 = new Box2();
		box2.content = 1;
		// 자식객체는 부모객체로 대입 [자동타입변환] : 무조건 가능
		box2.content = "안녕";

		box2.content = new MemberDto();
		
		// 부모는 자식의 멤버를 사용할 수 없다.
		MemberDto dto = (MemberDto)box2.content;
		dto.getPhone();
		
		if(box2.content instanceof MemberDto) {
			
		}
		
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요.";
		String content = box1.content;
		
		Box<Integer> box3 = new Box<>();
		box3.content = 100;
		int value = box3.content;		

		Box<MemberDto> box4 = new Box<>();
		box4.content = new MemberDto();
		MemberDto value2 = box4.content;				
		
	}

}
