package Projects;
import java.util.*;

public class BankingSystem {
    public static boolean accExists(ATM[] a,int accNo){
        int pos=-1;
        for(int i=0;i<a.length;i++){
            if(a[i].getAccNo()==accNo){
                pos=i;
            }
        }
        if(pos==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public static int findAccByNo(ATM[] a,int accNo){
        int pos=-1;
        for(int i=0;i<a.length;i++){
            if(a[i].getAccNo()==accNo){
                pos=i;
            }
        }
        return pos;
    }
    public static void balance(ATM[] a,int accNo){
        int pos=findAccByNo(a,accNo);
            System.out.println("Available balance="+a[pos].getBalance());
    }
    public static void deposit(ATM[] a,int accNo,double amount){
        int pos=findAccByNo(a,accNo);
            a[pos].updateBalance(amount);
            System.out.println("Amount deposited successful!");
            System.out.println("Available balance=Rs "+a[pos].getBalance());
    }
    public static void withdraw(ATM[] a,int accNo,double amount){
        int pos=findAccByNo(a,accNo);
            if(a[pos].getBalance()>amount) {
                amount = amount * (-1);
                a[pos].updateBalance(amount);
                System.out.println("Please collect the amount");
                System.out.println("Available balance=Rs " + a[pos].getBalance());
            }
            else{
                System.out.println("Insufficient balance");
            }
    }

    public static void main(String[] args) {
        ATM acc1 = new ATM(1,10);
        ATM acc2 = new ATM(2,20);
        ATM acc3 = new ATM(3,30);
        ATM[] accounts = new ATM[]{acc1,acc2,acc3};
        Scanner scan = new Scanner(System.in);
        double amount;
        int option;
        while(true) {
            System.out.println("-----WELCOME TO AXIS BANK-----");
            System.out.println("Type 1 - View Balance");
            System.out.println("Type 2 - Deposit Amount");
            System.out.println("Type 3 - Withdraw Amount");
            System.out.println("Type 4 - Exit");
            System.out.println("------------------------------");
            System.out.println("Your option:");
            option = scan.nextInt();
            int accNo;
            switch (option) {
                case 1:
                    System.out.println("Enter the account number:");
                    accNo = scan.nextInt();
                    if(accExists(accounts,accNo)) {
                    accExists(accounts,accNo);
                    balance(accounts, accNo);
                    break;
                    }
                    else{
                        System.out.println("No account number found");
                        break;
                    }
                case 2:
                    System.out.println("Enter the account number:");
                    accNo = scan.nextInt();
                    if(accExists(accounts,accNo)) {
                    System.out.println("Enter the amount to deposit:");
                    amount = scan.nextDouble();
                    deposit(accounts, accNo, amount);
                    break;
                    }
                    else{
                        System.out.println("No account number found");
                        break;
                    }
                case 3:
                    System.out.println("Enter the account number:");
                    accNo = scan.nextInt();
                    if(accExists(accounts,accNo)) {
                        System.out.println("Enter the amount to withdraw:");
                        amount = scan.nextDouble();
                        withdraw(accounts, accNo, amount);
                        break;
                    }
                    else{
                        System.out.println("No account number found");
                        break;
                    }
                case 4:
                    System.out.println("--------Thank you--------");
                    System.exit(0);
                default:
                    System.out.println("Try again...");
            }
        }
    }
}
interface Security{
    public void updateBalance(double balance);
    public double getBalance();
    public int getAccNo();
}
class ATM implements Security{
    private int accNo;
    private double balance;

    public int getAccNo(){
        return accNo;
    }

    public void updateBalance(double balance) {
        this.balance=this.balance+balance;
    }

    public double getBalance() {
        return balance;
    }

    ATM(int accNo,double balance){
        this.accNo=accNo;
        this.balance=balance;
    }
}

