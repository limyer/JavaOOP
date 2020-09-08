package Bank;

import java.util.*;

public class ATM {
	private int total;//총액
	private int	saejong=1000;//만원권
	private int sinsa=200;//5만원권
	public boolean IsMinus=true;
	private ArrayList<String> transaction = new ArrayList<String>();

	//일단 생성, 날짜 업데이트 없이 채웠다고 가정
	public ATM(){total=10000*saejong+50000*sinsa;}
	//잔액 조회
	public void Show() {
		transaction.add("%d");
		System.out.printf("현재 잔액: %d 원\n만원권: %d 장\n오만원권: %d 장\n",total,saejong,sinsa);
	}	
	//입금 
	public void Plus(int money) {
		total+=money;// 일단 입금
		//지폐 정리
		if(money>50000) {// 5만원 초과시
			sinsa+=(money/50000);// 5만원권 추가
			saejong+=(money%50000)/10000;//만원권 추가
		}
		else
			saejong+=(money/10000);
	}
	//출금
	public void Minus(int money) {
		if(total<money) {// 잔액 부족
			System.out.println("ATM 잔액이 부족합니다.");
			IsMinus=false;
			return;
		}
		if((money%10000)!=0) {// 만원권 혹은 오만원권만 가능
			System.out.println("출금은 만원권 혹은 오만원권만 가능합니다.");
			IsMinus=false;
			return;
		}
		//지폐 정리
		if((money>=50000)&&(money/50000)<=sinsa&&(money%50000)/10000<=saejong) {//출금 금액이 오만원보다 크고, 오만원권과 만원권이 충분히 있다면
			IsMinus=true;
			total-=money;
			sinsa-=(money/50000);
			saejong-=(money%50000)/10000;
		}
		else if((money>=50000)&&(money/50000)>sinsa&&(money/10000)<=saejong) {//출금 금액이 오만원권보다 크고, 오만원권은 없는데 만원권이 있다면
			IsMinus=true;
			total-=money;
			saejong-=(money/10000);
		}
		else if((money>=50000)&&(money<60000)&&(money/50000)<sinsa){//출금 금액이 오만원 이상, 6만원 미만, 오만원권 충분
			IsMinus=true;
			total-=money;
			sinsa-=(money/50000);
		}
		else if((money<50000)&&(money/10000)<=saejong) {//오만원 미만, 만원권 충분
			IsMinus=true;
			total-=money;
			saejong-=(money/10000);
		}
		else {
			IsMinus=false;
			System.out.println("ATM 안에 지폐가 부족합니다.");
		}//나머지 전부 지폐부족
	}	
}
