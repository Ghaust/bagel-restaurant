package restaurant.src.restaurant;


import logger.src.logger.Logger;


import java.util.Scanner;

public class AddNewProduct implements Operation {

    @Override
    public void launchOp(Scanner sc, Logger logger) {
        String productName = "";
        int quantity = 0;
        Double price = 0.0;

        logger.info("OUTPUT", "Add new product to the sale");
        logger.info("OUTPUT", "Product name :");

        try {
            productName = sc.nextLine();

        } catch (Exception e) {
            logger.error("INPUT", "Not String");
        }

        try {
            logger.info("OUTPUT", "Quantity :");
             quantity = sc.nextInt();
        } catch (Exception e) {
            logger.error("INPUT", "Not Integer");
        }

        try {
            logger.info("OUTPUT", "Price :");
            price = sc.nextDouble();

        } catch (Exception e) {
            logger.error("INPUT", "Not Double");
        }

        Checkout.stock.add(new Product(productName, quantity, price));

    }



    @Override
    public String name() {
        return "AddNewProduct";
    }

}
