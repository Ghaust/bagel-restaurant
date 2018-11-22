package restaurant;

import java.util.HashSet;
import java.util.Scanner;


public class Checkout {
    private HashSet<Note> notes; //base de données contenant toutes les notes des clients
    private HashSet<Product> stock;
    //private final Logger logger = LoggerFactory.getLogger("restaurant.Checkout");
    private final HashSet<Operation> operations = new HashSet<>();
    private double total_tva;
    private double total_money;

    public Checkout(double totalTVA, double totalMoney, HashSet<Note> notes, HashSet<Product> stock){

        this.notes = notes;
        this.stock = stock;
        this.total_tva= totalTVA;
        this.total_money = totalMoney;

    }

    public void addNewNote(Note newNote){
        this.notes.add(newNote);
    }

    public void addNewProduct(Product newProduct){
        this.stock.add(newProduct);
    }

    public void deleteProductByName(String name){
        for(Product p : stock){
            if(p.getNomProduit() == name)
                notes.remove(p);
        }
    }


    public void addMoney(double priceHT){
        this.total_tva += priceHT/10;
        this.total_money += priceHT - (priceHT/10);
    }


    public void initProgram(){
        this.stock.add(new Product("Bagels", 20, 3.5));
        this.stock.add(new Product("Smoothies", 30, 2.5));
        this.stock.add(new Product("Burgers", 10, 5.5));
        this.stock.add(new Product("Cafés", 100000, 5.5));

        String saisieClient = " ";
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Bienvenue sur l'interface de gestion de votre restaurant");
            saisieClient = sc.nextLine();



        }while(saisieClient.equals("q"));
    }
}
