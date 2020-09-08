package Bank;

//정기예금 계좌
public class SavingsAccount extends Account{

	public SavingsAccount(){
		balance=0;
	}
	
	public SavingsAccount(int initialBalance){
		balance=initialBalance;
	}
	
	//예금 계좌에서는 출금 불가능
	public boolean debit(int amount){
		System.out.println("예금 계좌에서는 출금할 수 없습니다.");
		return false;
	}
}