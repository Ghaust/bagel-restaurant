package restaurant;

import logger.LoggerFactory;

import java.util.HashSet;

public class PrintStock implements Operation {

    @Override
    public void launchOp() {
        HashSet<Note> notes = new HashSet<Note>();
        HashSet<Product> stock = new HashSet<Product>();
        Checkout c = new Checkout();

        for(Product p : stock){
            logger.info("OUTPUT",p.getNomProduit() + "-> " + p.getQuantity() + "-> " + p.getPrice() + "€");
        }

    }

    @Override
    public String name() {
        return "PrintStock";
    }

    @Override
    public String instruction() {
        return "Afficher le stock - print";
    }
}
