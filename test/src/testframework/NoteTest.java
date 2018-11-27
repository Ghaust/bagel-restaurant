package test.src.testframework;

import logger.src.logger.*;

import restaurant.src.restaurant.*;

import static java.lang.System.currentTimeMillis;

/**une ligne par test contenant : nom de la classe . nom de la méthode : statut (OK ou KO) durée (en millisecondes)
 une ligne résumant le tout: pourcentage de réussite (nombre de test OK / nombre total) durée totale (en millisecondes)*/

public class NoteTest {

    private static Logger logger = LoggerFactory.getLogger("NoteTest");
    private static Note note = new Note("Test");
    //private static Checkout checkout = new Checkout();

    public static void calculateCheckTest() throws AssertionError {
        note.addNewProduct("Bagels", 2);
        if(!note.calculateCheck()){
            throw new AssertionError("Note.calculateCheck.status(KO)." + currentTimeMillis());
        }else
            logger.info("OUTPUT", "Note.calculateCheck.status(OK)" + currentTimeMillis());
    }

    public static void addNewProductTest(){
        note.addNewProduct("Test", 200);
        boolean isFree = true;

        for(Product p : note.getChoixClient()){
            if(p.getNomProduit().equals("Test")){
                isFree = false;
            }
        }

        if(isFree)
            throw new AssertionError("Note.addNewProductTest.status(KO)." + currentTimeMillis());
        else
            logger.info("OUTPUT", "Note.addNewProductTest.status(OK)" + currentTimeMillis());
    }

}
