package ucmap.java.day3.mission3.bank;

public class LoanAccount extends Account {
	private int limit;

	public LoanAccount() {
		setType("대출계좌");
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
