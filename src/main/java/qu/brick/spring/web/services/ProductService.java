package qu.brick.spring.web.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.exceptions.ResourceNotFoundException;
import qu.brick.spring.web.repositories.ProductRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public boolean save(Product product){
        return productRepository.save(product) != null;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to change product's cost. Product not found, id: " + productId));
        product.setCost(product.getCost().add(BigInteger.valueOf(delta)));
    }

    public List<Product> findByCostBetween(BigInteger min, BigInteger max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public List<Product> findAllProductsByCostGreaterThan(BigInteger min) {
        return productRepository.findAllProductsByCostGreaterThan(min);
    }

    public List<Product> findAllProductsByCostLessThan(BigInteger max) {
        return productRepository.findAllProductsByCostLessThan(max);
    }
}
