package ucmap.java.day4.mission4.bank;

public class SaveAccount extends Account implements Checkable{
	private double rate = 10;
	
	public SaveAccount(String name, int balance) {
		setName(name);
		setBalance(balance + balance / 10);
		setBankType("저축계좌");
	}

	@Override
	public void pay(int amount) {
		withdraw(amount);
		System.out.println(getName() + "님의 계좌에서 " + amount +"원 지불하였습니다.");
	}

	@Override
	public void deposit(int amount) {
		setBalance(getBalance() + (amount + amount / 10));
	}

	@Override
	public void withdraw(int amount) {
		int money = getBalance() - amount;
		if(money < 0) {
			System.out.println(getName() + "님의 계좌 잔액이 부족합니다.");
		} else {
			setBalance(getBalance() - amount); 
		}
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
