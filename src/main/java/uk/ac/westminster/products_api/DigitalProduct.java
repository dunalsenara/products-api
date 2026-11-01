package uk.ac.westminster.products_api;

// Tutorial 4 - Activity 1 (Task 3)
public class DigitalProduct extends Product implements Discountable {

    private String downloadUrl;
    private double fileSizeMB;

    private double discountedPrice;

    // Tutorial 4 - Activity 1 (Task 5)
    public DigitalProduct() {
    }

    // Tutorial 4 - Activity 1 (Task 4)
    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
        applyDiscount (0.5);
    }

    // Tutorial 5 - Activity 1 (Task 4): override of getSummary().
    @Override
    public String getSummary() {
        return "Digital: " + getName() + " | Download: " + downloadUrl;
    }

    // Tutorial 4 - Activity 1 (Task 5)
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1 - rate);

    }
    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
