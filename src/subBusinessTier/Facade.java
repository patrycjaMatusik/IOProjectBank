package subBusinessTier;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import subBusinessTier.entities.Investment;

public class Facade {
    
    public static Locale currentLocale;
    public static ResourceBundle messages;
    
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
            return messages.getString("ba_done");
        }
        return messages.getString("ba_failed_BAExists");
        }
        return messages.getString("ba_failed_noClient");
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
            return messages.getString("cl_done");
        }
        return messages.getString("cl_failed");
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
                String result = clientFound.addInvestment(data1, data3);
                return messages.getString(result);
                
        }
        return messages.getString("in_failed_noClient");
    }
  
    
    public String addTransaction(String dataSenderClient[], String dataSenderBA[], String dataReceiverClient[], String dataReceiverBA[], double amount){
        Factory factory = new Factory();
        Client clientSender = factory.createClient(dataSenderClient);
        Client clientSenderFound;
        if((clientSenderFound = searchClient(clientSender))!=null){
                Client clientReceiver = factory.createClient(dataReceiverClient);
                Client clientReceiverFound;
                if((clientReceiverFound = searchClient(clientReceiver))!=null){
                                    String result = clientSenderFound.addTransaction(dataSenderBA, dataReceiverBA, amount, clientReceiverFound);
                                    return messages.getString(result);
                                }
                }
        return messages.getString("tr_failed_noClient");
    }
        
    
    public static void main(String[] t){
        
        String language;
        String country;

        if (t.length != 2) {
            language = new String("en");
            country = new String("US");
        } else {
            language = new String(t[0]);
            country = new String(t[1]);
        }

        currentLocale = new Locale(language, country);

        messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
        
        Facade ap = new Facade();
        String cl1[] = {"1", "Name1", "Address1", "PESEL1", "758964523"}, dcl1[] = {"0", "PESEL1"};
        String cl2[] = {"1", "Name2", "Address2", "PESEL2", "965423586"}, dcl2[] = {"0", "PESEL2"};    
        String ba1[] = {"1", "123456", "256.25"}, dba1[] = {"0", "123456"};
        String ba2[] = {"1", "456789", "5785.35"}, dba2[] = {"0", "456789"};
        String ba3[] = {"1", "741852", "2658.23"}, dba3[] = {"0", "741852"};
        String sa1[] = {"2", "852963", "20000.00", "0.5"}, dsa1[] = {"0", "852963"};
        String in1[] = {"2018-03-12", "2018-06-12", "1.5", "20000.00"};
        
        System.out.println(ap.addClient(cl1));
        System.out.println(ap.addClient(cl1));
        System.out.println(ap.addClient(cl2));
        
        
        System.out.println(ap.addBankAccount(dcl1, ba1));
        System.out.println(ap.addBankAccount(dcl1, ba2));
        System.out.println(ap.addBankAccount(dcl2, ba1));
        System.out.println(ap.addBankAccount(dcl2, ba3));
        
        //String lan = ap.getBankAccounts().toString();
        //System.out.println(lan);
        
        System.out.println(ap.addBankAccount(dcl2, sa1));
        
        //String lan1 = ap.getBankAccounts().toString(); 
        //System.out.println(lan1);
        
        System.out.println(ap.addInvestment(dcl1, dba1, in1));
       
        
        System.out.println(ap.addInvestment(dcl1, dba1, in1));
        
        System.out.println(ap.addTransaction(dcl1, dba1, dcl2, dba3, 100.00));
   
    }
    
}
