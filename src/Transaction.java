import java.time.LocalDateTime;

public class Transaction {
    private Basket basket;
    private Customer customer;
    private String paymentMethod;
    private LocalDateTime date;

    public Transaction(Basket basket, Customer customer, String paymentMethod) {
        if(basket.getTotalSum() == 0.0 || basket.getArrayOfProducts().isEmpty()){
            throw new IllegalArgumentException();
        }

        this.basket = basket;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        date = LocalDateTime.now();
    }

    public Basket getBasket() {
        return basket;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
