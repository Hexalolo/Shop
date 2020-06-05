public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if(name.isEmpty() || price == 0.0){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.price = limitDecimalPlaces(price, 2);

    }

    public void modifyProduct(String newName, double newPrice) {
        setName(newName);
        setPrice(newPrice);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = limitDecimalPlaces(price, 2);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    private double limitDecimalPlaces(double value, int limit) {
        if (limit < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, limit);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
