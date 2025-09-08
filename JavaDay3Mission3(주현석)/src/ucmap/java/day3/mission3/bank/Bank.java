package ucmap.java.day3.mission3.bank;

public class Bank {
	public static final String ACCOUNT_SAVE = "SAVE";
	public static final String ACCOUNT_LOAN = "LOAN";
	public static int accountCount = 3;
	public static int idx = 0;

	private Account[] accounts; //

	// 생성자
	public Bank(String bankName) {
		System.out.println(bankName + "이 생성되었습니다.");
		accounts = new Account[accountCount];
	}

	// 일반계좌 생성
	public void createAccount(String name, int balance) {
		Account account = new Account();
		account.setName(name);
		account.setBalance(balance);
		accounts[idx++] = account;

		System.out.println(name + "님의 일반계좌가 생성되었습니다. 출금가능액은 " + balance + "원 입니다.");
	}

	// 저축계좌 생성
	public void createAccount(String name, int balance, String type) {
		SaveAccount saveAccount = new SaveAccount();
		saveAccount.setName(name);
		saveAccount.setBalance(balance + balance / 10);
		accounts[idx++] = saveAccount;

		System.out.println(name + "님의 저축계좌가 생성되었습니다. 출금가능액은 " + (balance + balance / 10) + "원 입니다.");
	}

	// 대출계좌 생성
	public void createAccount(String name, int balance, String type, int limit) {
		LoanAccount loanAccount = new LoanAccount();
		loanAccount.setName(name);
		loanAccount.setBalance(limit);
		loanAccount.setLimit(limit);
		accounts[idx++] = loanAccount;

		System.out.println(name + "님의 대출계좌가 생성되었습니다. 출금가능액은 " + limit + "원 입니다.");
	}

	// 모든 계좌 정보 출력
	public void printAllAccountsInfo() {
		for (Account account : accounts) {
			System.out.println(account.getName() + ", 출금가능액: " + account.getBalance() + ", " + account.getType());
		}
	}

	// 입금
	public void deposit(String name, int money) {
		Account account = findAccountByName(name);

		if ("저축계좌".equals(account.getType())) {
			account.setBalance(account.getBalance() + (money + money / 10));
			return;
		}
		account.setBalance(account.getBalance() + money);
	}

	// 출금
	public void withdraw(String name, int money) {
		Account account = findAccountByName(name);
		account.setBalance(account.getBalance() - money);
	}

	// 계좌 찾기
	public Account findAccountByName(String name) {
		Account targetAccount = null;

		for (Account account : accounts) {
			if (name.equals(account.getName())) {
				targetAccount = account;
			}
		}

		return targetAccount;
	}
}
