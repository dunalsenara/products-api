package uk.ac.westminster.products_api;

// Tutorial 4 - Activity 1 (Task 3)
public class DigitalProduct extends Product {

    private String downloadUrl;
    private double fileSizeMB;

    // Tutorial 4 - Activity 1 (Task 5)
    public DigitalProduct() {
    }

    // Tutorial 4 - Activity 1 (Task 4)
    public DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    // Tutorial 4 - Activity 1 (Task 5)
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }
}
