package restaurant.src.restaurant;

import logger.src.logger.Logger;


import java.util.HashSet;
import java.util.Scanner;

public class OpenNote implements Operation {
    HashSet<Note> notes = Checkout.notes;
    @Override
    public void launchOp(Scanner sc, Logger logger) {

        logger.info("OUTPUT","Client name : ");
        String clientName = sc.nextLine();

        boolean isFree = true;

        for(Note n : notes){
            if(!n.getNomClient().equals(clientName)){
                logger.info("OUTPUT", "This note already exists.");
                isFree = false;
                break;
            }
        }

        if(isFree == true){
            logger.info("INPUT", "New note created for " + clientName);
            this.notes.add(new Note(clientName));

           dispListNote(logger);
        }

    }

    @Override
    public String name() {
        return "OpenNote";
    }

    public void dispListNote(Logger logger){
        logger.info("OUTPUT", "List of notes :");
        for(Note n : notes){
            logger.info("OUTPUT", n.getNomClient());
        }
    }
}
