/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subBusinessTier;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import testdata.Data;

/**
 *
 * @author Patrycja
 */

//@Category({)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacadeTest {
    
    static Data data;
    static Facade instance;
    static Factory factory;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Facade();
        data = new Data();
        factory = new Factory();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of addClient method, of class Facade.
     */
    @Test
    public void test1AddClient() {
        System.out.println("addClient");
        for (int i = 0; i < 6; i++) {
            instance.addClient(data.clientsData1[i]);
            int number1 = instance.getClients().size();
            instance.addClient(data.clientsData1[i]);
            int number2 = instance.getClients().size();
            Client result = instance.getClients().get(number2 - 1);
            assertEquals(data.clients1[number2 - 1], result);
            assertEquals(number1, number2);
        }
    }

    /**
     * Test of addBankAccount method, of class Facade.
     */
    @Test
    public void test2AddBankAccount() {
        System.out.println("addBankAccount");
        for(int j = 0; j<3; j++){ //dla j<3 działa, dla 4 już nie, dlaczego????
            instance.addBankAccount(data.clientsDataForBankAccounts[j], data.accountsData[j]);
            int number1 = instance.getBankAccounts().size();
            instance.addBankAccount(data.clientsDataForBankAccounts[j], data.accountsData[j]);
            int number2 = instance.getBankAccounts().size();
            BankAccount result = instance.getBankAccounts().get(number2-1);
            assertEquals(data.accounts[number2-1], result);
            assertEquals(number1, number2);
            
        }
        exception.expect(IllegalFormatCodePointException.class);
        exception.expectMessage("Code point = 0x0");
        instance.addBankAccount(data.clientsDataForBankAccounts[0], data.accountsData[12]);
    }


    /**
     * Test of addInvestment method, of class Facade.
     */
   @Test
    public void test3AddInvestment() {
        System.out.println("addInvestment");
        for (int i = 1; i<3; i++){
            instance.addInvestment(data.clientsData[i+1], data.accountsData[i+5], data.investmentsData[i]);
            BankAccount accountFound = instance.searchBankAccount(factory.createBankAccount(data.accountsData[i+5]));
            assertTrue(accountFound.hasInvestment());
            assertEquals(accountFound.getInvestment(), data.investments[i-1]);
        }
    }

    /**
     * Test of addTransaction method, of class Facade.
     */
    @Test
    public void test4AddTransaction() {
        System.out.println("addTransaction");
        for (int i = 0; i<2; i++){
            instance.addTransaction(data.clientsDataForBankAccounts[i], data.accountsData[i+6] , 
                    data.clientsDataForBankAccounts[i+1], data.accountsData[i+7], data.amountsForTransaction[i]);
            Client clientFound = instance.searchClient(factory.createClient(data.clientsDataForBankAccounts[i]));
            assertEquals(clientFound.getTransactios().get(0), data.transactions[i]);    //każdy klient ma tylko jedną transakcję
        }
    }

    
}
