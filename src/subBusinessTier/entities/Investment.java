package subBusinessTier.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Investment {

    private LocalDate dateBeggining;
    private LocalDate dateEnd;
    private double interest;
    private double amount;
    private BankAccount bankAccount;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Investment(int number, LocalDate dateBeggining, LocalDate dateEnd, double interest, double amount) {
        this.dateBeggining = dateBeggining;
        this.dateEnd = dateEnd;
        this.interest = interest;
        this.amount = amount;
        this.number = number;
    }

    public Investment() {
    }
    
    
    
    public LocalDate getDateBeggining() {
        return dateBeggining;
    }

    public void setDateBeggining(LocalDate dateBeggining) {
        this.dateBeggining = dateBeggining;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    public void addBankAccount(BankAccount bankAccount){
        this.setBankAccount(bankAccount);
        bankAccount.setInvestment(this);
        
    }
    
    
    /*public int hashCode(){
        int i = 2;
        return i;
    }*/
    
    @Override
    public String toString(){
        String str = getBankAccount().toString() + ", Investment: amount = " + getAmount() + ", interest = " + getInterest();
    return str;
    }
    
    public boolean equals(Object obj){
        boolean result = false;
        if(getNumber() == ((Investment)obj).getNumber()){
            result = true;
        }
        return result;
    }

    /*public String getTimeTheEnd(){
    return "time";
    }*/

}
