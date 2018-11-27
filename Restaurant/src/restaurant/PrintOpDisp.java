package restaurant.src.restaurant;


import logger.src.logger.Logger;


import java.util.Scanner;

public class PrintOpDisp implements Operation {

    @Override
    public void launchOp(Scanner sc, Logger logger) {
        logger.info("OUTPUT","Quit the program - quit");
        logger.info("OUTPUT","Print available operations - disp");
        logger.info("OUTPUT","Add a new product to the sale - add");
        logger.info("OUTPUT","Print all available products  - print");
        logger.info("OUTPUT","Open a client's note - open ");
        logger.info("OUTPUT","Save a sell on a client's note - sell");
        logger.info("OUTPUT","Close the note of a client - close");
        logger.info("OUTPUT","Print the accounting data - accounting\n");

    }

    @Override
    public String name() {
        return "PrintOpDisp";
    }


}
