package qu.brick.spring.web.controllers;

import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.exceptions.ResourceNotFoundException;
import qu.brick.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8090/app/index.html
    //http://localhost:8090/app
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getStudentById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    //    @PostMapping("/products/add")
    @GetMapping("/products/add")
    public List<Product> addNewProduct(@RequestParam String title, @RequestParam BigInteger cost) {
        productService.save(new Product(title, cost));
        return productService.getAllProducts();
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @GetMapping("/products/cost_between")
    public List<Product> findProductsByCostBetween(@RequestParam(defaultValue = "0") BigInteger min, @RequestParam(defaultValue = "100") BigInteger max) {
        return productService.findByCostBetween(min, max);
    }

    @GetMapping("/products/min_cost")
    public List<Product> findAllProductsByCostGreaterThan(@RequestParam(defaultValue = "0") BigInteger min) {
        return productService.findAllProductsByCostGreaterThan(min);
    }

    @GetMapping("/products/max_cost")
    public List<Product> findAllProductsByCostLessThan(@RequestParam(defaultValue = "100") BigInteger max) {
        return productService.findAllProductsByCostLessThan(max);
    }

}
