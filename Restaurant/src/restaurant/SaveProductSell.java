package restaurant.src.restaurant;

import logger.src.logger.Logger;


import java.util.HashSet;
import java.util.Scanner;

public class SaveProductSell implements Operation{
    HashSet<Note> notes = Checkout.notes;

    @Override
    public void launchOp(Scanner sc, Logger logger) {

        logger.info("OUTPUT","Client name : ");
        String productName = "", clientName = "";
        int quantity = 0;
        try {
            clientName = sc.nextLine();
        }catch(Exception e){
            logger.error("INPUT", "Not String");
        }
        Note n = searchNote(clientName);

        if(n != null){
            logger.info("OUTPUT", "Product :");
            try {
                productName = sc.nextLine();
            }catch(Exception e){
                logger.error("INPUT", "Not String");
            }

            logger.info("OUTPUT", "Quantity :");
            try{
                quantity= sc.nextInt();
            }catch(Exception e){
                logger.error("INPUT", "Not Int");
            }

            n.addNewProduct(productName, quantity);
            decreaseStock(productName, quantity);
        }
        else
            logger.error("OUTPUT", "This client doesn't exist.");
    }

    @Override
    public String name() {
        return "SaveProductSell";
    }



    public Note searchNote(String clientName){
        for(Note n : notes){
            if(n.getNomClient().equals(clientName)){
                return n;
            }
        }
        return null;
    }

    public void decreaseStock(String productName, int qte){
        for(Product p : Checkout.stock){
            if(p.getNomProduit().equals(productName)){
                p.setQuantity(p.getQuantity() - qte);
            }
        }
    }
}
