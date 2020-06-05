import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Item", 15.433);
    }

    @Test
    public void ifPriceHasTwoDecimalPoints(){
        double d = product.getPrice();
        String text = Double.toString(Math.abs(d));
        String decimalPlaces = text.substring(text.indexOf('.') + 1);
        assertEquals(2, decimalPlaces.length());
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifNameIsNull(){
        Product productNoName = new Product("", 13.34);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ifPriceIsZero(){
        Product productZeroPrice = new Product("Leather", 0.0);
    }

    @Test
    public void ifProductModified(){
        product.modifyProduct("Product New Name", 102.98);
        assertEquals("Product New Name", product.getName());
        assertEquals(102.98, product.getPrice(), 0.001);
    }


}