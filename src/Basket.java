import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> listOfProducts;

    public Basket() {
        listOfProducts = new ArrayList<Product>();
    }

    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public void deleteProduct(Product product){
        listOfProducts.remove(product);
    }

    public double getTotalSum() {
        double totalSum = 0.00;
        for(int i = 0; i < listOfProducts.size(); i++){
            totalSum = totalSum + listOfProducts.get(i).getPrice();
        }
        return totalSum;
    }

    public boolean isEmpty(){
        boolean isEmpty = false;
        if(listOfProducts.size() == 0){
            isEmpty = true;
        }
        return isEmpty;
    }

    public String getNamesOfProducts(){
        String text = new String();

        for(int i = 0; i < listOfProducts.size(); i++){
            text = text.concat(listOfProducts.get(i).getName()+"; ");
        }
        return text;
    }

    public ArrayList<Product> getArrayOfProducts(){
        return listOfProducts;
    }

    public int getQuantityOfProduct(Product product){
        int quantity = 0;
        if(listOfProducts.contains(product)){
            for(int i = 0; i< listOfProducts.size(); i++){
                if(listOfProducts.get(i).equals(product)){
                    quantity++;
                }
            }
        }
        return quantity;
    }


}
