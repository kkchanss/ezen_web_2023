package java2.day23;

public class Ex3_동기화 {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		// 유저1 생성
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		// 유저2 생성
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	}
}
