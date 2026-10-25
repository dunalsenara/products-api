package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Tutorial 3 - Activity 1 (Task 2): ProductService class marked with @Service.
@Service
public class ProductService {

    // Tutorial 3 - Activity 1 (Task 3): the two private fields.
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // Tutorial 4 - Activity 3 (Task 10)
    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));

        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    // Tutorial 3 - Activity 1 (Task 4): getAllProducts and addProduct
    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Tutorial 3 - Activity 3 (Task 8)
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Tutorial 3 - Activity 4 (Task 12)
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    // Tutorial 3 - Activity 5 (Task 16)
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
