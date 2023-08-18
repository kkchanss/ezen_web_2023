package java2.day21;

public class Ex2_예외처리 {
	public static void main(String[] args) {
		// p. 470 : 다중 catch
		String[] array = {"100", "1oo"};
		
			// Integer.parseInt(문자열인 숫자) : 문자열숫자 => 정수형숫자 정수로타입변환
			// System.out.println(Integer.parseInt("7")); // 문자 7 => 번구 7 형변환 가능
			// System.out.println(Integer.parseInt("ㄱ")); // 문자 ㄱ => 정수 // NumberFormatException
		
		for(int i = 0 ; i <= array.length; i++) { // 인덱스:0~1 // 길이 : 2 // 인덱스 2는 없음 
			System.out.println(array[i]); // ArrayIndexOutOfBoundsException
			try {
			int value = Integer.parseInt(array[i]);
				// NumberFormatException : For input string: "1oo"
			} catch( NumberFormatException e){
				System.out.println("숫자로 변환할 수 없는 데이터 : " + e.getMessage());
			} catch( ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 인덱스 초과 : " + e.getMessage());
			} catch( Exception e) {
				System.out.println("예외 발생 : " + e);
			}
		}
		
	}
}
