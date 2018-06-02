package subBusinessTier.entities;

import java.time.LocalDate;


public class Transaction {

    private double amount;
    private LocalDate date;
    private boolean state;
    private BankAccount sendersAccount;
    private BankAccount receiversAccount;
    private Client sender;
    private Client receiver;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public Transaction(){
        date = LocalDate.now();
        state = false;
    }

    public Transaction(int number, double amount, Client sender, Client receiver, BankAccount sendersAccount, BankAccount receiversAccount) {
        this();
        this.number = number;
        this.amount = amount;
        this.sendersAccount = sendersAccount;
        this.receiversAccount = receiversAccount;
        this.sender = sender;
        this.receiver = receiver;
    }
    
    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    

    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BankAccount getSendersAccount() {
        return sendersAccount;
    }

    public void setSendersAccount(BankAccount sendersAccount) {
        this.sendersAccount = sendersAccount;
    }

    public BankAccount getReceiversAccount() {
        return receiversAccount;
    }

    public void setReceiversAccount(BankAccount receiversAccount) {
        this.receiversAccount = receiversAccount;
    }

   

    

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    /*public int hashCode(){
        int i = 2;
        return i;
    }*/
    
    @Override
    public String toString(){
        String str = "\nSender's data: " + getSendersAccount().toString();
        str += "\nReceiver's data: " + getReceiversAccount().toString();
        str += "\namount: " + getAmount();
    return str;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if(getNumber() == ((Transaction)obj).getNumber()){
                        result = true;
                    }
        return result;
    }
    

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    

}
