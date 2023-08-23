package java2.day24_제네릭.Ex3;

public class Ex3_제네틱 {

	public static void main(String[] args) {
		
		HomeAgency 홈렌탈안산지점 = new HomeAgency();
		Home 유재석집 = 홈렌탈안산지점.rent();
		유재석집.turnOnLight();
		Home 강호동집 = 홈렌탈안산지점.rent();
		강호동집.turnOnLight();
		
		HomeAgency 홈렌탈수원지점 = new HomeAgency();
		Home 신동엽집 = 홈렌탈수원지점.rent();
		신동엽집.turnOnLight();
		Home 하하집 = 홈렌탈수원지점.rent();
		하하집.turnOnLight();
	}

}
