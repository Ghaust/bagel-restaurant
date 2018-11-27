package restaurant.src.restaurant;

import logger.src.logger.*;


import java.util.HashSet;
import java.util.Scanner;



public class Checkout {
    public static final HashSet<Note> notes = new HashSet<Note>();
    public static final HashSet<Product> stock = new HashSet<Product>();
    private final Logger logger = LoggerFactory.getLogger("Checkout");
    private final HashSet<Operation> operations = new HashSet<Operation>();
    public static double total_tva;
    public static double total_money;

    public Checkout(){

        this.total_tva= 0.0;
        this.total_money = 0.0;
        operations.add(new OpenNote());
        operations.add(new CloseNote());
        operations.add(new PrintAccountingData());
        operations.add(new PrintOpDisp());
        operations.add(new PrintStock());
        operations.add(new SaveProductSell());
        operations.add(new AddNewProduct());
        stock.add(new Product("Bagels", 20, 3.5));
        stock.add(new Product("Smoothies", 30, 2.5));
        stock.add(new Product("Burgers", 10, 5.5));
        stock.add(new Product("Coffees", 100000, 5.5));
    }

    public void verifOp(String name){
        Scanner sc = new Scanner(System.in);
        for (Operation o : operations) {
            if (o.name().equals(name))
                o.launchOp(sc, this.logger);
        }
    }


    public void initProgram(){


        String saisieClient;
        Scanner sc = new Scanner(System.in);

        logger.info("OUTPUT","Welcome to your restaurant management interface young padawan !");
        logger.info("OUTPUT", "How may I help you today ? (disp for the different operations)\n");

        do{
                saisieClient = sc.nextLine();
                switch (saisieClient) {
                    case "disp":
                        verifOp("PrintOpDisp");
                        break;
                    case "print":
                        verifOp("PrintStock");
                        break;
                    case "open":
                        verifOp("OpenNote");
                        break;
                    case "add":
                        verifOp("AddNewProduct");
                        break;
                    case "close":
                        verifOp("CloseNote");
                        break;
                    case "sell":
                        verifOp("SaveProductSell");
                        break;
                    case "accounting":
                        verifOp("PrintAccountingData");
                        break;

                    default:
                        logger.info("OUTPUT", "Command not found, disp for all the cmd");
                        break;
                }
        }while(!saisieClient.equals("quit"));
        logger.info("OUTPUT", "Thank you and have a wonderful day !");


    }
}
