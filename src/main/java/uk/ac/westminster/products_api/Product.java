package uk.ac.westminster.products_api;

public class Product {

    //Tutorial 2: Product encapsulated with private fields and getters

    private Long id;
    private String name;
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Tutorial 2: Product encapsulated with private fields and getters

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}