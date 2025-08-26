import java.util.Scanner;
class bankmanagement{
        private String name;
        private int accno;
        private float balance;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter account number: ");
        int accno = sc.nextInt();
        System.out.println("Enter balance: ");  
        float balance = sc.nextFloat();
        bankmanagement account = new bankmanagement(name, accno, balance);
        int choice;
        do{
    }
    public bankmanagement(String name, int accno, float balance){
        this.name = name;
        this.accno = accno;
        this.balance = balance;
    }
    public void desposit(float amount){
        balance += amount;
        System.out.println("Amount deposited successfully. New balance: " + balance);
    }
    public void withdraw(float amount){
        if(amount > balance){
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. New balance: " + balance);
        }
    }
    public void checkBalance(){
        System.out.println("Current balance: " + balance);
    }
    public void displayAccountInfo(){
        System.out.println("Account Holder Name: " + name);
        System.out.println("Account Number: " + accno);
        System.out.println("Current Balance: " + balance);
    }
}