package java2.day21;

public class Account {
	private long balance;
	public Account() {} 
	public long getBalance() { return balance; }
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdorw(int money) throws 잔고부족예외 {
		if(this.balance < money) {
			throw new 잔고부족예외("잔고부족 : " + (money-this.balance) + "만큼 부족");
		}
		this.balance -= money;
	}
}
