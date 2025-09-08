package ucmap.java.day3.mission3.bank;

public class Account {
	private String name;
	private int balance;
	private String type;

	public void printAccountInfo() {
		System.out.println(name + ", 출금가능액: " + balance + ", " + type);
	}

	public Account() {
		this.type = "일반계좌";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
