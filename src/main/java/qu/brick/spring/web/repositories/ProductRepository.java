package qu.brick.spring.web.repositories;

import org.springframework.stereotype.Component;
import qu.brick.spring.web.data.Product;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", BigInteger.valueOf((long) (Math.random() * 100))),
                new Product(2L, "Milk", BigInteger.valueOf((long) (Math.random() * 100))),
                new Product(3L, "Apples", BigInteger.valueOf((long) (Math.random() * 100))),
                new Product(4L, "Bananas", BigInteger.valueOf((long) (Math.random() * 100))),
                new Product(5L, "Oranges", BigInteger.valueOf((long) (Math.random() * 100)))
        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public int getProductsSize() {
        return products.size();
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public boolean addProduct(Product product) {
        if (isTitleExist(product.getTitle())) {
            return false;
        }
        product.setId((long) products.size() + 1);
        products.add(product);
        return true;
    }

    private boolean isTitleExist(String title) {
        for (Product product : products) {
            if (product.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

}
