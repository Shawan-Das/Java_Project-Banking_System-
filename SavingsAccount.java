package sample;

import javax.swing.*;

public class SavingsAccount extends BankAccount{
    private double interest = 0.05, maxWithLimit;

    public SavingsAccount(String name, double balance,String pass, double limit){
        super(name,balance,2000,pass);
        this.maxWithLimit=limit;
    }

    private double calculateInterest(){
        return interest*accountBalance;
    }

    double getNetBalance(){
        return accountBalance+calculateInterest();
    }
@Override
    void withdraw(double amt) throws InsufficientBalanceException{
        if(amt<=maxWithLimit)
            super.withdraw(amt);
        else {
            throw new InsufficientBalanceException(maxWithLimit);
        }
    }

    public double getMaxLimit(){
        return maxWithLimit;
    }

    //@Override
   /*public void display(){
        super.display();
        System.out.printf("Interest: %f; Max Withdraw Limit: %f\n",
                calculateInterest(),maxWithLimit);
    }*/

    @Override
    public String toString() {
        return  "\nAccount Type              : Savings Account" +
                "\nAccount Holder Name : " + getMemberName() +
                "\nAccount Number         : " + accountNumber +
                "\nAccount Balance          : " + accountBalance +
                "\nInterest                        : " + calculateInterest() +
                "\nMaximum Withdraw Limit : " + maxWithLimit ;
    }
}
