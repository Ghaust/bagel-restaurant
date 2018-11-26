package restaurant;

import java.util.HashSet;
import java.util.Scanner;

public class SaveProductSell implements Operation{
    HashSet<Note> notes = Checkout.notes;
    @Override
    public void launchOp() {
        Scanner sc = new Scanner(System.in);
        logger.log("Nom du client : ");
        String clientName = sc.nextLine();

        Note n = searchNote(clientName);

        if(n != null){
            logger.info("OUTPUT", "Nom du produit :");
            String productName = sc.nextLine();
            logger.info("OUTPUT", "Quantité souhaitée :");
            int quantity= sc.nextInt();

            n.addNewProduct(productName, quantity);
            decreaseStock(productName, quantity);
        }
        else
            logger.error("OUTPUT", "Ce client n'existe pas");
    }

    @Override
    public String name() {
        return "SaveProductSell";
    }

    @Override
    public String instruction() {
        return "Enregistrer la vente d'un produit - save";
    }

    public Note searchNote(String clientName){
        boolean isUse = false;
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
