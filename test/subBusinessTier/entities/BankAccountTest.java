/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subBusinessTier.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import testdata.Data;

/**
 *
 * @author Patrycja
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class BankAccountTest {
    
    static Data data;
    static BankAccount bankAccount;
    
    @Parameterized.Parameter
    public int number1;
    
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data1 = new Object[][]{{0}, {1}, {2}, {3}, {4}, {5}};
        return Arrays.asList(data1);
    }
    
    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bankAccount = data.accounts[number1];
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTransaction method, of class BankAccount.
     */
    @Test
    public void testAddTransaction() {
        System.out.println("addTransaction");
       for (int i = 0; i<data.transactions.length; i++){
           bankAccount.addTransaction(data.transactions[i]);
           assertEquals(data.transactions[i], bankAccount.getTransactions().get(i));
       }
    }

    /**
     * Test of addInvestment method, of class BankAccount.
     */
    @Test
    public void testAddInvestment() {
        System.out.println("addInvestment");
           bankAccount.addInvestment(data.investments[number1]);
           assertEquals(data.investments[number1], bankAccount.getInvestment());
    }

    
    /**
     * Test of addClient method, of class BankAccount.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        bankAccount.addClient(data.clients[number1]);
        assertEquals(data.clients[number1], bankAccount.getClient());
    }
    

    /**
     * Test of equals method, of class BankAccount.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        for(int j = number1; j<6; j++){
            if(number1 == j){
                assertTrue(data.accounts[number1].equals(data.accounts[j]));
            }else{
                assertFalse(data.accounts[number1].equals(data.accounts[j]));
            }
        }
    }


    /**
        * Test of addAmount method, of class BankAccount.
     */
    @Test
    public void testAddAmount() {
        System.out.println("addAmount");
        double oldAmount = bankAccount.getBalance();
        double amountToAdd = 100.00;
        bankAccount.addAmount(amountToAdd);
        assertTrue(bankAccount.getBalance() == (oldAmount + amountToAdd));
    }

    /**
     * Test of substractAmount method, of class BankAccount.
     */
    @Test
    public void testSubstractAmount() {
        System.out.println("substractAmount");
        double oldAmount = bankAccount.getBalance();
        double amountToAdd = 100.00;
        bankAccount.substractAmount(amountToAdd);
        assertTrue(bankAccount.getBalance() == (oldAmount - amountToAdd));
    }
    
}
