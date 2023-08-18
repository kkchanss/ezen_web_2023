package java2.day21;

public class Ex3_예외던지기 {

	
	// p. 478
	public static void main(String[] args) {
		
		// p.478 : 예외 던지기 : 메소드 안에서 예외가 발생하면 해당 메소드를 호출했던 곳으로 예외 이동
	}

	//
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
