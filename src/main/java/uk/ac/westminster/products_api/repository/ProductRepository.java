package uk.ac.westminster.products_api.repository;

import uk.ac.westminster.products_api.Product;

import java.util.List;
import java.util.Optional;

// Tutorial 7 - Activity 2 (Tasks 7-8)
public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void delete(Long id);

    // Tutorial 7 - Activity 2 (Task 9)
    // private List<Product> store = new ArrayList<>();
}
