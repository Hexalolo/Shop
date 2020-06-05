import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TransactionTest {
    private Transaction transaction;
    private Basket basket;
    private Customer customer;
    private String paymentMethod;
    private LocalDateTime date;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        product1 = new Product("Toyota", 123.54);
        basket.addProduct(product1);
        product2 = new Product("Mazda", 75.43);
        basket.addProduct(product2);
        customer = new Customer("Oklahoma", "Tuvili street", "groove@bmail.from");
        paymentMethod = "PayPal";
        date = LocalDateTime.now();
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifBasketIsNull() {
        basket.deleteProduct(product1);
        basket.deleteProduct(product2);
        transaction = new Transaction(basket, customer, paymentMethod);

    }

    @Test
    public void ifPaymentMethodDefined() {
        String[] listOfPayments = new String[]{"By card", "PayPal", "At delivery"};
        assertTrue(Arrays.stream(listOfPayments).anyMatch(paymentMethod::equals));
    }

}