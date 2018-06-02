package subBusinessTier.entities;

public class SavingAccount extends BankAccount{
    
    private double interest;

    public SavingAccount() {
    }
    
    public SavingAccount(int number, double balance, double interest) {
        super(number, balance);
        this.interest = interest;
    }
    
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    
    
    public String toString(){
        String str = super.toString();
        str += ", interest = " + getInterest();
        return str;
    }
    
}
