package qu.brick.spring.web.controllers;

import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.exceptions.ResourceNotFoundException;
import qu.brick.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    private List<Product> products;
    private Integer page = 0;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8090/app/index.html
    //http://localhost:8090/app
//    @GetMapping("/products")
//    public List<Product> getAllProducts() {
//        products = productService.getAllProducts();
//        return products;
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") Integer page) {
        products = productService.getAllProducts();
        page -= 1;
        if (page >= 0) {
            this.page = page;
        }
        if (products.size() < this.page * 10 + 10) {
            return products.subList(this.page * 10, products.size());
        } else {
            return products.subList(this.page * 10, this.page * 10 + 10);
        }
    }

    @GetMapping("/products/pages")
    public List<Integer> getPages() {
        products = productService.getAllProducts();
        List<Integer> pages = new  ArrayList<>();
        for (int i = 1; i <= ((products.size() - 1) / 10 % 10) + 1; i++) {
            pages.add(i);
        }
        return pages;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @GetMapping("/products/cost_between")
    public List<Product> findProductsByCostBetween(@RequestParam(defaultValue = "0") BigInteger min, @RequestParam(defaultValue = "1000000") BigInteger max) {
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
