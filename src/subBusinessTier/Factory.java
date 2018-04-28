/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subBusinessTier;

/**
 *
 * @author Patrycja
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import subBusinessTier.entities.Investment;
import subBusinessTier.entities.SavingAccount;
import subBusinessTier.entities.Transaction;

public class Factory {
    
    public Client createClient(String data[]){
        Client client = null;
        switch(Integer.parseInt(data[0])){
            case 0:
                client = new Client();
                client.setPESEL(data[1]);
                break;
            case 1:
                client = new Client();
                client.setName(data[1]);
                client.setAdress(data[2]);
                client.setPESEL(data[3]);
                client.setPhoneNumber(data[4]);
                break;
        }
        return client;
    }
    
    public BankAccount createBankAccount(String data[]){
        BankAccount bankAccount = null;
        switch(Integer.parseInt(data[0]))
        {
            case 0:
                bankAccount = new BankAccount();
                bankAccount.setNumber(Integer.parseInt(data[1]));
                break;
            case 1:
                bankAccount = new BankAccount();
                bankAccount.setNumber(Integer.parseInt(data[1]));
                bankAccount.setBalance(Double.parseDouble(data[2]));
                break;
            case 2:
                SavingAccount bankAccount1 = new SavingAccount();
                bankAccount1.setNumber(Integer.parseInt(data[1]));
                bankAccount1.setBalance(Double.parseDouble(data[2]));
                bankAccount1.setInterest(Double.parseDouble(data[3]));
                bankAccount = bankAccount1;
                break;
        }
        
        return bankAccount; 
    }
    
    public Transaction createTransaction(Client clientSender, Client clientReceiver, BankAccount bankAccountSender, BankAccount bankAccountReceiver, double amount){
        Transaction transaction = new Transaction();
        transaction.setSender(clientSender);
        transaction.setReceiver(clientReceiver);
        transaction.setSendersAccount(bankAccountSender);
        transaction.setReceiversAccount(bankAccountReceiver);
        transaction.setAmount(amount);
        return transaction;
    }
    
    public Investment createInvestment(String data[]){
        Investment investment = new Investment();
        investment.setDateBeggining(LocalDate.parse(data[0]));
        investment.setDateEnd(LocalDate.parse(data[1]));
        investment.setInterest(Double.parseDouble(data[2]));
        investment.setAmount(Double.parseDouble(data[3]));
        return investment;
    }
    
    
}
