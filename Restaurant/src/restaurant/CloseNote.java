package restaurant;

import java.util.HashSet;
import java.util.Scanner;

public class CloseNote implements Operation {
    HashSet<Note> notes = Checkout.notes;
    @Override
    public void launchOp() {
        logger.log("Veuillez saisir le nom du client svp !");
        Scanner sc = new Scanner(System.in);
        String clientName = sc.nextLine();

        boolean nonUse = false;

        for(Note n : notes){
            if(!n.getNomClient().equals(clientName)){
               nonUse = false;
               break;
            }
            logger.info("OUTPUT", "Vous souhaitez fermer la note de " + clientName);
            n.calculateCheck();
            logger.info("OUTPUT", "Montant total (HT) : " + n.getTotal_check());
            logger.info("OUTPUT", "Montant (TTC) : " + (n.getTotal_check()-n.getTotal_check()/10) );
            Checkout.total_tva = n.getTotal_check()/10;
            Checkout.total_money = n.getTotal_check()-n.getTotal_check()/10;
        }

        if(nonUse == false)
            logger.error("OUTPUT", "Cette note ne peut pas être fermée car elle n'existe pas.");
    }

    @Override
    public String name() {
        return "CloseNote";
    }

    @Override
    public String instruction() {
        return "Fermer la note d'un client - close";
    }

}
