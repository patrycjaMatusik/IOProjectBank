/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subBusinessTier;

import java.util.IllegalFormatCodePointException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import subBusinessTier.entities.BankAccount;
import subBusinessTier.entities.Client;
import subBusinessTier.entities.Investment;
import subBusinessTier.entities.Transaction;
import testdata.Data;

/**
 *
 * @author Patrycja
 */

//@Category({Test_Control.clss})
public class FactoryTest {
    
    static Data data;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    
    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }
    
    /**
     * Test of createClient method, of class Factory.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        Factory instance = new Factory();
        for (int i = 0; i<5; i++){
        Client result = instance.createClient(data.clientsData[i]);
        assertEquals(data.clients[i], result);
        }
    }

    /**
     * Test of createBankAccount method, of class Factory.
     */
    @Test
    public void testCreateBankAccount() {
        System.out.println("createBankAccount");
        Factory instance = new Factory();
        for(int i = 0; i<6; i++){
        BankAccount result = instance.createBankAccount(data.accountsData[i]);
       assertEquals(data.accounts[i], result);
    }
        exception.expect(IllegalFormatCodePointException.class);
        exception.expectMessage("Code point = 0x0");
        instance.createBankAccount(data.accountsData[12]);
    }

    /**
     * Test of createTransaction method, of class Factory.
     */
    
    @Test
    public void testCreateTransaction() {
        System.out.println("createTransaction");
        Factory instance = new Factory();
       for(int i = 0; i<2; i++){
        Transaction result = instance.createTransaction(data.clientsForTransaction[i], data.clientsForTransaction[i+1], data.accountsForTransaction[i], data.accountsForTransaction[i+1], data.amountsForTransaction[i]);
        assertEquals(data.transactions[i], result);
    }
    }

    /**
     * Test of createInvestment method, of class Factory.
     */
    @Test
    public void testCreateInvestment() {
        System.out.println("createInvestment");
        Factory instance = new Factory();
        for(int i = 0; i<2; i++){
        Investment result = instance.createInvestment(data.investmentsData[i]);
        assertEquals(data.investments[i], result);
        }
    }
    
}
