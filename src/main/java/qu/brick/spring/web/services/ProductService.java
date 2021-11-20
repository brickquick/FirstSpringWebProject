package qu.brick.spring.web.services;

import org.springframework.stereotype.Service;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.repositories.ProductRepository;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCost(Long studentId, Integer delta) {
        Product product = productRepository.findById(studentId);
        product.setCost(product.getCost() + delta);
    }
}
