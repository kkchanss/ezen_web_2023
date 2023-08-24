package java2.day24_제네릭.Ex4;

public class Ex4_제네릭 {

	public static <T> Box<T> boxing(T t) {
		
		Box<T> box = new Box<>();
		box.setContent(t);
		
		return box;	
	}
	
	public static void main(String[] args) {
		Box<Integer> box1 = boxing(100);
		
	}

}
