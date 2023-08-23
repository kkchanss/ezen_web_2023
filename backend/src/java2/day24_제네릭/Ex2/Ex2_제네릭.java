package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		Product<Tv, String> p1 = new Product<>();
		
		p1.setKind(new Tv());
		p1.setModel("스마트Tv");
		
		Tv tv = p1.getKind();
		String tvModel = p1.getModel();
		
		Product<Car, String> p2 = new Product<>();
		
		p2.setKind(new Car());
		p2.setModel("SUV자동차");
		
		Car car = p2.getKind();
		String carModel = p1.getModel();
	}
}
