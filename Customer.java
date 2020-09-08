public class Customer{
    private int SAcount;// 예금계좌 유무
    public Customer (int Scount){
        SAcount = Scount;
        if(Scount==1){
            SavingAccount savingAccount = new SavingAccount(0.00);
        }
    }
    CheckingAccount checkingAccount = new CheckingAccount(0.00);
}
