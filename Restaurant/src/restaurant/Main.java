package restaurant;

import java.util.HashSet;

public class Main {

    public static void main(String[] args){

        HashSet<Note> notes = new HashSet<Note>();
        HashSet<Product> stock = new HashSet<Product>();

        Checkout nouvelleCheckout = new Checkout();

        nouvelleCheckout.initProgram();

    }
}
