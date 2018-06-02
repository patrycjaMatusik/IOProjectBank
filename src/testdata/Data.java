/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.time.LocalDate;
import java.time.Month;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import subBusinessTier.entities.Investment;
import subBusinessTier.entities.SavingAccount;
import subBusinessTier.entities.Transaction;

/**
 *
 * @author Patrycja
 */
public class Data {
    
    public String[][] clientsData = {{"1", "Name1", "Address1", "PESEL1", "758964523"}, {"1", "Name2", "Address2", "PESEL2", "965423586"}, {"0", "PESEL1"}, {"0", "PESEL2"}, {"0", "PESEL3"}};
    public String[][] clientsData1 = {{"1", "Name1", "Address1", "PESEL1", "758964523"}, {"1", "Name2", "Address2", "PESEL2", "965423586"}, {"1", "Name3", "Address3", "PESEL3", "758564523"}, {"1", "Name4", "Address4", "PESEL4", "965423586"}, {"1", "Name5", "Address5", "PESEL5", "758966523"}, {"1", "Name6", "Address6", "PESEL6", "978423586"}};

    public String[][] clientsDataForBankAccounts = {{"0", "PESEL1"}, {"0", "PESEL2"}, {"0", "PESEL1"}, {"0", "PESEL2"}, {"0", "PESEL1"}, {"0", "PESEL2"}};
    
    public Client[] clients = {new Client("Name1", "PESEL1", "Address1", "758964523"), new Client("Name2", "PESEL2", "Address2", "965423586"), new Client("Name1", "PESEL1", "Address1", "758964523"),
                    new Client("Name2", "PESEL2", "Address2", "965423586"), new Client("Name3", "PESEL3", "Address3", "758966545"), new Client("Name4", "PESEL4", "Address4", "756942356")};
    public Client[] clients1 = {new Client("Name1", "Address1","PESEL1", "758964523"), new Client("Name2", "Address2", "PESEL2", "965423586"), new Client("Name3", "Address3", "PESEL3", "758564523"), new Client("Name4", "Address4", "PESEL4", "965423586"), new Client("Name5", "Address5", "PESEL5", "758966523"), new Client("Name6", "Address6", "PESEL6", "978423586")};

    public String[][] accountsData = {{"1", "123456", "256.25"}, {"1", "456789", "5785.35"}, {"1", "741852", "2658.23"}, {"2", "852963", "20000.00", "0.5"},
    {"2", "965845", "25000.00", "0.5"}, {"2", "325478", "10000.00", "0.5"}, 
    
    {"0", "123456"}, {"0", "456789"}, {"0", "741852"}, 
    {"0", "852963"}, {"0", "568845"}, {"0", "325478"},
    
    {"3", "578964", "365.05", "0.2"}};
    
    public BankAccount accounts[] = {
        new BankAccount(123456, 56.25), new BankAccount(456789, 5785.35), new BankAccount(741852, 2658.23), 
        new SavingAccount(852963, 20000.00, 0.5), new SavingAccount(965845,25000.00,0.5), new SavingAccount(325478,10000.00,0.5)
    };
    
    public String[][] investmentsData = {{"2018-03-12", "2018-06-12", "1.5", "20000.00"}, {"2018-03-25", "2018-07-12", "1.5", "10000.00"}};
    public LocalDate[] dates = {LocalDate.of(2018, Month.MARCH, 12), LocalDate.of(2018, Month.JUNE, 12), LocalDate.of(2018, Month.MARCH, 25), LocalDate.of(2018, Month.JULY, 12)};
    public Investment[] investments = {new Investment(1, dates[0], dates[1], 1.5, 20000.00), new Investment(2, dates[2], dates[3], 1.5, 10000.00), new Investment(1, dates[0], dates[1], 1.5, 20000.00), new Investment(2, dates[2], dates[3], 1.5, 10000.00), new Investment(1, dates[0], dates[1], 1.5, 20000.00), new Investment(2, dates[2], dates[3], 1.5, 10000.00) };
        
    public Client[] clientsForTransaction = {new Client("Name1", "Address1", "PESEL1", "758964523"), new Client("Name2", "Address2", "PESEL2", "965423586"), new Client("Name3", "Address3", "PESEL3", "965683586")};
    public BankAccount[] accountsForTransaction = {new BankAccount(123456,256.25, clientsForTransaction[0]), new BankAccount(741852,2658.23, clientsForTransaction[1]), new BankAccount(741852,2658.23, clientsForTransaction[2])};
    public double[] amountsForTransaction = {100.00, 200.00};
    public Transaction[] transactions = {new Transaction(1, amountsForTransaction[0], clientsForTransaction[0], clientsForTransaction[1], accountsForTransaction[0], accountsForTransaction[1]), new Transaction(2, amountsForTransaction[1], clientsForTransaction[1], clientsForTransaction[2], accountsForTransaction[1], accountsForTransaction[2])};
    
}
