package restaurant.src.restaurant;

import logger.src.logger.Logger;

import java.util.Scanner;

public class Quit implements Operation {


    @Override
    public void launchOp(Scanner sc, Logger logger) {
        System.exit(0);
    }

    @Override
    public String name() {
        return "Quit";
    }


}
