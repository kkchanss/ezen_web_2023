package java2.day23;

public class User1Thread extends Thread{
	private Calculator calculator;
	
	public User1Thread() { setName("user1"); }
	public void setCalculator(Calculator calculator) { this.calculator = calculator;}
	
	@Override
	public void run() {
		calculator.setMemory1(100);
	}
}
