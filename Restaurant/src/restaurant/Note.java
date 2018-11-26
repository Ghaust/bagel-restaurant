package restaurant;

import java.util.HashSet;

public class Note {
    private String nomClient;
    private HashSet<Product> choixClient;
    private double total_check;

    public Note(String nomClient) {
        this.nomClient = nomClient;
        this.choixClient = choixClient;
    }

    public void calculateCheck(){

        for(Product p : choixClient){
            this.total_check+=p.getPrice();
        }

    }

    public void addNewProduct(String productName, int quantity){
         double price = 0.0;

         for(Product p : Checkout.stock){
             if(p.getNomProduit().equals(productName))
                 price = p.getPrice();
         }
        this.choixClient.add(new Product(productName, quantity, (price*quantity)));
    }

    public String getNomClient() {
        return nomClient;
    }

    public double getTotal_check() {
        return total_check;
    }
}
