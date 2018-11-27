package restaurant.src.restaurant;

import logger.src.logger.Logger;

import java.util.Scanner;


public interface Operation {

    void launchOp(Scanner sc, Logger logger);
    String name();

}
