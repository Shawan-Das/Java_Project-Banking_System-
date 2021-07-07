package sample;
import javax.swing.*;
import java.util.ArrayList;
public class Bank {
    ArrayList<BankAccount> accounts = new ArrayList<>();

    private String addAccount(BankAccount acc){
        accounts.add(acc);
        return acc.getAccountNumber();
    }

    public String addAccount(String name,double balance,String pass, double maxWithLimit){
        BankAccount accounts= new SavingsAccount(name,balance,pass,maxWithLimit);
        String acNumber = addAccount(accounts);
        return acNumber;
    }

    public String addAccount(String name,double balance,String pass,String tradeLicense){
        BankAccount accounts= new CurrentAccount(name,balance,pass,tradeLicense);
        String acNumber = addAccount(accounts);
        return acNumber;
    }

    public BankAccount findAccount(String accountNumber){
        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getAccountNumber().equals(accountNumber))
                return accounts.get(i);
        }
        return null;
    }

    void deposit(String accountNumber,double amt){
        BankAccount bnk = findAccount(accountNumber);
        if(bnk == null) JOptionPane.showMessageDialog(null,"Account Doesn't Exist");
        else bnk.deposit(amt);
    }

    void withdraw(String accountNumber,double amt,String pass) throws InsufficientBalanceException,InvalidPasswordException{
        BankAccount bnk = findAccount(accountNumber);
        if(bnk == null) JOptionPane.showMessageDialog(null,"Account Doesn't Exist");
        else if(bnk.getPassword().equals(pass)) bnk.withdraw(amt);
        else    throw new InvalidPasswordException();
    }

   public void getBalance(String accountNumber){
        BankAccount bnk = findAccount(accountNumber);// double f =((SavingsAccount)bnk).getNetBalance();
        if(bnk == null) System.out.println("Account Doesn't Exist");
       else if(bnk instanceof CurrentAccount)
            System.out.printf("Balance: %f\n",bnk.getBalance());
//polymorphism
        else System.out.printf("Balance: %f\n",((SavingsAccount)bnk).getNetBalance());
    }

    public BankAccount display(String id,String pass) throws InvalidPasswordException{
        BankAccount bnk  = findAccount(id);
        if(bnk == null){ JOptionPane.showMessageDialog(null,"Account Doesn't Exist"); return null;}
        else if(bnk.getPassword().equals(pass)) return bnk;
        else throw new InvalidPasswordException();
    }


    public BankAccount display(int i)
    {
        BankAccount bnk = accounts.get(i);
        return bnk;
    }
    public int accountSize(){
        return accounts.size();
    }
}
