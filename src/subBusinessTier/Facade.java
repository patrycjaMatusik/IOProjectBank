package subBusinessTier;

import java.util.ArrayList;
import java.util.List;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import subBusinessTier.entities.Investment;

public class Facade {
    
    List<BankAccount> bankAccounts;
    List<Client> clients;
    
    public Facade(){
        bankAccounts = new ArrayList<>();
        clients = new ArrayList<>();
    }
    
    

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    
    
    public String addBankAccount(String data[], String data2[]){
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        Client foundClient;
        if((foundClient = searchClient(client))!=null){
            BankAccount bankAccount = factory.createBankAccount(data2);
        if(searchBankAccount(bankAccount)==null){
            bankAccounts.add(bankAccount);
            bankAccount.addClient(foundClient);
            return bankAccounts.toString();
        }
        }
        return null;
    }
    
    public BankAccount searchBankAccount(BankAccount bankAccount){
        int idx;
        if((idx = bankAccounts.indexOf(bankAccount)) != -1){
            return bankAccounts.get(idx);
        }
        return null;
    }
    
    public String addClient(String data[]){
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        if(searchClient(client)==null){
            clients.add(client);
            return client.toString();
        }
        return null;
    }
    
    public Client searchClient(Client client){
        int idx;
        if((idx = clients.indexOf(client))!=-1){
            return clients.get(idx);
        }
        return null;
    }
    
    
    public String addInvestment(String data[], String data1[], String data3[]){
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        Client clientFound;
        if((clientFound = searchClient(client)) != null){
                    return clientFound.addInvestment(data1, data3);
                }
        return null;
    }
  
    
    public ArrayList<String> addTransaction(String dataSenderClient[], String dataSenderBA[], String dataReceiverClient[], String dataReceiverBA[], double amount){
        Factory factory = new Factory();
        ArrayList<String> result = null;
        Client clientSender = factory.createClient(dataSenderClient);
        Client clientSenderFound;
        if((clientSenderFound = searchClient(clientSender))!=null){
                Client clientReceiver = factory.createClient(dataReceiverClient);
                Client clientReceiverFound;
                if((clientReceiverFound = searchClient(clientReceiver))!=null){
                                    result = clientSenderFound.addTransaction(dataSenderBA, dataReceiverBA, amount, clientReceiverFound);
                                }

                }
        return result;
    }
        
    
    public static void main(String[] t){
        
        Facade ap = new Facade();
        String cl1[] = {"1", "Name1", "Address1", "PESEL1", "758964523"}, dcl1[] = {"0", "PESEL1"};
        String cl2[] = {"1", "Name2", "Address2", "PESEL2", "965423586"}, dcl2[] = {"0", "PESEL2"};    
        String ba1[] = {"1", "123456", "256.25"}, dba1[] = {"0", "123456"};
        String ba2[] = {"1", "456789", "5785.35"}, dba2[] = {"0", "456789"};
        String ba3[] = {"1", "741852", "2658.23"}, dba3[] = {"0", "741852"};
        String sa1[] = {"2", "852963", "20000.00", "0.5"}, dsa1[] = {"0", "852963"};
        String in1[] = {"2018-03-12", "2018-06-12", "1.5", "20000.00"};
        
        ap.addClient(cl1);
        ap.addClient(cl1);
        ap.addClient(cl2);
        
        System.out.println(ap.clients);
        
        ap.addBankAccount(dcl1, ba1);
        ap.addBankAccount(dcl1, ba2);
        ap.addBankAccount(dcl2, ba1);
        ap.addBankAccount(dcl2, ba3);
        
        String lan = ap.getBankAccounts().toString();
        System.out.println(lan);
        
        ap.addBankAccount(dcl2, sa1);
        
        String lan1 = ap.getBankAccounts().toString(); 
        System.out.println(lan1);
        
        System.out.println(ap.addInvestment(dcl1, dba1, in1));
       
        
        System.out.println(ap.addInvestment(dcl1, dba1, in1));
        
        
        
        
        System.out.println(ap.addTransaction(dcl1, dba1, dcl2, dba3, 100.00));
        
        
        
    }
    
}
