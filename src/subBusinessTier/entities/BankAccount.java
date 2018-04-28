package subBusinessTier.entities;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private int number;
    private double balance;
    private Investment investment;
    private Client client;
    private List<Transaction> transactions;
    
    public BankAccount(){
        transactions = new ArrayList<>();
    }
    
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    
    public void addInvestment(Investment investment){
        setInvestment(investment);
        investment.setBankAccount(this);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public void addClient(Client client){
        this.setClient(client);
        client.addBankAccount(this);
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public List getTransactions() {
        return transactions;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }
    
    public boolean hasInvestment(){
        if(getInvestment() == null){
            return false;
        }else{
            return true;
        }
    }

    /*@Override
    public int hashCode(){
        int i = 2;
    return i;
    }*/

    @Override
    public String toString(){
        String str = "\nNumber = " + getNumber();
        str += ", Client: " + getClient().toString();
    return str;
    }
    
    public double getInterest() {
        return 0;
    }

    public void setInterest(double interest) {
    }
    
    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if(getNumber()==(((BankAccount)obj).getNumber())){
               if(getInterest()==(((BankAccount)obj).getInterest())){
                result = true;
            
            }
        }
        return result;
    }

    public boolean hasAmount(double amount){
    if (getBalance()>=amount){
        return true;
    } else {
        return false;
    }
    }

    public void addAmount(double amount){
        balance = balance + amount;
    }

    public void substractAmount(double amount){
        balance = balance - amount;
    }




}
