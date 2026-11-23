package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

// Tutorial 3 - Activity 1 (Task 2): ProductService class marked with @Service.
@Service
public class ProductService {

    // Tutorial 7 - Activity 4 (Task 15)
    private final ProductRepository repository;

    // Tutorial 7 - Activity 4 (Task 15): constructor injection, no @Autowired needed (one constructor).
    // Tutorial 7 - Activity 4 (Task 17): experiment - temporarily change the parameter type to
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // Tutorial 7 - Activity 4 (Task 16)
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        // save() assigns the id if it is missing
        return repository.save(product);
    }

    // Tutorial 7 - Activity 4 (Task 16)
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        repository.delete(id);
    }

    // Business rule (a search) stays in the service; only storage moved.
    public List<Product> findByName(String name) {
        return repository.findAll().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    // Tutorial 5 - Activity 5 (Task 17)
    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : repository.findAll()) {
            summaries.add(p.getSummary());

            if (p instanceof Discountable d) {
                d.applyDiscount(0.10);
            }
        }
        return summaries;
    }
}