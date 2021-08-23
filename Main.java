class Customer
{
    String accNo;
    String name;
    private int balance;

    void withdraw(int n)
    {
        if(balance >= n) setBalance(balance-n);
        else System.out.println("Not enough balance");

    }
    void deposit(int n)
    {
        setBalance(balance+n);
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int n)
    {
        balance = n;
        
    }

}
public class Main {
    
    public static void main(String[] args) 
    {
        new Test().test();
        
    }
}