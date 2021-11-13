package qu.brick.spring.web.repositories;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Product;

import java.util.List;

@Component
public interface ProductRepository {

    Product findById(Long id);

    int getProductsSize();

    List<Product> getAllProducts();

}
