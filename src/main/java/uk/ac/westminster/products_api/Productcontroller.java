package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Productcontroller {

    // Tutorial 3 - Activity 2
    private ProductService productService;

    // Tutorial 7 - Activity 1 (Task 4)
    public Productcontroller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Tutorial 3 - Activity 3 (Task 9)
    //Tutorial 7: the service now throws ProductNotFoundException -> 404.
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Tutorial 3 - Activity 3 (Task 10)
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Tutorial 3 - Activity 4 (Task 13)
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Tutorial 5 - Activity 5 (Task 18)
    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }

    // Tutorial 3 - Activity 5 (Task 17)
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

}