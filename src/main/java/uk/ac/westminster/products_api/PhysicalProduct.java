// Tutorial 4 - Activity 2 (Task 9)
// line 1:
// A PhysicalProduct IS-A Product because it is still an item in the catalogue with an id, a name and a price it just also gets shipped.
// line 2:
// A ShoppingCart would NOT pass this test: a cart HAS-A list of products, it is not a kind of product.

package uk.ac.westminster.products_api;

// Tutorial 4 - Activity 2 (Task 7)
public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;

    private double discountedPrice;

    // Tutorial 4 - Activity 2 (Task 8)
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        applyDiscount (0.5);
    }

    // Tutorial 5 - Activity 2 (Task 7)
    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + weightKg + "kg";
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    // Tutorial 5 - Activity 4 (Task 15)
    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    // Tutorial 5 - Activity 4 (Task 15)
    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

}
