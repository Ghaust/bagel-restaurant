package restaurant;

import java.util.HashSet;
import java.util.Scanner;

public class OpenNote implements Operation {
    HashSet<Note> notes = Checkout.notes;
    @Override
    public void launchOp() {
        logger.log("Veuillez saisir le nom du client svp !");
        Scanner sc = new Scanner(System.in);
        String clientName = sc.nextLine();

        boolean nonUse = false;

        for(Note n : notes){
            if(n.getNomClient().equals(clientName)){
                logger.log("Cette note existe déjà.");
                nonUse = false;
                break;
            }
        }

        if(nonUse != false){
            this.notes.add(new Note(clientName));
            logger.info("OUTPUT", "Nouvelle note créée pour " + clientName);
        }

    }

    @Override
    public String name() {
        return "OpenNote";
    }

    @Override
    public String instruction() {
        return "Ouvrir la note d'un client - open";
    }
}
