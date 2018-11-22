package restaurant;

import java.util.HashSet;

public class Note {
    private String nomClient;
    private HashSet<Product> choixClient;
    private double total_check;

    public Note(String nomClient, HashSet<Product> choixClient) {
        this.nomClient = nomClient;
        this.choixClient = choixClient;
    }

    public void orderFood(Product selectionClient){
        this.choixClient.add(selectionClient);
    }

    public void calculateCheck(){
        double check = 0;

        for(Product p : choixClient){
            check+=p.getPrice();
        }

    }

    public String getNomClient() {
        return nomClient;
    }
}
