// Tutorial 4 - Activity 2 (Task 9)
// line 1:
// A PhysicalProduct IS-A Product because it is still an item in the catalogue with an id, a name and a price it just also gets shipped.
// line 2:
// A ShoppingCart would NOT pass this test: a cart HAS-A list of products, it is not a kind of product.

package uk.ac.westminster.products_api;

// Tutorial 4 - Activity 2 (Task 7)
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    // Tutorial 4 - Activity 2 (Task 8)
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

}
