package Bank;
import java.util.Scanner;
public class BankTest {
		
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		ATM atm=new ATM();
		Account ac1=new Account(10000);
		System.out.println("번호를 눌러주세요");
		boolean a=true;
		
		while(a) {
			int choice;
			System.out.println("1.조회   2.입금   3.출금   4.ATM 조회   5.종료");
			choice=input.nextInt();
			switch (choice) {
			case 1:
				System.out.printf("현재 계좌 잔액: %d\n",ac1.get());
				break;
			case 2:
				System.out.println("입금할 금액을 입력하세요");
				int add=input.nextInt();
				atm.Plus(add);
				ac1.credit(add);
				break;
			case 3:
				System.out.println("출금할 금액을 입력하세요");
				int sub=input.nextInt();
				atm.Minus(sub);
				if(atm.IsMinus) {//기기 출금 됬으면
					ac1.debit(sub);// 계좌 인출
					if(!ac1.IsDebit)atm.Plus(sub);//반대로 계좌금액이 부족하면 ATM 금액을 복구;
				}
				break;
			case 4: atm.Show();	break;
			case 5:	a=false;	break;

			}
		}
	}

}
