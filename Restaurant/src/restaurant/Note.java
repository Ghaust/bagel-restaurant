package restaurant.src.restaurant;

import java.util.HashSet;

public class Note {
    private String nomClient;
    private HashSet<Product> choixClient;
    private double total_check;

    public Note(String nomClient) {
        this.nomClient = nomClient;
        this.choixClient = new HashSet<Product>();
        this.total_check = 0;
    }


    public boolean calculateCheck(){

        if(choixClient != null) {
            for (Product p : choixClient) {
                this.total_check += p.getPrice();
            }
            return true;
        }else
            return false;
    }




    public void addNewProduct(String productName, int quantity){
         double price = 0.0;

         for(Product p : Checkout.stock){
             if(p.getNomProduit().equals(productName))
                 price = p.getPrice();
         }
        this.choixClient.add(new Product(productName, quantity, (price*quantity)));
    }

    public HashSet<Product> getChoixClient(){
        return this.choixClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public double getTotal_check() {
        return total_check;
    }
}
