package sample;

import javax.swing.*;
import java.util.Random;

public class BankAccount {
    private String memberName; String accountNumber; double accountBalance, minimumBalance;
    private String password;
    public BankAccount(String name, double balance, double minBalance, String pass){
        this.memberName=name;
        this.accountBalance=balance;
        this.minimumBalance=minBalance;
        this.password=pass;
        Random rand = new Random();
        String num;
        num = "" + rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10)+
                rand.nextInt(10)+ rand.nextInt(10);
        accountNumber = num;
    }

    public String getMemberName(){
        return memberName;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getAccountBalance(){
        return accountBalance;
    }
    public double getMinimumBalance(){
        return minimumBalance;
    }
    public String getPassword(){return password; }

    public void setMemberName(String name){
        this.memberName= name;
    }
    public void setMinimumBalance(double minBalance){
        this.minimumBalance = minBalance;
    }
    public void setPassword(String pass) { this.password= pass; }

    void deposit(double depAmount){
        accountBalance+=depAmount;
        JOptionPane.showMessageDialog(null,"Deposit Process Successfully\nNew Balance: "+accountBalance);
    }

    void withdraw(double withAmount) throws InsufficientBalanceException{
        if (accountBalance - withAmount > minimumBalance){
            accountBalance = accountBalance - withAmount;
            JOptionPane.showMessageDialog(null,"Withdraw Process Successfully\nNew Balance: "+accountBalance);
    }
        else{ throw new InsufficientBalanceException(accountBalance-minimumBalance);}
    }

    double getBalance(){
       return accountBalance;
    }

    /*public void display(){
        System.out.printf("Name : %s; Account Number: %s; Balance:%f; ",memberName,accountNumber,accountBalance);
    }

    @Override
    public String toString() {
        return "\nAccount Holder Name : " + memberName + '\'' +
               "\nAccount Number         : " + accountNumber + '\'' +
               "\nAccount Type              : Current Account "+
               "\nAccount Balance         : " + accountBalance ;
    }*/
}


