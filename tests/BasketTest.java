import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasketTest {
    private Basket basket;
    private Product product;
    private Product product2;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        product = new Product("Spade", 12.59);
        product2 = new Product("Rope", 35.75);
    }

    @Test
    public void ifNewBasketIsEmpty(){
        assertEquals(0.0, basket.getTotalSum(), 0.001);
        assertTrue(basket.getArrayOfProducts().isEmpty());
    }

    @Test
    public void ifTotalSumIsPositive(){
        assertTrue(basket.getTotalSum() >= 0);
    }

    @Test
    public void ifTotalSumHasTwoDecimalPoints(){
        basket.addProduct(product);
        double d = basket.getTotalSum();
        String text = Double.toString(Math.abs(d));
        String decimalPlaces = text.substring(text.indexOf('.') + 1);
        assertEquals(2, decimalPlaces.length());
    }

    @Test
    public void ifTotalSumIsZeroWhenEmpty(){
        assertTrue(basket.isEmpty());
        assertEquals(0.0, basket.getTotalSum(), 0.001);

    }

    @Test
    public void ifProductIsAdded(){

        int quantityOfProductBefore = basket.getQuantityOfProduct(product);
        basket.addProduct(product);
        int quantityOfProductAfter = basket.getQuantityOfProduct(product);
        assertEquals(quantityOfProductBefore + 1,quantityOfProductAfter);
    }
        
    @Test
    public void ifProductIsDeleted(){
        basket.addProduct(product);
        int quantityOfProductBefore = basket.getQuantityOfProduct(product);
        basket.deleteProduct(product);
        int quantityOfProductAfter = basket.getQuantityOfProduct(product);
        assertEquals(quantityOfProductBefore - 1,quantityOfProductAfter);
    }

    @Test
    public void ifTotalSumAgrees(){
        product2 = new Product("Rope", 35.75);
        double sumOfProductPrices = 0.0;
        int listOfProductsSize = basket.getArrayOfProducts().size();
        for(int i = 0; i < listOfProductsSize; i ++){
            sumOfProductPrices = sumOfProductPrices + basket.getArrayOfProducts().get(i).getPrice();
        }
        assertEquals(basket.getTotalSum(), sumOfProductPrices, 0.001);
    }

    @Test
    public void ifNamesOfProductsAreReturned(){
        basket.addProduct(product);
        product2 = new Product("Rope", 35.75);
        basket.addProduct(product2);
        basket.addProduct(product);
        String expected = "Spade; Rope; Spade; ";
        assertEquals(expected, basket.getNamesOfProducts());
    }

    @Test
    public void ifArrayOfProductsIsReturned(){
        basket.addProduct(product);

        basket.addProduct(product2);
        basket.addProduct(product);
        ArrayList<Product> expected = new ArrayList<Product>();
        expected.add(product);
        expected.add(product2);
        expected.add(product);
        for(int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i).getName(), basket.getArrayOfProducts().get(i).getName());
            assertEquals(expected.get(i).getPrice(), basket.getArrayOfProducts().get(i).getPrice(), 0.001);
        }
    }

    @Test
    public void ifQuantityOfProductIsReturned(){
        basket.addProduct(product);
        basket.addProduct(product);
        product2 = new Product("Rope", 35.75);
        basket.addProduct(product2);
        Product product3 = new Product("Rake", 21.12);
        assertEquals(2, basket.getQuantityOfProduct(product));
        assertEquals(1,basket.getQuantityOfProduct(product2));
        assertEquals(0, basket.getQuantityOfProduct(product3));
    }

}