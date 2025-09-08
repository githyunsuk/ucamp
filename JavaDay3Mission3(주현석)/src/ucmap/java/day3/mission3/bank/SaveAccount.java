package ucmap.java.day3.mission3.bank;

public class SaveAccount extends Account {
	private double rate = 10;
	
	public SaveAccount() {
		setType("저축계좌");
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
