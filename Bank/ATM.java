package Bank;

import java.util.*;

public class ATM {
	private int total;//�Ѿ�
	private int	saejong=1000;//������
	private int sinsa=200;//5������
	public boolean IsMinus=true;
	private ArrayList<String> transaction = new ArrayList<String>();

	//�ϴ� ����, ��¥ ������Ʈ ���� ä���ٰ� ����
	public ATM(){total=10000*saejong+50000*sinsa;}
	//�ܾ� ��ȸ
	public void Show() {
		transaction.add("%d");
		System.out.printf("���� �ܾ�: %d ��\n������: %d ��\n��������: %d ��\n",total,saejong,sinsa);
	}	
	//�Ա� 
	public void Plus(int money) {
		total+=money;// �ϴ� �Ա�
		//���� ����
		if(money>50000) {// 5���� �ʰ���
			sinsa+=(money/50000);// 5������ �߰�
			saejong+=(money%50000)/10000;//������ �߰�
		}
		else
			saejong+=(money/10000);
	}
	//���
	public void Minus(int money) {
		if(total<money) {// �ܾ� ����
			System.out.println("ATM �ܾ��� �����մϴ�.");
			IsMinus=false;
			return;
		}
		if((money%10000)!=0) {// ������ Ȥ�� �������Ǹ� ����
			System.out.println("����� ������ Ȥ�� �������Ǹ� �����մϴ�.");
			IsMinus=false;
			return;
		}
		//���� ����
		if((money>=50000)&&(money/50000)<=sinsa&&(money%50000)/10000<=saejong) {//��� �ݾ��� ���������� ũ��, �������ǰ� �������� ����� �ִٸ�
			IsMinus=true;
			total-=money;
			sinsa-=(money/50000);
			saejong-=(money%50000)/10000;
		}
		else if((money>=50000)&&(money/50000)>sinsa&&(money/10000)<=saejong) {//��� �ݾ��� �������Ǻ��� ũ��, ���������� ���µ� �������� �ִٸ�
			IsMinus=true;
			total-=money;
			saejong-=(money/10000);
		}
		else if((money>=50000)&&(money<60000)&&(money/50000)<sinsa){//��� �ݾ��� ������ �̻�, 6���� �̸�, �������� ���
			IsMinus=true;
			total-=money;
			sinsa-=(money/50000);
		}
		else if((money<50000)&&(money/10000)<=saejong) {//������ �̸�, ������ ���
			IsMinus=true;
			total-=money;
			saejong-=(money/10000);
		}
		else {
			IsMinus=false;
			System.out.println("ATM �ȿ� ���� �����մϴ�.");
		}//������ ���� �������
	}	
}
