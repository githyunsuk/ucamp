package ucmap.java.day4.mission4.bank;

public class LoanAccount extends Account implements Loanable {
	private int limit;
	
	public LoanAccount(String name, int balance, int limit) {
		setName(name);
		setBalance(limit);
		setLimit(limit);
		setBankType("대출계좌");
	}

	@Override
	public void setLimit(int amount) {
		this.limit = amount;
		
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

	public int getLimit() {
		return limit;
	}
	
	

}
