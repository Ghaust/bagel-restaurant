package restaurant;

import logger.Logger;
import logger.LoggerFactory;

public class PrintOpDisp implements Operation {

    @Override
    public void launchOp() {
        logger.info("OUTPUT","Quitter le programme - quit");
        logger.info("OUTPUT","Afficher les opérations disponibles - disp");
        logger.info("OUTPUT","Ajouter un produit à la vente - add");
        logger.info("OUTPUT","Afficher la liste des produits disponibles à la vente - print");
        logger.info("OUTPUT","Ouvrir la note d'un client - open ");
        logger.info("OUTPUT","Enregistrer la vente d'un produit sur la note d'un client - sell");
        logger.info("OUTPUT","Clôturer la note d'un client - close");
        logger.info("OUTPUT","Afficher les données comptables - accounting\n");

    }

    @Override
    public String name() {
        return "PrintOpDisp";
    }

    @Override
    public String instruction() {
        return "Afficher les opérations disponibles - disp";
    }

}
