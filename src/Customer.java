import java.util.ArrayList;

import static java.lang.Math.*;

public class Customer {
    private int id;
    private String city;
    private String street;
    private String email;
    private ArrayList<Transaction> listOfTransactions;

    public Customer(String city, String street, String email) {
        this.city = city;
        this.street = street;
        this.email = email;
        id = (int) Math.round(Math.random()*100000);
        listOfTransactions = new ArrayList<Transaction>();
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void addTransaction(Transaction transaction){
        if(city.isEmpty() || street.isEmpty() || email.isEmpty()){
            throw new IllegalArgumentException();
        }
        listOfTransactions.add(transaction);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
