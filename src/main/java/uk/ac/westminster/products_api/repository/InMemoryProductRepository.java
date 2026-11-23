package uk.ac.westminster.products_api.repository;

import org.springframework.stereotype.Repository;
import uk.ac.westminster.products_api.DigitalProduct;
import uk.ac.westminster.products_api.PhysicalProduct;
import uk.ac.westminster.products_api.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Tutorial 7 - Activity 3 (Task 10)
// Tutorial 7 - Activity 5 (Task 20): to demo the ambiguity error, add a second @Repository class
@Repository
public class InMemoryProductRepository implements ProductRepository {

    // Tutorial 7 - Activity 3 (Task 11)
    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    // Tutorial 7 - Activity 3 (Task 14)
    public InMemoryProductRepository() {
        save(new DigitalProduct(null, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        save(new PhysicalProduct(null, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    // Tutorial 7 - Activity 3 (Task 12)
    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        store.put(product.getId(), product);
        return product;
    }

    // Tutorial 7 - Activity 3 (Task 13)
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    // Tutorial 7 - Activity 3 (Task 13)
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // Tutorial 7 - Activity 3 (Task 13)
    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}