package Bank;
import java.util.Scanner;
public class BankTest {
		
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		ATM atm=new ATM();
		Account ac1=new Account(10000);
		System.out.println("��ȣ�� �����ּ���");
		boolean a=true;
		
		while(a) {
			int choice;
			System.out.println("1.��ȸ   2.�Ա�   3.���   4.ATM ��ȸ   5.����");
			choice=input.nextInt();
			switch (choice) {
			case 1:
				System.out.printf("���� ���� �ܾ�: %d\n",ac1.get());
				break;
			case 2:
				System.out.println("�Ա��� �ݾ��� �Է��ϼ���");
				int add=input.nextInt();
				atm.Plus(add);
				ac1.credit(add);
				break;
			case 3:
				System.out.println("����� �ݾ��� �Է��ϼ���");
				int sub=input.nextInt();
				atm.Minus(sub);
				if(atm.IsMinus) {//��� ��� ������
					ac1.debit(sub);// ���� ����
					if(!ac1.IsDebit)atm.Plus(sub);//�ݴ�� ���±ݾ��� �����ϸ� ATM �ݾ��� ����;
				}
				break;
			case 4: atm.Show();	break;
			case 5:	a=false;	break;

			}
		}
	}

}
