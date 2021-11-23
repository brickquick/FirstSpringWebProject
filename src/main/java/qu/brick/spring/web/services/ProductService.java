package qu.brick.spring.web.services;

import org.springframework.stereotype.Service;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.repositories.inMemoryProductRepository;

import java.util.List;

@Service
public class ProductService {
    private inMemoryProductRepository inMemoryProductRepository;

    public ProductService(inMemoryProductRepository inMemoryProductRepository) {
        this.inMemoryProductRepository = inMemoryProductRepository;
    }

    public List<Product> getAllProducts() {
        return inMemoryProductRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        inMemoryProductRepository.deleteById(id);
    }

    public void changeCost(Long studentId, Integer delta) {
        Product product = inMemoryProductRepository.findById(studentId);
        product.setCost(product.getCost() + delta);
    }
}
