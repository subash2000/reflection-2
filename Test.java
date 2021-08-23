import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test 
{
    Field accNo = null;
    Field balance = null;
    Field name = null;
    Method deposit = null;
    Method withdraw = null;
    Method getBalance = null;
    Method setBalance = null;
    Customer customer = null;

    Test()
    {
        try 
        {
            Class<?> customerCls = Class.forName("Customer");
            accNo = customerCls.getDeclaredField("accNo");
            balance = customerCls.getDeclaredField("balance");
            name = customerCls.getDeclaredField("name");
            deposit = customerCls.getDeclaredMethod("deposit", int.class);
            withdraw = customerCls.getDeclaredMethod("withdraw", int.class);
            getBalance = customerCls.getDeclaredMethod("getBalance");
            setBalance = customerCls.getDeclaredMethod("setBalance", int.class);
            customer = new Customer();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
       
    }

    public void setValues(String accNo,String name,int balance) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        this.accNo.set(customer, accNo);
        this.name.set(customer, name);
        this.balance.setAccessible(true);
        this.balance.setInt(customer, balance);
        
        System.out.println("Account no : "+this.accNo.get(customer));
        System.out.println("Customer name : "+this.name.get(customer));
        System.out.println("Balance : "+this.balance.get(customer));
        

        System.out.println("Depositing Rs 100....");
        deposit.invoke(customer, 100);
        System.out.println("Balance : "+getBalance.invoke(customer));
        System.out.println("Withdraw Rs 10....");
        withdraw.invoke(customer, 10);
        System.out.println("Balance : "+getBalance.invoke(customer));
        System.out.println("Withdraw Rs 100");
        withdraw.invoke(customer, 100);
        System.out.println("Balance : "+this.balance.get(customer));
        System.out.println("=====================================================");

    }


    public void test()
    {
        try 
        {
            setValues("1234567891234", "john", 0);
        }
        catch (Exception e) 
        {    
            e.printStackTrace();
        }

        
    }
  
    
}
