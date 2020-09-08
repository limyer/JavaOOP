package Bank;

public class Account {
	private int balance;
	public boolean IsDebit=true;
	
	public Account(int ini){
		balance=ini;
	}
	
	public int get(){ return balance;}
	
	public void credit(int add) {
		balance=add+balance;
	}
	
	public void debit(int sub){
		if(sub>balance) {
			IsDebit=false;
			System.out.println("Debit amount exceeded accout balance");
		}
		else {
			IsDebit=true;
			balance=balance-sub;
		}
	}
}
