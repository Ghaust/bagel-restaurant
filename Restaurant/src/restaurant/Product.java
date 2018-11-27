package restaurant.src.restaurant;

public class Product {
    private String nameProduct;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.nameProduct = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getNomProduit() {
        return this.nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}
