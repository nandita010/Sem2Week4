package ie.atu.week1.sem2week4.controller;

import ie.atu.week1.sem2week4.model.Product;
import ie.atu.week1.sem2week4.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @Valid @RequestBody Product product) {
        Product saved = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
