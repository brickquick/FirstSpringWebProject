package qu.brick.spring.web.services;

import org.springframework.stereotype.Service;
import qu.brick.spring.web.dao.ProductDao;
import qu.brick.spring.web.data.Order;
import qu.brick.spring.web.data.Product;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public void updateTitleById(Long id, String newTitle) {
        productDao.updateTitleById(id, newTitle);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productDao.findById(productId);
        product.setCost(product.getCost().add(BigInteger.valueOf(delta)));
        productDao.saveOrUpdate(product);
    }

    public List<Order> getOrdersById(Long id) {
        return productDao.getOrdersById(id);
    }

}
