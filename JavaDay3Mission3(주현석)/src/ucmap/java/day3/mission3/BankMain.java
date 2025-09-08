package ucmap.java.day3.mission3;

import ucmap.java.day3.mission3.bank.Account;
import ucmap.java.day3.mission3.bank.Bank;

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank("마곡은행");// 마곡 은행이 생성되었습니다.
		
		bank.createAccount("홍길동", 1000, Bank.ACCOUNT_SAVE);
		//홍길동님의 저축계좌가 생성되었습니다. 출금가능액은 1100원 입니다.
		//
		bank.createAccount("김길동", 2000);
		//김길동님의 일반계좌가 생성되었습니다. 출금가능액은 2000원 입니다.
		
		bank.createAccount("이길동", 0, Bank.ACCOUNT_LOAN, 100000);
		// 이길동님의 대출계좌가 생성되었습니다. 출금가능액은 100000원 입니다.
		
		bank.printAllAccountsInfo();// 모든 계좌의 정보를 출력한다.
		//홍길동, 출금가능액: 1100, 저축계좌
		//김길동, 출금가능액: 2000, 일반계좌
		//이길동, 출금가능액: 100000, 대출계좌 
		
		bank.deposit("홍길동", 10000);
		bank.withdraw("이길동", 20000 );
		
		Account temp = bank.findAccountByName("홍길동");
		temp.printAccountInfo();//홍길동, 출금가능액: 12100, 저축계좌
		
		temp = bank.findAccountByName("이길동");
		temp.printAccountInfo();//이길동, 출금가능액: 80000, 대출계좌
				
	}
}
