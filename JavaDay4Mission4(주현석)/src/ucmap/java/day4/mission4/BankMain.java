package ucmap.java.day4.mission4;

import ucmap.java.day4.mission4.bank.Account;
import ucmap.java.day4.mission4.bank.Bank;
import ucmap.java.day4.mission4.bank.SaveAccount;

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
		
		Account temp1 = bank.findAccountByName("홍길동");
		temp1.printAccountInfo();//홍길동, 출금가능액: 12100, 저축계좌
		
		//****아래의 지불메시지가 출력되도록 아래 코드(32라인)를 수정하시오.
		//홍길동님의 계좌에서 1000원 지불하였습니다.
		((SaveAccount)temp1).pay(1000);		
		
		Account temp2 = bank.findAccountByName("이길동");
		temp2.printAccountInfo();//이길동, 출금가능액: 80000, 대출계좌
		
		bank.transferMoney("이길동", "홍길동", 30000);
		//이길동님의 계좌에서 홍길동님의 계좌로 30000원 이체하였습니다.
		
		bank.withdraw("김길동", 2000);
		bank.withdraw("김길동", 10000);
		//김길동님의 계좌 잔액이 부족합니다.
		
		Account temp3 = bank.findAccountByName("박길동");
		//입력하신 박길동 계좌를 찾을 수 없습니다. 계좌 정보를 확인해 주세요.
		System.out.println(temp3);//null				
	}
}
