package restaurant.src.restaurant;

import logger.src.logger.Logger;


import java.util.Scanner;

public class PrintStock implements Operation {

    @Override
    public void launchOp(Scanner sc, Logger logger) {

        for(Product p : Checkout.stock){
            if(p.getNomProduit().equals("Coffees"))
                logger.info("OUTPUT", p.getNomProduit() + " - " + "Unlimited - " + p.getPrice() + "€");
            else
                logger.info("OUTPUT",p.getNomProduit() + " - " + p.getQuantity() + " - " + p.getPrice() + "€");
        }

    }

    @Override
    public String name() {
        return "PrintStock";
    }


}
