package java1.day11.Ex4디자인패턴1;

public class EX4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
	소프트웨어 디자인 패턴
	1. MVC
		M : model	[ JAVA, DB 등 ]
		C : controller	[ JAVA ]
		V : view		[ HTML, JSm CSS ]
	
	고객[VIEW]	--------> 	서빙/요리사[Controller] ------DTO----------->	냉장고 [ Dao ]
	- 요구/응답 받는 입장			- 요구에 따른 응답해주는 입장						- 원본의 데이터가 저장되는 곳 또는 접근하는 곳
	- 입/출력되는 구역			- 가공, 유효성검사, 전달, 로직 구역					- 실질적인 데이터 관리
	- HTML/JS				- JAVA										- DB 		
*/