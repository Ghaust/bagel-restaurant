package restaurant;


import java.util.Scanner;

public class AddNewProduct implements Operation {
    @Override
    public void launchOp() {

        logger.log("Ajouter un nouveau produit à la vente");
        Scanner sc = new Scanner(System.in);

        logger.log("Nom du produit :");
        String productName = sc.nextLine();

        logger.log("Quantité :");
        int quantity = sc.nextInt();

        logger.log("Prix à l'unité :");
        Double price = sc.nextDouble();

        Checkout.stock.add(new Product(productName, quantity, price));
    }

    @Override
    public String name() {
        return "AddNewProduct";
    }

    @Override
    public String instruction() {
        return "Ajouter un nouveau produit à la vente - add";
    }
}
