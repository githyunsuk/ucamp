package ucmap.java.day4.mission4.bank;

import java.util.ArrayList;

public class Bank {
	public static final String ACCOUNT_SAVE ="SAVE";
	public static final String ACCOUNT_LOAN ="LOAN";
	public static int accountCount = 3;
	
	private ArrayList<Account> accountList; //
	
	public Bank(String bankName) {
		accountList = new ArrayList<>();
		System.out.println(bankName + "이 생성되었습니다.");
	}
	
	//일반 계좌 생성
	public void createAccount(String name, int balance) {
		createAccount(name, balance, null);
	}
	
	//저축 계좌 생성
	public void createAccount(String name, int balance, String type) {
		createAccount(name, balance, type, 0);
	}
	
	//대출 계좌 생성
	public void createAccount(String name, int balance, String type, int limit) {
		Account account = null;
		if("SAVE".equals(type)) {
			account = new SaveAccount(name, balance);
		} else if("LOAN".equals(type)) {
			account = new LoanAccount(name, balance, limit);
		} else {
			account = new NormalAccount(name, balance);
		}
		
		accountList.add(account);
		System.out.println(name + "님의 " + account.getBankType() +"가 생성되었습니다. 출금가능액: " + account.getBalance());
	}
	
	//모든 계좌 정보 출력
	public void printAllAccountsInfo() {
		
		for(Account account : accountList) {
			System.out.println(account.getName() + ", 출금가능액:" + account.getBalance() + ", " + account.getBankType());
		}
	}
	
	//계좌 찾기
	public Account findAccountByName(String name) {
		Account targetAccount = null;
		
		for(Account account : accountList) {
			if(account.getName().equals(name)) {
				targetAccount = account;
			}
		}
		
		if(targetAccount == null) {
			System.out.println("입력하신 " + name + "계좌를 찾을 수 없습니다. 계좌 정보를 확인해 주세요.");
		}
	
		return targetAccount;
	}
	
	//입금
	public void deposit(String name, int amount) {
		Account account = findAccountByName(name);
		account.deposit(amount);
	}
	
	//출금
	public void withdraw(String name, int amount) {
		Account account = findAccountByName(name);
		account.withdraw(amount);
	}
	
	//이체
	public void transferMoney(String name, String name2, int amount) {
		Account accountFrom = findAccountByName(name);
		Account accountTo = findAccountByName(name2);
		
		accountFrom.withdraw(amount);
		accountTo.deposit(amount);
		System.out.println(name + "님의 계좌에서 " + name2 + "님의 계좌로 " + amount + "원 이체하였습니다.");
	}
	
}
