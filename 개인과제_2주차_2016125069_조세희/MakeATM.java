import java.util.Scanner;

public class MakeATM {
    public static void main(String[] args){
        Account account1 = new Account(50.00);
        Account account2 = new Account(-8.99);
        System.out.printf("account1 balance : $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance : $%.2f\n",
                account2.getBalance());
        Scanner input = new Scanner(System.in);
        double depositAmount;
        double withdrawsAmount;
        /*입금*/
        System.out.print("Enter deposit amount for account1: ");
        depositAmount = input.nextDouble();
        System.out.printf("\nadding %.2f to account1 balance\n\n",depositAmount);
        account1.credit(depositAmount);
        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();
        System.out.printf("\nadding %.2f to account1 balance\n\n",depositAmount);
        account2.credit(depositAmount);
        /*계좌 조회*/
        System.out.printf("account1 balance : $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance : $%.2f\n",
                account2.getBalance());
        /*출금*/
        System.out.print("Enter withdraws amount for account1: ");
        withdrawsAmount = input.nextDouble();
        System.out.printf("\nwithdraw %.2f to account1 balance\n\n",withdrawsAmount);
        if(withdrawsAmount>account1.getBalance()){
            System.out.printf("Debit amount exceeded account balance\n");
        }else{
            account1.debit(withdrawsAmount);
        }
        System.out.print("Enter withdraws amount for account2: ");
        withdrawsAmount = input.nextDouble();
        System.out.printf("\nwithdraw %.2f to account2 balance\n\n", withdrawsAmount);
        if(withdrawsAmount>account2.getBalance()) {
            System.out.printf("Debit amount exceeded account balance\n");
        }else{
            account2.debit(withdrawsAmount);
        }
        /*계좌 조회*/
        System.out.printf("account1 balance : $%.2f\n",
                account1.getBalance());
        System.out.printf("account2 balance : $%.2f\n",
                account2.getBalance());
    }
}
