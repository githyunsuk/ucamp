package ucmap.java.day4.mission4.bank;

public class NormalAccount extends Account {
	
	public NormalAccount(String name, int balance) {
		setName(name);
		setBalance(balance);
		setBankType("일반계좌");
	}

	@Override
	public void deposit(int amount) {
		setBalance(getBalance() + amount); 
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
}
