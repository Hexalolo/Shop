import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;
    private String city;
    private String street;
    private String email;
    private Transaction transaction3;

    @Before
    public void setUp() throws Exception {
        city = "Sydney";
        street = "Polanski street";
        email = "client@mail.com";
        customer = new Customer(city, street, email);
        fillListOfTransactions();
    }

    public void fillListOfTransactions() {
        Product product1 = new Product("car", 78.90);
        Product product2 = new Product("bed", 64.32);
        Basket basket1 = new Basket();
        basket1.addProduct(product1);
        Transaction transaction1 = new Transaction(basket1, customer, "By card");
        customer.getListOfTransactions().add(transaction1);
        Basket basket2 = new Basket();
        basket2.addProduct(product1);
        basket2.addProduct(product2);
        basket2.addProduct(product1);
        Transaction transaction2 = new Transaction(basket2, customer,"PayPal");
        customer.getListOfTransactions().add(transaction2);
        Basket basket3 = new Basket();
        basket3.addProduct(product2);
        transaction3 = new Transaction(basket3, customer, "By card");
    }


    @Test
    public void ifListOfTransactionsIsReturned(){
        ArrayList list = new ArrayList();
        list = customer.getListOfTransactions();
        assertFalse(list.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifCustomerEmailIsEmpty(){
        customer.setEmail("");
        customer.addTransaction(transaction3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifCustomerCityIsEmpty(){
        customer.setCity("");
        customer.addTransaction(transaction3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifCustomerStreetIsEmpty(){
        customer.setStreet("");
        customer.addTransaction(transaction3);
    }

    @Test
    public void ifTransactionIsAdded(){
        int numberOfTransactions = customer.getListOfTransactions().size();
        customer.addTransaction(transaction3);
        String actualProductName = customer.getListOfTransactions().get(2).getBasket().getArrayOfProducts().get(0).getName();
        assertEquals(numberOfTransactions + 1, customer.getListOfTransactions().size());
        assertEquals("bed", actualProductName);
    }

}