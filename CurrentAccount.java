package sample;

public class CurrentAccount extends BankAccount {
    public String tradeLicenseNumber;

    public CurrentAccount(String name, double balance,String pass, String license){
        super(name,balance,5000,pass);
        this.tradeLicenseNumber=license;
    }

    @Override
    public String toString() {
        return  "\nAccount Type              : Current Account "+
                "\nAccount Holder Name : " + getMemberName() +
                "\nAccount Number         : " + accountNumber +
                "\nAccount Balance         : " + accountBalance+
                "\nTrade License              : " + tradeLicenseNumber ;
    }
}
