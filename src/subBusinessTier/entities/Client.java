package subBusinessTier.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import subBusinessTier.Factory;

public class Client {


    private String name;
    private String PESEL;
    private String adress;
    private String phoneNumber;
    private List<BankAccount> bankAccounts;
    private List<Transaction> transactions;
    
    public Client(){
        bankAccounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public Client(String name, String adress, String PESEL, String phoneNumber) {
        this();
        this.name = name;
        this.PESEL = PESEL;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
    
    
    
    public BankAccount searchAccount(BankAccount bankAccount){
        int idx;
        if((idx = bankAccounts.indexOf(bankAccount)) != -1){
            return bankAccounts.get(idx);
        }
        return null;
    }
    
    public ArrayList<String> gettransactions() {
        ArrayList<String> transactions1 = new ArrayList<>();
        Iterator<Transaction> help = transactions.iterator();
        while (help.hasNext()) {
            Transaction next = help.next();
            transactions1.add(next.toString());
        }
        return transactions1;
    }
    
    public ArrayList<String> addTransaction(String[] dataSenderBA, String[] dataReceiverBA, double amount, Client clientReceiver){
        Factory factory = new Factory();
        BankAccount bankAccount = factory.createBankAccount(dataSenderBA);
        BankAccount bankAccountSender;
        if((bankAccountSender = this.searchAccount(bankAccount)) != null){
            BankAccount bankAccount1 = factory.createBankAccount(dataReceiverBA);
            BankAccount bankAccountReceiver;
            if((bankAccountReceiver = clientReceiver.searchAccount(bankAccount1)) != null){
                if(bankAccountSender.hasAmount(amount)){
                    Transaction transaction = factory.createTransaction(this, clientReceiver, bankAccountSender, bankAccountReceiver, amount);
                    transaction.setState(true);
                    transactions.add(transaction);
                    bankAccountSender.substractAmount(amount);
                    bankAccountReceiver.addAmount(amount);
                    bankAccountSender.addTransaction(transaction);
                }
            }
        }
        return gettransactions();
    }
    
    public String addInvestment(String[] dataBA, String[] dataInvestment){
        Factory factory = new Factory();
        BankAccount bankAccount = factory.createBankAccount(dataBA);
        BankAccount bankAccountFound;
        if((bankAccountFound = this.searchAccount(bankAccount)) != null){
            if(bankAccountFound.hasInvestment() == false){
            Investment investment = factory.createInvestment(dataInvestment);
            bankAccountFound.addInvestment(investment);
            return investment.toString();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getAdress() {
        return adress;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    
    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
    
    public void addBankAccount(BankAccount bankAccount){
        this.bankAccounts.add(bankAccount);
    }

    public List<Transaction> getTransactios() {
        return transactions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setTransactios(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /*public int hashCode(){
        int i = 2;
        return i;
    }*/
    
    @Override
    public String toString(){
        String str = "\nname = " + getName();
        str += ", PESEL = " + getPESEL();
    return str;
    }
    
    @Override
    public boolean equals(Object obj){
        boolean result = false;
        if(getPESEL().equals(((Client)obj).getPESEL())){
            result = true;
        }
        return result;
    }
    
}
