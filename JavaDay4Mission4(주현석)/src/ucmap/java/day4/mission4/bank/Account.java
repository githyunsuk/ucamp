package ucmap.java.day4.mission4.bank;

public abstract class Account {
	private String name;
	private int balance;
	private String bankType;
	
	//계좌 정보 출력
	public void printAccountInfo() {
		System.out.println(toString());
	}
	
	public abstract void deposit(int amount);
	public abstract void withdraw(int amount);

	public String getName() {
		return name;
	}

	
	// getter, setter
	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@Override
	public String toString() {
		return name + ", 출금가능액:" + balance + ", " + bankType;
	}
	
}
