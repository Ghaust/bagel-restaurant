package restaurant.src.restaurant;

import logger.src.logger.Logger;


import java.util.HashSet;
import java.util.Scanner;

public class CloseNote implements Operation {
    HashSet<Note> notes = Checkout.notes;
    @Override
    public void launchOp(Scanner sc, Logger logger) {

        String clientName = "";
        logger.info("OUTPUT","Client name :");
        try {
            clientName = sc.nextLine();
        }catch(Exception e){
            logger.error("INPUT", "Not String");
        }



        for(Note n : notes){
            if(!n.getNomClient().equals(clientName)){
                logger.error("OUTPUT", "This note cannot be closed because the client doesn't exist.");
            }else{
                logger.info("INPUT", "You want to close the note of " + clientName);
                n.calculateCheck();
                logger.info("INPUT", "Total check (HT) : " + n.getTotal_check());
                logger.info("INPUT", "Total check (TTC) : " + (n.getTotal_check()-n.getTotal_check()/10) );
                Checkout.total_tva = n.getTotal_check()/10;
                Checkout.total_money = n.getTotal_check()-n.getTotal_check()/10;
                break;
            }
        }

        dispListNote(logger);
    }

    @Override
    public String name() {
        return "CloseNote";
    }


    public void dispListNote(Logger logger){
        for(Note n : Checkout.notes){
            logger.info("OUTPUT", n.getNomClient() + " " + n.getTotal_check());
        }
    }
}
