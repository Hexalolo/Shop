import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

    public static void main(String[] args){
        System.out.println("Helo world");

        Basket mybasket = new Basket();
        Product blouse = new Product("Blouse", 57.901);
        Product trousers = new Product("Trousers", 12.55);
        Product socks = new Product("Socks", 5);

        mybasket.addProduct(blouse);
        mybasket.addProduct(trousers);
        mybasket.addProduct(blouse);
        mybasket.addProduct(socks);
        mybasket.addProduct(blouse);
        System.out.println(mybasket.getTotalSum());



    }
}
