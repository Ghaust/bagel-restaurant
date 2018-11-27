package restaurant.src.restaurant;

import logger.src.logger.Logger;

import java.util.Scanner;

public class PrintAccountingData implements Operation{
    @Override
    public void launchOp(Scanner sc, Logger logger) {
        logger.info("OUTPUT", "Total Money : " + Checkout.total_money + "€");
        logger.info("OUTPUT", "Total TVA : " + Checkout.total_tva + "€");
    }

    @Override
    public String name() {
        return "PrintAccountingData";
    }



}
